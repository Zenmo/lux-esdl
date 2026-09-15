package energy.lux.esdl.core.iterator;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.loader.profile.GlobalProfileLoader;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.profile.TimeOfUseTariff;
import energy.lux.esdl.core.loader.pv.PVOrientationScanner;
import energy.lux.esdl.core.loader.pv.PVProfileLoader;
import energy.lux.esdl.core.loader.pv.PVSite;
import esdl.*;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zerointerfaceloader.Zero_Loader;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static energy.lux.esdl.core.util.CollectionUtil.single;

/**
 * Transform ESDL EnergySystem to a LUX EnergyModel.
 */
public class RootIterator {
    private static final Logger logger = LoggerFactory.getLogger(RootIterator.class);

    /**
     * Holds the hourly weights of the time of use tariff, for the first day of every month.
     */
    private static final String timeOfUseTariffMeasureName = "tou_tariff";

    /**
     * Switches the time of use tariff on. Both congestion scenario files carry the same
     * tariff and differ only in this measure.
     */
    private static final String congestionSignalMeasureName = "congestion management active";

    /**
     * How much weather a file has to carry before its PV production can be modelled at all.
     * <p>
     * LUX repeats a profile that runs out before the simulation does. For a full year of
     * weather that lands on the same day of the year, so the repetition is harmless. For less
     * than a year it is not: tue.esdl carries three days of August, and modelling the whole
     * year on those yields an August output in January.
     * <p>
     * A day of slack rather than a full 365, because a year of measurements tends to end just
     * short of one: BU31_veelflex_vTimeSeries.esdl stops at 23:50 on the 31st of December, one
     * ten-minute sample shy of the year. Wrapping by a quarter of an hour costs nothing, while
     * anything that repeats often enough to move weather between seasons is still caught.
     */
    private static final Duration shortestUsableIrradiance = Duration.ofDays(364);

    /**
     * LUX {@link EnergyModel} is a property of the loader {@link Zero_Loader}.
     * The loader is passed because it might have some useful methods.
     */
    public static void loadEsdlIntoLux(
            EnergySystem esdlEnergySystem,
            Zero_Loader luxLoader
    ) {
        var solarIrradiance = loadEnvironmentalProfiles(esdlEnergySystem.getEnergySystemInformation(), luxLoader);
        loadParties(esdlEnergySystem.getParties(), luxLoader);
        var timeOfUseTariff = readTimeOfUseTariff(esdlEnergySystem.getMeasures());
        loadServices(esdlEnergySystem.getServices(), luxLoader, timeOfUseTariff);

        var instance = single(esdlEnergySystem.getInstance(), Instance.class.getName());

        Area area = instance.getArea();
        if (area == null) {
            throw new EsdlException("No area in energy system");
        }

        // One registry for the whole file so that a profile shared by several grid connections
        // is only handed to the LUX engine once.
        var profilePointerRegistry = new ProfilePointerRegistry(luxLoader.energyModel);

        // Before the traversal, so that loading a PV installation is only a lookup.
        generatePVProfiles(area, profilePointerRegistry, solarIrradiance);

        AreaIterator.loadArea(area, luxLoader, profilePointerRegistry);

        verifyNumberOfGridConnections(area, luxLoader.energyModel);
    }

    /**
     * Check that all the grid connections in the ESDL were added.
     */
    private static void verifyNumberOfGridConnections(
            Area area,
            EnergyModel luxEngine
    ) {
        var esdlGridConnectionIds = allEsdlGridConnectionIds(area);
        var luxGridConnectionIds = allLuxGridConnectionIds(luxEngine);

        var uniqueEsdlIds = new HashSet<>(esdlGridConnectionIds);
        if (uniqueEsdlIds.size() != esdlGridConnectionIds.size()) {
            throw new EsdlException("Duplicate grid connection IDs found in ESDL model");
        }

        var uniqueLuxIds = new HashSet<>(luxGridConnectionIds);
        if (uniqueLuxIds.size() != luxGridConnectionIds.size()) {
            throw new EsdlException("Duplicate grid connection IDs found in LUX model");
        }

        var missingGcIds = new HashSet<>(uniqueEsdlIds);
        missingGcIds.removeAll(uniqueLuxIds);
        if (!missingGcIds.isEmpty()) {
            throw new EsdlException(
                    String.format(
                            "%d grid connections were in the ESDL but not created in LUX. ID's: %s",
                            missingGcIds.size(),
                            String.join(", ", missingGcIds)
                    )
            );
        }
    }

