package energy.lux.esdl.core.iterator;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.loader.profile.GlobalProfileLoader;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.profile.TimeOfUseTariff;
import energy.lux.esdl.core.loader.profile.Weather;
import energy.lux.esdl.core.loader.pv.PVOrientationScanner;
import energy.lux.esdl.core.loader.pv.PVProfileLoader;
import energy.lux.esdl.core.loader.pv.PVSite;
import esdl.*;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import energy.lux.engine.EnergyModel;
import energy.lux.engine.managementclasses.aggregatormanagements.aggregatorenergymanagements.J_ISIE_Aggregator_EMS;
import energy.lux.esdl.core.LuxModelBuilder;

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

    private static final String timeOfUseTariffMeasureName = "tou_tariff";
    /**
     * The ESDL renamed this measure from spaces to underscores in September 2026 and both
     * spellings are in circulation, so both are accepted. Reading only one of them is not a
     * harmless miss: an unrecognised name is indistinguishable from an absent measure, so a file
     * that switches the measure on would be read as switching it off.
     */
    private static final List<String> localDynamicMeasureNames = List.of(
            "congestion management active",
            "congestion_management_active"
    );
    private static final double localDynamicCongestionFactor_eurpMWhpkW = 1000.0;
    private static final Duration shortestUsableIrradiance = Duration.ofDays(364);

    public static void loadEsdlIntoLux(
            EnergySystem esdlEnergySystem,
            LuxModelBuilder luxModelBuilder
    ) {
        Measures measures = esdlEnergySystem.getMeasures();

        var weather = loadEnvironmentalProfiles(esdlEnergySystem.getEnergySystemInformation(), luxModelBuilder);
        loadParties(esdlEnergySystem.getParties(), luxModelBuilder);
        loadServices(esdlEnergySystem.getServices(), luxModelBuilder, readTimeOfUseTariff(measures));

        var instance = single(esdlEnergySystem.getInstance(), Instance.class.getName());

        Area area = instance.getArea();
        if (area == null) {
            throw new EsdlException("No area in energy system");
        }

        // One registry for the whole file so that a profile shared by several grid connections
        // is only handed to the LUX engine once.
        var profilePointerRegistry = new ProfilePointerRegistry(luxModelBuilder.energyModel);

        // Before the traversal, so that loading a PV installation is only a lookup.
        generatePVProfiles(area, profilePointerRegistry, weather);

        AreaIterator.loadArea(area, luxModelBuilder, profilePointerRegistry);

        // After the traversal, which is where the aggregators it acts on are created.
        loadLocalDynamicMeasure(measures, luxModelBuilder.energyModel);

        verifyNumberOfGridConnections(area, luxModelBuilder.energyModel);
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
     * Return the weather to model PV production from, empty when the ESDL states none.
     * The outside temperature is registered with the engine on the way through, the irradiance
     * is not: LUX has no use for it beyond the panels.
     */
    private static Weather loadEnvironmentalProfiles(
            EnergySystemInformation info,
            LuxModelBuilder luxModelBuilder
    ) {
        if (info == null) return Weather.none();
        EnvironmentalProfiles environmentalProfiles = info.getEnvironmentalProfiles();
        if (environmentalProfiles == null) return Weather.none();

        var profileLoader = new GlobalProfileLoader(luxModelBuilder);
        var outsideTemperature_degC = profileLoader.loadOutsideTemperature(environmentalProfiles);
        var globalHorizontalIrradiance_wpm2 = profileLoader.readSolarIrradiance(environmentalProfiles);

        if (environmentalProfiles.getSoilTemperatureProfile() != null) {
            logger.info("Skipping soil temperature profile, not implemented in LUX");
        }

        return new Weather(globalHorizontalIrradiance_wpm2, outsideTemperature_degC);
    }

    /**
     * Model a PV production profile for every orientation the file uses, before any asset is
     * loaded, so that loading a PV installation only has to look one up.
     */
    private static void generatePVProfiles(
            Area area,
            ProfilePointerRegistry profilePointerRegistry,
            Weather weather
    ) {
        var orientations = PVOrientationScanner.scanOrientations(area);
        if (orientations.isEmpty()) {
            return;
        }

        var globalHorizontalIrradiance_wpm2 = weather.globalHorizontalIrradiance_wpm2();
        if (globalHorizontalIrradiance_wpm2 == null) {
            logger.warn(
                    "The ESDL describes PV but states no solar irradiance,"
                            + " falling back to the default PV profiles of LUX"
            );
            return;
        }

        var irradianceDuration = Duration.between(
                Instant.from(globalHorizontalIrradiance_wpm2.getStart()),
                Instant.from(globalHorizontalIrradiance_wpm2.getEnd())
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
                weather,
                orientations
        );
    }

    private static void loadParties(Parties parties, LuxModelBuilder luxModelBuilder) {
        if (parties == null) return;
        for (Party party : parties.getParty()) {
            // TODO: handle party (e.g. DSO)
        }
    }

    /**
     * The tariff is charged whenever the ESDL states one. A scenario that charges none states
     * weights of zero rather than leaving the measure out, so there is no switch to read.
     *
     * @return the tariff that this scenario charges on top of the market price,
     *         or null when the ESDL states none.
     */
    private static TimeOfUseTariff readTimeOfUseTariff(Measures measures) {
        if (measures == null) {
            return null;
        }

        var costInformation = findCostInformation(measures, timeOfUseTariffMeasureName);
        if (costInformation == null) {
            logger.info(
                    "The ESDL has no '{}' measure, so no time of use tariff is charged",
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

    /**
     * LUX has no local dynamic measure of its own, so it is modelled as the congestion factor of
     * the aggregators.
     */
    private static void loadLocalDynamicMeasure(Measures measures, EnergyModel luxEngine) {
        setCongestionFactor(
                luxEngine,
                isLocalDynamicMeasureActive(measures) ? localDynamicCongestionFactor_eurpMWhpkW : 0.0
        );
    }

    private static boolean isLocalDynamicMeasureActive(Measures measures) {
        var measure = measures == null ? null : findFirstMeasure(measures, localDynamicMeasureNames);
        if (measure == null) {
            logger.warn(
                    "The ESDL states none of the measures {}, so the local dynamic measure is read"
                            + " as inactive and the aggregators price no congestion",
                    localDynamicMeasureNames
            );
            return false;
        }
        return Boolean.parseBoolean(measure.getDescription());
    }

    /**
     * The congestion factor is what the aggregator charges for every kW its grid node draws above
     * the deadzone of the transformer. Every grid node has an aggregator of its own, so all of
     * them are set.
     */
    private static void setCongestionFactor(EnergyModel luxEngine, double congestionFactor_eurpMWhpkW) {
        var aggregators = 0;
        for (var energyCoop : luxEngine.pop_energyCoops) {
            if (energyCoop.f_getAggregatorEnergyManagement() instanceof J_ISIE_Aggregator_EMS aggregator) {
                aggregator.setCongestionFactor(congestionFactor_eurpMWhpkW);
                aggregators++;
            }
        }

        logger.info(
                "Set the congestion factor of {} aggregators to {} EUR/MWh/kW",
                aggregators,
                congestionFactor_eurpMWhpkW
        );
    }

    private static CostInformation findCostInformation(Measures measures, String measureName) {
        var measure = findMeasure(measures, measureName);
        return measure == null ? null : measure.getCostInformation();
    }

    /**
     * @return the first measure carrying any of these names, or null when the ESDL has none of them.
     */
    private static Measure findFirstMeasure(Measures measures, List<String> measureNames) {
        for (String measureName : measureNames) {
            var measure = findMeasure(measures, measureName);
            if (measure != null) {
                return measure;
            }
        }
        return null;
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
            LuxModelBuilder luxModelBuilder,
            TimeOfUseTariff timeOfUseTariff
    ) {
        if (services == null) return;
        for (Service service : services.getService()) {
            if (service instanceof EnergyMarket energyMarket) {
                var profileLoader = new GlobalProfileLoader(luxModelBuilder);
                profileLoader.loadDayAheadElectricityPricing(energyMarket, timeOfUseTariff);
            } else {
                logger.warn("Loading ESDL service type {} not implemented", service.getClass());
            }
        }
    }
}
