package energy.lux.esdl.iterator;

import energy.lux.esdl.EsdlException;
import energy.lux.esdl.loader.DateTimeProfileLoader;
import esdl.*;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zerointerfaceloader.Zero_Loader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static energy.lux.esdl.util.CollectionUtil.single;

/**
 * Transform ESDL EnergySystem to a LUX EnergyModel.
 */
public class RootIterator {
    private static final Logger logger = LoggerFactory.getLogger(RootIterator.class);

    /**
     * LUX {@link EnergyModel} is a property of the loader {@link Zero_Loader}.
     * The loader is passed because it might have some useful methods.
     */
    public static void loadEsdlIntoLux(
            EnergySystem esdlEnergySystem,
            Zero_Loader luxLoader
    ) {
        loadEnvironmentalProfiles(esdlEnergySystem.getEnergySystemInformation(), luxLoader);
        loadParties(esdlEnergySystem.getParties(), luxLoader);
        loadMeasures(esdlEnergySystem.getMeasures(), luxLoader);
        loadServices(esdlEnergySystem.getServices(), luxLoader);

        var instance = single(esdlEnergySystem.getInstance(), Instance.class.getName());

        Area area = instance.getArea();
        if (area == null) {
            throw new EsdlException("No area in energy system");
        }

        AreaIterator.loadArea(area, luxLoader);

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

    private static void loadEnvironmentalProfiles(
            EnergySystemInformation info,
            Zero_Loader luxLoader
    ) {
        if (info == null) return;
        EnvironmentalProfiles environmentalProfiles = info.getEnvironmentalProfiles();
        if (environmentalProfiles == null) return;

        DateTimeProfileLoader.loadOutsideTemperature(environmentalProfiles, luxLoader);
        DateTimeProfileLoader.loadSolarIrradiance(environmentalProfiles, luxLoader);

        if (environmentalProfiles.getSoilTemperatureProfile() != null) {
            logger.info("Skipping soil temperature profile, not implemented in LUX");
        }
    }

    private static void loadParties(Parties parties, Zero_Loader luxLoader) {
        if (parties == null) return;
        for (Party party : parties.getParty()) {
            // TODO: handle party (e.g. DSO)
        }
    }

    private static void loadMeasures(Measures measures, Zero_Loader luxLoader) {
        if (measures == null) return;
        for (AbstractMeasure abstractMeasure : measures.getMeasure()) {
            if (abstractMeasure instanceof Measure measure) {
                CostInformation costInfo = measure.getCostInformation();
                // TODO: use cost information (e.g. bandwidth tariff prices)
            }
        }
    }

    private static void loadServices(Services services, Zero_Loader luxLoader) {
        if (services == null) return;
        for (Service service : services.getService()) {
            if (service instanceof EnergyMarket energyMarket) {
                DateTimeProfileLoader.loadDayAheadElectricityPricing(energyMarket, luxLoader);
            } else {
                logger.warn("Loading ESDL service type {} not implemented", service.getClass());
            }
        }
    }
}
