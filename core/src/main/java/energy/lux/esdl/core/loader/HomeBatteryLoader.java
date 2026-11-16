package energy.lux.esdl.core.loader;

import esdl.Battery;
import energy.lux.engine.I_AssetOwner;
import energy.lux.engine.dataclasses.J_TimeParameters;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.energyassets.J_EAStorageElectric;
import energy.lux.engine.managementclasses.assetmanagements.batterymanagements.J_BatteryManagementSelfConsumption;
import energy.lux.engine.EnergyModel;
import energy.lux.esdl.core.EsdlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.DoubleStream;

import static energy.lux.esdl.core.util.Util.throwIfZero;

public class HomeBatteryLoader {
    private static final Logger logger = LoggerFactory.getLogger(HomeBatteryLoader.class);

    /**
     * Fully charge/discharge in 1 hour by default
     */
    private static double defaultC = 1.0;

    private static final double defaultInitialStateOfCharge_fr = 0.5;

    public static void loadBattery(Battery esdlBattery, GridConnection luxGridConnection, EnergyModel energyModel) {
        createBattery(esdlBattery, luxGridConnection, energyModel.p_timeParameters);

        // Houses that the aggregator manages get their management replaced afterwards.
        if (luxGridConnection.f_getBatteryManagement() == null) {
            luxGridConnection.f_setBatteryManagement(
                    new J_BatteryManagementSelfConsumption(luxGridConnection, energyModel.p_timeParameters)
            );
        }
    }

    // The battery registers itself with its owner.
    static J_EAStorageElectric createBattery(Battery esdlBattery, I_AssetOwner owner, J_TimeParameters timeParameters) {
        var battery = new J_EAStorageElectric(
                owner,
                getChargeRateKw(esdlBattery),
                capacityKwh(esdlBattery),
                initialStateOfCharge_fr(esdlBattery),
                timeParameters
        );
        setRoundTripEfficiency(esdlBattery, battery);
        return battery;
    }

    /**
     * fillLevel is the initial state of charge. A battery that states none reads 0, and EMF neither
     * writes nor remembers a value equal to that default, so an empty battery cannot be told from
     * one that states nothing. Both start at the LUX default.
     */
    private static double initialStateOfCharge_fr(Battery esdlBattery) {
        var fillLevel = esdlBattery.getFillLevel();
        if (fillLevel == 0) {
            return defaultInitialStateOfCharge_fr;
        }
        if (fillLevel < 0 || fillLevel > 1) {
            throw new EsdlException(String.format(
                    "Battery %s has fillLevel %s, but a fraction from 0 to 1 is expected",
                    esdlBattery.getName(),
                    fillLevel
            ));
        }
        return fillLevel;
    }

    /**
     * LUX keeps a single round trip efficiency per battery and splits it evenly over charging and
     * discharging, so it gets the product of the two ESDL efficiencies. ESDL defaults both to 0,
     * which no battery has, so that is read as not stated, and the battery keeps the LUX default.
     */
    private static void setRoundTripEfficiency(Battery esdlBattery, J_EAStorageElectric battery) {
        var chargeEfficiency = esdlBattery.getChargeEfficiency();
        var dischargeEfficiency = esdlBattery.getDischargeEfficiency();
        if (chargeEfficiency == 0 && dischargeEfficiency == 0) {
            logger.warn(
                    "Battery {} states no efficiencies, so it keeps the LUX default round trip efficiency",
                    esdlBattery.getName()
            );
            return;
        }
        assertEfficiency(esdlBattery, "chargeEfficiency", chargeEfficiency);
        assertEfficiency(esdlBattery, "dischargeEfficiency", dischargeEfficiency);
        warnAboutUnevenEfficiencies(esdlBattery, chargeEfficiency, dischargeEfficiency);
        battery.setBatteryEfficiency_r(chargeEfficiency * dischargeEfficiency);
    }

    private static void assertEfficiency(Battery esdlBattery, String attributeName, double efficiency) {
        if (efficiency <= 0 || efficiency > 1) {
            throw new EsdlException(String.format(
                    "Battery %s has %s %s, but a fraction above 0 and at most 1 is expected",
                    esdlBattery.getName(),
                    attributeName,
                    efficiency
            ));
        }
    }

    private static void warnAboutUnevenEfficiencies(Battery esdlBattery, double chargeEfficiency, double dischargeEfficiency) {
        if (chargeEfficiency != dischargeEfficiency) {
            logger.warn(
                    "Battery {} charges at efficiency {} and discharges at {}; LUX keeps their product as the round trip efficiency and splits it evenly",
                    esdlBattery.getName(),
                    chargeEfficiency,
                    dischargeEfficiency
            );
        }
    }

    /**
     * The ESDL model annotates maxChargeRate and maxDischargeRate as Watts, and the current files
     * follow that: isie.esdl gives a 16.8 kWh home battery a rate of 4190. The September 2025
     * generation stated kW instead and is no longer supported, because the older files are history.
     * <p>
     * ESDL carries no unit on the attribute itself, so there is nothing in the file to check this
     * against.
     */
    private static double getChargeRateKw(Battery esdlBattery) {
        return DoubleStream.of(esdlBattery.getMaxChargeRate(), esdlBattery.getMaxDischargeRate())
                .filter(chargeRate_W -> chargeRate_W != 0.0)
                .map(chargeRate_W -> chargeRate_W * 0.001)
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