    private static List<String> allEsdlGridConnectionIds(Area area) {
        var connectionIds = new ArrayList<String>();
        TreeIterator<EObject> iterator = area.eAllContents();

        while (iterator.hasNext()) {
            EObject eObject = iterator.next();
            if (eObject instanceof EConnection connection) {
                String id = connection.getId();
                if (id != null) {
                    connectionIds.add(id);
                }
            }
        }
        return connectionIds;
    }

    private static List<String> allLuxGridConnectionIds(EnergyModel luxEngine) {
        return luxEngine.c_gridConnections.stream()
                .map(gn -> gn.p_gridConnectionID)
                .toList();
    }

    /**
     * Check that all the grid nodes in the ESDL were added.
     */
    private static void verifyNumberOfGridNodes(
            Area area,
            EnergyModel luxEngine
    ) {
        var esdlGridNodeIds = allEsdlGridNodeIds(area);
        var allLuxGridNodeIds = allLuxGridNodeIds(luxEngine);

        var uniqueEsdlIds = new HashSet<>(esdlGridNodeIds);
        if (uniqueEsdlIds.size() != esdlGridNodeIds.size()) {
            throw new EsdlException("Duplicate grid node IDs found in ESDL model");
        }

        var uniqueLuxIds = new HashSet<>(allLuxGridNodeIds);
        if (uniqueLuxIds.size() != allLuxGridNodeIds.size()) {
            throw new EsdlException("Duplicate grid node IDs found in LUX model");
        }

        var missingGcIds = new HashSet<>(uniqueEsdlIds);
        missingGcIds.removeAll(uniqueLuxIds);
        if (!missingGcIds.isEmpty()) {
            throw new EsdlException(
                    String.format(
                            "%d grid node were in the ESDL but not created in LUX. ID's: %s",
                            missingGcIds.size(),
                            String.join(", ", missingGcIds)
                    )
            );
        }
    }

    private static List<String> allEsdlGridNodeIds(Area area) {
        var nodeIds = new ArrayList<String>();
        TreeIterator<EObject> iterator = area.eAllContents();

        while (iterator.hasNext()) {
            EObject eObject = iterator.next();
            if (eObject instanceof Import importAsset) {
                String id = importAsset.getId();
                if (id != null) {
                    nodeIds.add(id);
                }
            }

            if (eObject instanceof Transformer transformer) {
                String id = transformer.getId();
                if (id != null) {
                    nodeIds.add(id);
                }
            }
        }
        return nodeIds;
    }

    private static List<String> allLuxGridNodeIds(EnergyModel luxEngine) {
        return luxEngine.pop_gridNodes.stream()
                .map(gc -> gc.p_gridNodeID)
                .toList();
    }

    /**
     * @return the solar irradiance to model PV production from, or null when the ESDL has none
     */
    private static ArrayTimeSeries loadEnvironmentalProfiles(
            EnergySystemInformation info,
            Zero_Loader luxLoader
    ) {
        if (info == null) return null;
        EnvironmentalProfiles environmentalProfiles = info.getEnvironmentalProfiles();
        if (environmentalProfiles == null) return null;

        var profileLoader = new GlobalProfileLoader(luxLoader);
        profileLoader.loadOutsideTemperature(environmentalProfiles);
        var solarIrradiance = profileLoader.readSolarIrradiance(environmentalProfiles);

        if (environmentalProfiles.getSoilTemperatureProfile() != null) {
            logger.info("Skipping soil temperature profile, not implemented in LUX");
        }

        return solarIrradiance;
    }

