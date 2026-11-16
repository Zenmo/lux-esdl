package energy.lux.esdl.core.loader;

import energy.lux.engine.I_AssetOwner;
import energy.lux.engine.dataclasses.J_TimeParameters;
import energy.lux.engine.energyassets.J_EA;
import energy.lux.esdl.core.EsdlException;
import esdl.Battery;
import esdl.EsdlFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

public class HomeBatteryLoaderTest {
    private static final J_TimeParameters timeParameters = new J_TimeParameters(0.25, 2023, 0, 24, 26, 2);

    // As isie.esdl states the battery of Home95_1.
    @Test
    public void readsTheEfficienciesAndFillLevelOfTheISIEBattery() {
        var esdlBattery = createBattery();
        esdlBattery.setChargeEfficiency(0.9);
        esdlBattery.setDischargeEfficiency(0.9);
        esdlBattery.setFillLevel(0.5259802445889767);

        var battery = HomeBatteryLoader.createBattery(esdlBattery, new UntrackedOwner(), timeParameters);

        assertThat(battery.getChargingEfficiency_r()).isCloseTo(0.9, within(1e-12));
        assertThat(battery.getDischargingEfficiency_r()).isCloseTo(0.9, within(1e-12));
        assertThat(battery.getCurrentStateOfCharge_fr()).isEqualTo(0.5259802445889767);
    }

    @Test
    public void unevenEfficienciesKeepTheirRoundTrip() {
        var esdlBattery = createBattery();
        esdlBattery.setChargeEfficiency(0.95);
        esdlBattery.setDischargeEfficiency(0.85);

        var battery = HomeBatteryLoader.createBattery(esdlBattery, new UntrackedOwner(), timeParameters);

        assertThat(battery.getChargingEfficiency_r() * battery.getDischargingEfficiency_r()).isCloseTo(0.95 * 0.85, within(1e-12));
    }

    @Test
    public void aBatteryThatStatesNothingKeepsTheLUXDefaults() {
        var battery = HomeBatteryLoader.createBattery(createBattery(), new UntrackedOwner(), timeParameters);

        assertThat(battery.getChargingEfficiency_r() * battery.getDischargingEfficiency_r()).isCloseTo(0.9, within(1e-12));
        assertThat(battery.getCurrentStateOfCharge_fr()).isEqualTo(0.5);
    }

    // ESDL cannot tell a fill level of 0 from none.
    @Test
    public void aFillLevelOfZeroStartsAtTheLUXDefault() {
        var esdlBattery = createBattery();
        esdlBattery.setFillLevel(0);

        var battery = HomeBatteryLoader.createBattery(esdlBattery, new UntrackedOwner(), timeParameters);

        assertThat(battery.getCurrentStateOfCharge_fr()).isEqualTo(0.5);
    }

    @Test
    public void onlyOneEfficiencyIsRefused() {
        var esdlBattery = createBattery();
        esdlBattery.setChargeEfficiency(0.9);

        assertThatThrownBy(() -> HomeBatteryLoader.createBattery(esdlBattery, new UntrackedOwner(), timeParameters))
                .isInstanceOf(EsdlException.class);
    }

    @Test
    public void aPercentageAsFillLevelIsRefused() {
        var esdlBattery = createBattery();
        esdlBattery.setFillLevel(53);

        assertThatThrownBy(() -> HomeBatteryLoader.createBattery(esdlBattery, new UntrackedOwner(), timeParameters))
                .isInstanceOf(EsdlException.class);
    }

    // 18 kWh, charged and discharged at 4.5 kW, stating nothing else.
    private static Battery createBattery() {
        var esdlBattery = EsdlFactory.eINSTANCE.createBattery();
        esdlBattery.setName("battery_test");
        esdlBattery.setCapacity(18 * 3.6e6);
        esdlBattery.setMaxChargeRate(4500);
        esdlBattery.setMaxDischargeRate(4500);
        return esdlBattery;
    }

    private static final class UntrackedOwner implements I_AssetOwner {
        public void f_connectToJ_EA(J_EA energyAsset, J_TimeParameters timeParameters) {}

        public void f_removeTheJ_EA(J_EA energyAsset) {}

        public boolean f_isActive() {
            return true;
        }
    }
}
