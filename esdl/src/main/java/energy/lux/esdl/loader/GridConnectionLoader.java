package energy.lux.esdl.loader;

import energy.lux.esdl.iterator.GridConnectionAssetIterator;
import esdl.EConnection;
import esdl.OutPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;
import zerointerfaceloader.Zero_Loader;

public class GridConnectionLoader {
    private static final Logger logger = LoggerFactory.getLogger(GridConnectionLoader.class);

    public static GridConnection loadGridConnection(
            EConnection eConnection, Zero_Loader luxLoader, GridNode parentGridNode
    ) {
        var gridConnection = instantiateGridConnection(eConnection, luxLoader, parentGridNode);
        loadBuilding(eConnection, luxLoader, gridConnection);

        var gcSwitch = new GridConnectionAssetIterator(gridConnection, luxLoader, eConnection);
        for (var port: eConnection.getPort()) {
            // skip InPort because that leaves the grid connection
            if (port instanceof OutPort outPort) {
                gcSwitch.doSwitch(outPort);
            }
        }

        return gridConnection;
    }

    private static GridConnection instantiateGridConnection(
            EConnection eConnection, Zero_Loader luxLoader, GridNode parentGridNode
    ) {
        EnergyModel energyModel = luxLoader.energyModel;
        var gridConnection = energyModel.add_pop_gridConnections();
        gridConnection.p_gridConnectionID = eConnection.getId();
        gridConnection.p_parentNodeElectricID = parentGridNode.p_gridNodeID;
        return gridConnection;
    }

    private static void loadBuilding(EConnection eConnection, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        var building = eConnection.getContainingBuilding();
        if (building != null) {
            BuildingThermalLoader.loadBuilding(building, luxLoader, luxGridConnection);
        }
        // It seems valid to have a grid connection without a building, no warning necessary.
    }
}