    /**
     * Model a PV production profile for every orientation the file uses, before any asset is
     * loaded, so that loading a PV installation only has to look one up.
     * <p>
     * Without irradiance there is nothing to model from. That is not an error: the older files
     * carry no weather at all, and PV then falls back to the profiles that LUX ships with.
     */
    private static void generatePVProfiles(
            Area area,
            ProfilePointerRegistry profilePointerRegistry,
            ArrayTimeSeries solarIrradiance
    ) {
        var orientations = PVOrientationScanner.scanOrientations(area);
        if (orientations.isEmpty()) {
            return;
        }

        if (solarIrradiance == null) {
            logger.warn(
                    "The ESDL describes PV but states no solar irradiance,"
                            + " falling back to the default PV profiles of LUX"
            );
            return;
        }

        var irradianceDuration = Duration.between(
                Instant.from(solarIrradiance.getStart()),
                Instant.from(solarIrradiance.getEnd())
        );
        if (irradianceDuration.compareTo(shortestUsableIrradiance) < 0) {
            throw new EsdlException(
                    "The solar irradiance of the ESDL covers " + irradianceDuration
                            + ", which is less than the year that is simulated."
                            + " LUX repeats a profile that runs out, so the PV production of"
                            + " every season would be modelled on this one stretch of weather."
                            + " Give the ESDL a full year of irradiance,"
                            + " or remove its PV installations."
            );
        }

        PVProfileLoader.generateAndRegister(
                profilePointerRegistry,
                PVSite.cabauw(),
                solarIrradiance,
                orientations
        );
    }

    private static void loadParties(Parties parties, Zero_Loader luxLoader) {
        if (parties == null) return;
        for (Party party : parties.getParty()) {
            // TODO: handle party (e.g. DSO)
        }
    }

    /**
     * @return the tariff that this scenario charges on top of the market price,
     *         or null when it charges none.
     */
    private static TimeOfUseTariff readTimeOfUseTariff(Measures measures) {
        if (measures == null) {
            return null;
        }

        if (!isCongestionSignalActive(measures)) {
            logger.info(
                    "Measure '{}' is not True, so no time of use tariff is charged",
                    congestionSignalMeasureName
            );
            return null;
        }

        var costInformation = findCostInformation(measures, timeOfUseTariffMeasureName);
        if (costInformation == null) {
            logger.warn(
                    "Measure '{}' is True but there is no '{}' measure to take the tariff from",
                    congestionSignalMeasureName,
                    timeOfUseTariffMeasureName
            );
            return null;
        }

        var tariffProfile = costInformation.getVariableOperationalCosts();
        if (!(tariffProfile instanceof DateTimeProfile dateTimeProfile)) {
            throw new NotImplemented(
                    "Expected the variable operational costs of the time of use tariff to be a"
                            + " DateTimeProfile, found " + tariffProfile
            );
        }

        return TimeOfUseTariff.fromProfile(dateTimeProfile);
    }

    private static boolean isCongestionSignalActive(Measures measures) {
        var measure = findMeasure(measures, congestionSignalMeasureName);
        if (measure == null) {
            return false;
        }
        return Boolean.parseBoolean(measure.getDescription());
    }

    private static CostInformation findCostInformation(Measures measures, String measureName) {
        var measure = findMeasure(measures, measureName);
        return measure == null ? null : measure.getCostInformation();
    }

    private static Measure findMeasure(Measures measures, String measureName) {
        for (AbstractMeasure abstractMeasure : measures.getMeasure()) {
            if (abstractMeasure instanceof Measure measure
                    && measureName.equals(measure.getName())) {
                return measure;
            }
        }
        return null;
    }

    private static void loadServices(
            Services services,
            Zero_Loader luxLoader,
            TimeOfUseTariff timeOfUseTariff
    ) {
        if (services == null) return;
        for (Service service : services.getService()) {
            if (service instanceof EnergyMarket energyMarket) {
                var profileLoader = new GlobalProfileLoader(luxLoader);
                profileLoader.loadDayAheadElectricityPricing(energyMarket, timeOfUseTariff);
            } else {
                logger.warn("Loading ESDL service type {} not implemented", service.getClass());
            }
        }
    }
}
