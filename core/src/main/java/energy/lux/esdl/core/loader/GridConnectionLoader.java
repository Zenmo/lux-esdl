package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.iterator.GridConnectionAssetIterator;
import esdl.EConnection;
import esdl.OutPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;
import zero_engine.I_ChargingManagement;
import zero_engine.I_BatteryManagement;
import zero_engine.J_ChargingManagementExternalSetpoint;
import zero_engine.J_BatteryManagementExternalSetpoint;
import zero_engine.J_HeatingPreferences;
import zero_engine.OL_GridConnectionHeatingType;
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
        checkHeatingAsset(eConnection, luxLoader, gridConnection);
        addCustomAssetManagements(eConnection, luxLoader, gridConnection);
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

    private static void addCustomAssetManagements(EConnection eConnection, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        // All houses have already gotten heating management PI Control
        // For other assets houses with a dynamic contract have their assets managed by the aggregator on the parent GridNode
        // Houses without a dynamic contract have the default SIMPLE charging & SELF CONSUMPTION battery algorithms.
        EnergyModel energyModel = luxLoader.energyModel;
        if (eConnection.getDescription().contains("dynamic_contract")) { // TODO: Make this check more robust?
            I_ChargingManagement chargingManagement = new J_ChargingManagementExternalSetpoint(luxGridConnection, energyModel.p_timeParameters);
            luxGridConnection.f_setChargingManagement(chargingManagement);
            I_BatteryManagement batteryManagement = new J_BatteryManagementExternalSetpoint(luxGridConnection, energyModel.p_timeParameters);
            luxGridConnection.f_setBatteryManagement(batteryManagement);
        }
    }

    private static void checkHeatingAsset(EConnection eConnection, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        // Some houses, like beca94a3-5a38-4a62-ad76-43c7948f9fc7 in BU31_veelflex.esdl, have no heating asset.
        // We give these houses a gas burner
        if (luxGridConnection.c_heatingAssets.isEmpty()) {
            double outputPower_kW = 10;
            J_HeatingPreferences heatingPreferences = luxLoader.f_getHouseHeatingPreferences();
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.GAS_BURNER, outputPower_kW, heatingPreferences);
        }
    }
}
