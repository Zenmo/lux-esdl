package energy.lux.esdl.core.loader;

import esdl.Battery;
import zero_engine.GridConnection;
import zero_engine.OL_EnergyAssetType;
import zerointerfaceloader.Zero_Loader;

import java.util.stream.DoubleStream;

import static energy.lux.esdl.core.util.Util.throwIfZero;

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

    /**
     * The ESDL model annotates maxChargeRate and maxDischargeRate as Watts, but the files this
     * loader reads state them in kW. The September 2025 generation gives an 18.8 kWh home battery
     * a rate of 4.7, which is a four hour battery at 4.7 kW and a physically meaningless one at
     * 4.7 W. The July files still stated Watts, in the thousands.
     * <p>
     * ESDL carries no unit on the attribute itself, so there is nothing in the file to check this
     * against. Only the newer convention is supported, because the older files are history.
     */
    private static double getChargeRateKw(Battery esdlBattery) {
        return DoubleStream.of(esdlBattery.getMaxChargeRate(), esdlBattery.getMaxDischargeRate())
                .filter(chargeRate_kW -> chargeRate_kW != 0.0)
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
}
