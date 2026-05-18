package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import esdl.EVChargingStation;
import esdl.HybridHeatPump;
import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.GridConnection;
import zero_engine.OL_EnergyAssetType;
import zero_engine.OL_GridConnectionHeatingType;
import zero_engine.OL_PVOrientation;
import zerointerfaceloader.Zero_Loader;

public class GridConnectionAssetLoader {
    private static final Logger logger = LoggerFactory.getLogger(GridConnectionAssetLoader.class);

    static void loadPVInstallation(
            PVInstallation esdlPvInstallation, Zero_Loader luxLoader, GridConnection gridConnection
    ) {
        double installedPowerKilowatts = esdlPvInstallation.getSurfaceArea() * esdlPvInstallation.getPanelEfficiency();
        luxLoader.f_addPVProductionAsset(gridConnection, esdlPvInstallation.getName(), installedPowerKilowatts, OL_PVOrientation.SOUTH);
    }

    static void loadEVChargingStation(
            EVChargingStation evStation, Zero_Loader luxLoader, GridConnection gridConnection
    ) {
        var maxChargingPowerKw = evStation.getPower() * 0.001;
        luxLoader.f_addElectricVehicle(gridConnection, OL_EnergyAssetType.ELECTRIC_VEHICLE, true, 8_000, maxChargingPowerKw);
    }

    static void loadHybridHeatPump(
            HybridHeatPump heatPump, Zero_Loader luxLoader, GridConnection gridConnection
    ) {
        var maxThermalPowerKw = heatPump.getGasHeaterThermalPower() * 0.001;
        luxLoader.f_addHeatAsset(gridConnection, OL_GridConnectionHeatingType.HYBRID_HEATPUMP, maxThermalPowerKw);
    }
}
