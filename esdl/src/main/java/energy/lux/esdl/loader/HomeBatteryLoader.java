package energy.lux.esdl.loader;

import esdl.Battery;
import zero_engine.GridConnection;
import zero_engine.OL_EnergyAssetType;
import zerointerfaceloader.Zero_Loader;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import static energy.lux.esdl.Util.throwIfZero;

public class HomeBatteryLoader {
    /**
     * Fully charge/discharge in 1 hour by default
     */
    private static double defaultC = 1.0;

    public static void loadBattery(Battery esdlBattery, GridConnection luxGridConnection, Zero_Loader luxLoader) {
        luxLoader.f_addStorage(
                luxGridConnection,
                getChargeRateKw(esdlBattery),
                capacityKwh(esdlBattery),
                OL_EnergyAssetType.STORAGE_ELECTRIC
        );
    }

    private static double getChargeRateKw(Battery esdlBattery) {
        return DoubleStream.of(esdlBattery.getMaxChargeRate(), esdlBattery.getMaxDischargeRate())
                .map(HomeBatteryLoader::wattToKw)
                .filter(v -> v != 0.0)
                .average()
                .orElseGet(() -> capacityKwh(esdlBattery) * defaultC);
    }

    private static double capacityKwh(Battery esdlBattery) {
        throwIfZero(esdlBattery.getCapacity(), esdlBattery, "capacity");

        return jouleToKwh(esdlBattery.getCapacity());
    }

    private static double jouleToKwh(double joules) {
        return joules / 3_600_000;
    }

    private static double wattToKw(double watt) {
        return watt * 0.001;
    }
}
