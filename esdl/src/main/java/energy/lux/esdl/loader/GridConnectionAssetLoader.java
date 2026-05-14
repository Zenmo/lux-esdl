package energy.lux.esdl.loader;

import energy.lux.esdl.NotImplemented;
import esdl.EVChargingStation;
import esdl.HybridHeatPump;
import esdl.PVInstallation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.GridConnection;
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
        logger.warn("EVChargingStation loading not implemented (requires trip data files), id={}", evStation.getId());
    }

    static void loadHybridHeatPump(
            HybridHeatPump heatPump, Zero_Loader luxLoader, GridConnection gridConnection
    ) {
        logger.error("HybridHeatPump loading not implemented, id={}", heatPump.getId());
    }
}
