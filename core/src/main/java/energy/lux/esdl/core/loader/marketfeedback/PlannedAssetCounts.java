package energy.lux.esdl.core.loader.marketfeedback;

import energy.lux.engine.energyassets.J_EAEV;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.managementclasses.assetmanagements.batterymanagements.J_BatteryManagementExternalSetpoint;
import energy.lux.engine.managementclasses.assetmanagements.chargingmanagements.J_ChargingManagementExternalSetpoint;
import energy.lux.engine.managementclasses.assetmanagements.heatingmanagements.J_HeatingManagementISIE;

import java.util.List;

/**
 * How many assets of each kind the aggregators plan, counted in the LUX model after loading, so that it follows the
 * same rules as the aggregator: only the houses with a dynamic contract, and only one EV per house.
 * <p>
 * An EV counts for V2G when V2G is switched on for it. The aggregator also skips V2G for an EV that cannot discharge
 * at the minimum discharge power; that depends on a setting made after this count, and no ISIE EV is that small.
 */
public record PlannedAssetCounts(int heatPumps, int hybridHeatPumps, int evs, int v2gEvs, int batteries) {

    public static PlannedAssetCounts of(List<GridConnection> gridConnections) {
        int heatPumps = 0;
        int hybridHeatPumps = 0;
        int evs = 0;
        int v2gEvs = 0;
        int batteries = 0;
        for (GridConnection gridConnection : gridConnections) {
            heatPumps += isPlannedHeatPump(gridConnection, false) ? 1 : 0;
            hybridHeatPumps += isPlannedHeatPump(gridConnection, true) ? 1 : 0;
            evs += isPlannedEV(gridConnection) ? 1 : 0;
            v2gEvs += isPlannedV2GEV(gridConnection) ? 1 : 0;
            batteries += isPlannedBattery(gridConnection) ? 1 : 0;
        }
        return new PlannedAssetCounts(heatPumps, hybridHeatPumps, evs, v2gEvs, batteries);
    }

    private static boolean isPlannedHeatPump(GridConnection gridConnection, boolean hybrid) {
        return gridConnection.f_getHeatingManagement() instanceof J_HeatingManagementISIE heatingManagement
                && heatingManagement.isPlannedByAggregator()
                && heatingManagement.isHybrid() == hybrid;
    }

    private static boolean isPlannedEV(GridConnection gridConnection) {
        return !gridConnection.c_electricVehicles.isEmpty()
                && gridConnection.f_getChargingManagement() instanceof J_ChargingManagementExternalSetpoint;
    }

    private static boolean isPlannedV2GEV(GridConnection gridConnection) {
        if (!isPlannedEV(gridConnection)) {
            return false;
        }
        var chargingManagement = (J_ChargingManagementExternalSetpoint) gridConnection.f_getChargingManagement();
        J_EAEV ev = gridConnection.c_electricVehicles.get(0);
        return chargingManagement.getV2GActive()
                && gridConnection.f_getChargePoint() != null
                && gridConnection.f_getChargePoint().getV2GCapable()
                && ev.getV2GCapable();
    }

    private static boolean isPlannedBattery(GridConnection gridConnection) {
        return gridConnection.p_batteryAsset != null
                && gridConnection.f_getBatteryManagement() instanceof J_BatteryManagementExternalSetpoint;
    }
}
