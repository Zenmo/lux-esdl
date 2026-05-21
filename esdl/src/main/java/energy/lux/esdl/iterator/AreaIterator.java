package energy.lux.esdl.iterator;

import energy.lux.esdl.NotImplemented;
import energy.lux.esdl.util.CollectionUtil;
import energy.lux.esdl.util.Util;
import energy.lux.esdl.loader.GridConnectionLoader;
import energy.lux.esdl.loader.GridNodeLoader;
import esdl.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.internal.compiler.env.IModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.util.HashSet;
import java.util.Set;

public class AreaIterator {
    private static final Logger logger = LoggerFactory.getLogger(AreaIterator.class);

    public static void loadArea(Area area, Zero_Loader luxLoader) {
        // assumption: import asset is the root of the area network
        var importAsset = findImportAsset(area);
        var rootGridNode = GridNodeLoader.loadImportAsset(importAsset, luxLoader.energyModel);
        processNetworkAsset(importAsset, luxLoader, rootGridNode, new HashSet<>());

        for (Area ignored : area.getArea()) {
            throw new NotImplemented("Nested areas are not supported yet");
        }
    }

    /**
     * When entering a port for the first time from another port
     */
    private static void processEntryPort(
            Port entryPort,
            Zero_Loader luxLoader,
            GridNode gridNode,
            Set<EnergyAsset> visitedAssets
    ) {
        processNetworkAsset(entryPort.getEnergyasset(), luxLoader, gridNode, visitedAssets);
    }

    /**
     * When leaving an asset via the ports
     */
    private static void processExitPorts(
            EList<Port> exitPorts,
            Zero_Loader luxLoader,
            GridNode gridNode,
            Set<EnergyAsset> visitedAssets
    ) {
        for (Port port : exitPorts) {
            if (port instanceof OutPort outPort) {
                for (InPort connectedInPort : outPort.getConnectedTo()) {
                    processEntryPort(connectedInPort, luxLoader, gridNode, visitedAssets);
                }
            }

            if (port instanceof InPort inPort) {
                for (OutPort connectedOutPort : inPort.getConnectedTo()) {
                    processEntryPort(connectedOutPort, luxLoader, gridNode, visitedAssets);
                }
            }
        }
    }

    private static void processNetworkAsset(
            EnergyAsset asset,
            Zero_Loader luxLoader,
            GridNode currentGridNode,
            Set<EnergyAsset> visitedAssets
    ) {
        if (visitedAssets.contains(asset)) {
            return;
        }
        visitedAssets.add(asset);

        if (asset instanceof Import) {
            processExitPorts(asset.getPort(), luxLoader, currentGridNode, visitedAssets);
        } else if (asset instanceof ElectricityCable) {
            processExitPorts(asset.getPort(), luxLoader, currentGridNode, visitedAssets);
        } else if (asset instanceof Joint) {
            processExitPorts(asset.getPort(), luxLoader, currentGridNode, visitedAssets);
        } else if (asset instanceof Transformer transformer) {
            var childGridNode = GridNodeLoader.loadTransformer(transformer, luxLoader.energyModel);
            processExitPorts(asset.getPort(), luxLoader, childGridNode, visitedAssets);
        } else if (asset instanceof EConnection eConnection) {
            GridConnectionLoader.loadGridConnection(eConnection, luxLoader, currentGridNode);
            // Do not traverse further
        } else {
            throw new NotImplemented(
                    "Unexpected asset type in network traversal: " + Util.printItem(asset)
            );
        }
    }

    private static Import findImportAsset(Area area) {
        var importAsset = (Import) CollectionUtil.findSingle(
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
}
