package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import esdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class AreaLoader {
    private static final Logger logger = LoggerFactory.getLogger(AreaLoader.class);

    static void loadArea(Area area, Zero_Loader luxLoader) {
        // assumption: import asset is the root of the area network
        var importAsset = findImportAsset(area);
        var rootGridNode = loadImportAsset(importAsset, luxLoader);
        traverseNetworkFromAsset(importAsset, luxLoader, rootGridNode, new HashSet<>());

        for (Area ignored : area.getArea()) {
            throw new NoSuchElementException("Nested areas are not supported yet");
        }
    }

    private static void traverseNetworkFromAsset(
            EnergyAsset asset, Zero_Loader luxLoader, GridNode currentGridNode, Set<String> visitedPortIds
    ) {
        for (Port port : asset.getPort()) {
            if (!(port instanceof OutPort outPort)) continue;
            if (!visitedPortIds.add(outPort.getId())) continue;
            for (InPort connectedInPort : outPort.getConnectedTo()) {
                EnergyAsset nextAsset = connectedInPort.getEnergyasset();
                processNetworkAsset(nextAsset, luxLoader, currentGridNode, visitedPortIds);
            }
        }
    }

    private static void processNetworkAsset(
            EnergyAsset asset, Zero_Loader luxLoader, GridNode currentGridNode, Set<String> visitedPortIds
    ) {
        if (asset instanceof Import) {
            // Do not traverse backwards to Import
        } else if (asset instanceof ElectricityCable) {
            traverseNetworkFromAsset(asset, luxLoader, currentGridNode, visitedPortIds);
        } else if (asset instanceof Joint) {
            traverseNetworkFromAsset(asset, luxLoader, currentGridNode, visitedPortIds);
        } else if (asset instanceof Transformer transformer) {
            var childGridNode = createGridNodeForTransformer(transformer, luxLoader);
            traverseNetworkFromAsset(asset, luxLoader, childGridNode, visitedPortIds);
        } else if (asset instanceof EConnection eConnection) {
            var gridConnection = createGridConnectionForEConnection(eConnection, luxLoader, currentGridNode);
            traverseInsideGridConnection(eConnection, luxLoader, gridConnection, new HashSet<>(), new HashSet<>());
        } else {
            throw new NotImplemented(
                    "Unexpected asset type in network traversal: "
                            + asset.getClass().getSimpleName() + " id=" + asset.getId()
            );
        }
    }

    private static GridNode createGridNodeForTransformer(Transformer transformer, Zero_Loader luxLoader) {
        EnergyModel energyModel = luxLoader.energyModel;
        var gridNode = energyModel.add_pop_gridNodes();
        gridNode.p_gridNodeID = transformer.getId();
        gridNode.p_description = transformer.getName();
        gridNode.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;
        return gridNode;
    }

    private static GridConnection createGridConnectionForEConnection(
            EConnection eConnection, Zero_Loader luxLoader, GridNode parentGridNode
    ) {
        EnergyModel energyModel = luxLoader.energyModel;
        var gridConnection = energyModel.add_pop_gridConnections();
        gridConnection.p_gridConnectionID = eConnection.getId();
        gridConnection.p_parentNodeElectricID = parentGridNode.p_gridNodeID;
        return gridConnection;
    }

    private static void traverseInsideGridConnection(
            EnergyAsset asset,
            Zero_Loader luxLoader,
            GridConnection gridConnection,
            Set<String> visitedPortIds,
            Set<String> processedAssetIds
    ) {
        for (Port port : asset.getPort()) {
            if (!(port instanceof OutPort outPort)) continue;
            if (!visitedPortIds.add(outPort.getId())) continue;
            for (InPort connectedInPort : outPort.getConnectedTo()) {
                EnergyAsset nextAsset = connectedInPort.getEnergyasset();
                processGridConnectionAsset(nextAsset, luxLoader, gridConnection, visitedPortIds, processedAssetIds);
            }
        }
    }

    private static void processGridConnectionAsset(
            EnergyAsset asset,
            Zero_Loader luxLoader,
            GridConnection gridConnection,
            Set<String> visitedPortIds,
            Set<String> processedAssetIds
    ) {
        if (asset instanceof ElectricityNetwork network) {
            loadGeneratorsConnectedToElectricityNetwork(network, luxLoader, gridConnection, visitedPortIds, processedAssetIds);
            traverseInsideGridConnection(network, luxLoader, gridConnection, visitedPortIds, processedAssetIds);
        } else if (asset instanceof ElectricityDemand demand) {
            if (processedAssetIds.add(demand.getId())) {
                loadElectricityDemand(demand, luxLoader, gridConnection);
            }
        } else if (asset instanceof EVChargingStation evStation) {
            if (processedAssetIds.add(evStation.getId())) {
                GridConnectionAssetLoader.loadEVChargingStation(evStation, luxLoader, gridConnection);
            }
        } else if (asset instanceof HybridHeatPump heatPump) {
            if (processedAssetIds.add(heatPump.getId())) {
                GridConnectionAssetLoader.loadHybridHeatPump(heatPump, luxLoader, gridConnection);
            }
        } else {
            throw new NotImplemented(
                    "Unexpected asset type in grid connection traversal: "
                            + asset.getClass().getSimpleName() + " id=" + asset.getId()
            );
        }
    }

    private static void loadGeneratorsConnectedToElectricityNetwork(
            ElectricityNetwork network,
            Zero_Loader luxLoader,
            GridConnection gridConnection,
            Set<String> visitedPortIds,
            Set<String> processedAssetIds
    ) {
        for (Port port : network.getPort()) {
            if (!(port instanceof InPort inPort)) continue;
            for (OutPort connectedOutPort : inPort.getConnectedTo()) {
                EnergyAsset sourceAsset = connectedOutPort.getEnergyasset();
                if (sourceAsset instanceof EConnection) continue;
                if (!visitedPortIds.add(connectedOutPort.getId())) continue;
                if (sourceAsset instanceof PVInstallation pv) {
                    if (processedAssetIds.add(pv.getId())) {
                        GridConnectionAssetLoader.loadPVInstallation(pv, luxLoader, gridConnection);
                    }
                } else {
                    throw new NotImplemented(
                            "Unexpected generator connected to ElectricityNetwork: "
                                    + sourceAsset.getClass().getSimpleName() + " id=" + sourceAsset.getId()
                    );
                }
            }
        }
    }

    private static void loadElectricityDemand(
            ElectricityDemand demand, Zero_Loader luxLoader, GridConnection gridConnection
    ) {
        var dateTimeProfile = findFirstDateTimeProfile(demand);
        if (dateTimeProfile == null) {
            logger.warn("No DateTimeProfile found for ElectricityDemand id={}, skipping", demand.getId());
            return;
        }
        var profilePointer = DateTimeProfileLoader.createProfilePointer(
                luxLoader,
                dateTimeProfile,
                demand.getId() + "_demand",
                OL_ProfileUnits.KWHPQUARTERHOUR
        );
        var demandAsset = new J_EAProfile(
                gridConnection,
                OL_EnergyCarriers.ELECTRICITY,
                profilePointer,
                OL_AssetFlowCategories.fixedConsumptionElectric_kW,
                luxLoader.energyModel.p_timeParameters
        );
        demandAsset.setEnergyAssetName(demand.getName());
    }

    private static DateTimeProfile findFirstDateTimeProfile(EnergyAsset asset) {
        for (Port port : asset.getPort()) {
            for (GenericProfile profile : port.getProfile()) {
                if (profile instanceof DateTimeProfile dateTimeProfile) {
                    return dateTimeProfile;
                }
            }
        }
        return null;
    }

    private static Import findImportAsset(Area area) {
        var imports = area.getAsset().stream().filter(asset -> asset instanceof Import).toList();
        Import importAsset = switch (imports.size()) {
            case 0 -> throw new NoSuchElementException("No import asset found");
            case 1 -> (Import) imports.get(0);
            default -> throw new NoSuchElementException("Multiple import assets found");
        };

        assertImportAssetHasNoInPorts(importAsset);

        return importAsset;
    }

    private static void assertImportAssetHasNoInPorts(Import importAsset) {
        for (Port port : importAsset.getPort()) {
            if (port instanceof InPort) {
                throw new NotImplemented(
                        "Expected import to be the root asset, but it has an InPort with ID: "
                                + port.getId()
                );
            }
        }
    }

    private static GridNode loadImportAsset(Import importAsset, Zero_Loader luxLoader) {
        EnergyModel energyModel = luxLoader.energyModel;

        var gridNode = energyModel.add_pop_gridNodes();
        gridNode.p_gridNodeID = importAsset.getId();
        gridNode.p_description = importAsset.getName() + ", " + importAsset.getDescription();
        gridNode.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;

        return gridNode;
    }
}
