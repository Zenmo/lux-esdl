package energy.lux.esdl.core.loader;

import esdl.Battery;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.energyassets.J_EAStorageElectric;
import energy.lux.engine.managementclasses.assetmanagements.batterymanagements.J_BatteryManagementSelfConsumption;
import energy.lux.engine.EnergyModel;

import java.util.stream.DoubleStream;

import static energy.lux.esdl.core.util.Util.throwIfZero;

public class HomeBatteryLoader {
    /**
     * Fully charge/discharge in 1 hour by default
     */
    private static double defaultC = 1.0;

    private static final double initialStateOfCharge_fr = 0.5;

    public static void loadBattery(Battery esdlBattery, GridConnection luxGridConnection, EnergyModel energyModel) {
        new J_EAStorageElectric(
                luxGridConnection,
                getChargeRateKw(esdlBattery),
                capacityKwh(esdlBattery),
                initialStateOfCharge_fr,
                energyModel.p_timeParameters
        );

        // Houses that the aggregator manages get their management replaced afterwards.
        if (luxGridConnection.f_getBatteryManagement() == null) {
            luxGridConnection.f_setBatteryManagement(
                    new J_BatteryManagementSelfConsumption(luxGridConnection, energyModel.p_timeParameters)
            );
        }
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
