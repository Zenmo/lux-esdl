package energy.lux.esdl.core.iterator;

import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.CollectionUtil;
import energy.lux.esdl.core.util.Util;
import energy.lux.esdl.core.loader.GridConnectionLoader;
import energy.lux.esdl.core.loader.GridNodeLoader;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import esdl.*;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import energy.lux.engine.actors.EnergyCoop;
import energy.lux.engine.EnergyModel;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.GridNode;
import energy.lux.engine.managementclasses.aggregatormanagements.aggregatorenergymanagements.J_ISIE_Aggregator_EMS;
import energy.lux.esdl.core.LuxModelBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AreaIterator {
    private static final Logger logger = LoggerFactory.getLogger(AreaIterator.class);

    public static void loadArea(Area area, LuxModelBuilder luxModelBuilder, ProfilePointerRegistry profilePointerRegistry) {
        // assumption: import asset is the root of the area network
        var importAsset = findImportAsset(area);
        var rootGridNode = GridNodeLoader.loadImportAsset(importAsset, luxModelBuilder.energyModel);
        processNetworkAsset(importAsset, luxModelBuilder, rootGridNode, new HashSet<>(), profilePointerRegistry);

        for (Area ignored : area.getArea()) {
            throw new NotImplemented("Nested areas are not supported yet");
        }
    }

    /**
     * When entering a port for the first time from another port
     */
    private static void processEntryPort(
            Port entryPort,
            LuxModelBuilder luxModelBuilder,
            GridNode gridNode,
            Set<EnergyAsset> visitedAssets,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        processNetworkAsset(entryPort.getEnergyasset(), luxModelBuilder, gridNode, visitedAssets, profilePointerRegistry);
    }

    /**
     * When leaving an asset via the ports
     */
    private static void processExitPorts(
            EList<Port> exitPorts,
            LuxModelBuilder luxModelBuilder,
            GridNode gridNode,
            Set<EnergyAsset> visitedAssets,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        for (Port port : exitPorts) {
            if (port instanceof OutPort outPort) {
                for (InPort connectedInPort : outPort.getConnectedTo()) {
                    processEntryPort(connectedInPort, luxModelBuilder, gridNode, visitedAssets, profilePointerRegistry);
                }
            }

            if (port instanceof InPort inPort) {
                for (OutPort connectedOutPort : inPort.getConnectedTo()) {
                    processEntryPort(connectedOutPort, luxModelBuilder, gridNode, visitedAssets, profilePointerRegistry);
                }
            }
        }
    }

    private static void processNetworkAsset(
            EnergyAsset asset,
            LuxModelBuilder luxModelBuilder,
            GridNode currentGridNode,
            Set<EnergyAsset> visitedAssets,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        if (visitedAssets.contains(asset)) {
            return;
        }
        visitedAssets.add(asset);

        if (asset instanceof Import) {
            processExitPorts(asset.getPort(), luxModelBuilder, currentGridNode, visitedAssets, profilePointerRegistry);
        } else if (asset instanceof ElectricityCable) {
            processExitPorts(asset.getPort(), luxModelBuilder, currentGridNode, visitedAssets, profilePointerRegistry);
        } else if (asset instanceof Joint) {
            processExitPorts(asset.getPort(), luxModelBuilder, currentGridNode, visitedAssets, profilePointerRegistry);
        } else if (asset instanceof Transformer transformer) {
            var childGridNode = GridNodeLoader.loadTransformer(transformer, luxModelBuilder.energyModel, currentGridNode);
            processExitPorts(asset.getPort(), luxModelBuilder, childGridNode, visitedAssets, profilePointerRegistry);
            // Create EnergyCoop for the GridNode. This Coop represents the aggregator that manages external setpoints of EV & Battery assets.
            addEnergyCoopToGridNode(luxModelBuilder, childGridNode);
        } else if (asset instanceof EConnection eConnection) {
            GridConnectionLoader.loadGridConnection(eConnection, luxModelBuilder, currentGridNode, profilePointerRegistry);
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

    private static void addEnergyCoopToGridNode(LuxModelBuilder luxModelBuilder, GridNode gridNode) {
        EnergyModel energyModel = luxModelBuilder.energyModel;
        ArrayList<GridConnection> gridConnectionList = new ArrayList<GridConnection>();
        for (GridConnection gc : energyModel.c_gridConnections) {
            if (gc.p_parentNodeElectricID.equals(gridNode.p_gridNodeID)) {
                gridConnectionList.add(gc);
            }
        }
        EnergyCoop energyCoop = energyModel.f_addEnergyCoop(gridConnectionList, energyModel.p_timeParameters, gridNode.p_gridNodeID);
        J_ISIE_Aggregator_EMS ems = new J_ISIE_Aggregator_EMS(energyCoop, energyModel.p_timeParameters);
        energyCoop.f_setAggregatorEnergyManagement(ems);
    }
}
