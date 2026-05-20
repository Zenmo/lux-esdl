package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import energy.lux.esdl.Util;
import esdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.util.HashSet;
import java.util.Set;

public class AreaLoader {
    private static final Logger logger = LoggerFactory.getLogger(AreaLoader.class);

    static void loadArea(Area area, Zero_Loader luxLoader) {
        // assumption: import asset is the root of the area network
        var importAsset = findImportAsset(area);
        var rootGridNode = loadImportAsset(importAsset, luxLoader);
        traverseNetworkFromAsset(importAsset, luxLoader, rootGridNode, new HashSet<>());

        for (Area ignored : area.getArea()) {
            throw new NotImplemented("Nested areas are not supported yet");
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
            GridConnectionLoader.loadGridConnection(eConnection, luxLoader, currentGridNode);
        } else {
            throw new NotImplemented(
                    "Unexpected asset type in network traversal: " + Util.printItem(asset)
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

    private static Import findImportAsset(Area area) {
        var importAsset = (Import) Util.findSingle(
                area.getAsset(),
                asset -> asset instanceof Import,
                "import asset"
        );

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
