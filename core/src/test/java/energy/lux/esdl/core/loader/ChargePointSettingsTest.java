package energy.lux.esdl.core.loader;

import energy.lux.engine.I_AssetOwner;
import energy.lux.engine.dataclasses.J_TimeParameters;
import energy.lux.engine.energyassets.J_EA;
import energy.lux.engine.energyassets.J_EAEV;
import energy.lux.engine.optionlists.OL_VehicleType;
import energy.lux.esdl.core.EsdlException;
import esdl.EVChargingStation;
import esdl.EsdlFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ChargePointSettingsTest {
    private static final EsdlFactory factory = EsdlFactory.eINSTANCE;

    // As the ISIE decorator writes it.
    @Test
    public void readsTheISIEDescription() {
        var settings = ChargePointSettings.read(chargingStationDescribedAs(
                "{\"min_charge_rate_kwh\": 1.4, \"min_soc_percentage_v2g\": 0.3, \"efficiency\": 0.95, \"capacity_kwh\": 75.0}"
        ));

        assertThat(settings).isEqualTo(new ChargePointSettings(1.4, 0.3, 0.95, 75.0));
        assertThat(settings.statesV2G()).isTrue();
    }

    @Test
    public void leftOutKeysAreNull() {
        var settings = ChargePointSettings.read(chargingStationDescribedAs("{\"capacity_kwh\": 60}"));

        assertThat(settings).isEqualTo(new ChargePointSettings(null, null, null, 60.0));
        assertThat(settings.statesV2G()).isFalse();
    }

    // The efficiency of the charge point holds for each direction, so it is not square-rooted.
    @Test
    public void anEVOfTheISIEDescriptionLosesFivePercentEachWay() {
        var settings = ChargePointSettings.read(chargingStationDescribedAs(
                "{\"min_charge_rate_kwh\": 1.4, \"min_soc_percentage_v2g\": 0.3, \"efficiency\": 0.95, \"capacity_kwh\": 75.0}"
        ));
        var electricVehicle = createElectricVehicle();

        settings.setChargingEfficienciesOf(electricVehicle);

        assertThat(electricVehicle.getChargingEfficiency_r()).isEqualTo(0.95);
        assertThat(electricVehicle.getDischargingEfficiency_r()).isEqualTo(0.95);
    }

    @Test
    public void anEVWithoutStatedEfficiencyHasNoLosses() {
        var settings = ChargePointSettings.read(chargingStationDescribedAs("{\"capacity_kwh\": 60}"));
        var electricVehicle = createElectricVehicle();

        settings.setChargingEfficienciesOf(electricVehicle);

        assertThat(electricVehicle.getChargingEfficiency_r()).isEqualTo(1.0);
        assertThat(electricVehicle.getDischargingEfficiency_r()).isEqualTo(1.0);
    }

    @Test
    public void descriptionThatIsNotJSONStatesNothing() {
        assertThat(ChargePointSettings.read(chargingStationDescribedAs("private charger"))).isEqualTo(ChargePointSettings.none);
        assertThat(ChargePointSettings.read(chargingStationDescribedAs(null))).isEqualTo(ChargePointSettings.none);
    }

    @Test
    public void percentageInsteadOfFractionIsRefused() {
        var chargingStation = chargingStationDescribedAs("{\"min_soc_percentage_v2g\": 30}");

        assertThatThrownBy(() -> ChargePointSettings.read(chargingStation)).isInstanceOf(EsdlException.class);
    }

    @Test
    public void textInsteadOfNumberIsRefused() {
        var chargingStation = chargingStationDescribedAs("{\"capacity_kwh\": \"75\"}");

        assertThatThrownBy(() -> ChargePointSettings.read(chargingStation)).isInstanceOf(EsdlException.class);
    }

    // A car of 11 kW and 60 kWh at half charge, without trips; its owner does not keep track of it.
    private static J_EAEV createElectricVehicle() {
        var timeParameters = new J_TimeParameters(0.25, 2023, 0, 24, 26, 2);
        return new J_EAEV(new UntrackedOwner(), 11, 60, 0.5, timeParameters, 0.2, 1, OL_VehicleType.CAR, null);
    }

    private static final class UntrackedOwner implements I_AssetOwner {
        public void f_connectToJ_EA(J_EA energyAsset, J_TimeParameters timeParameters) {}

        public void f_removeTheJ_EA(J_EA energyAsset) {}

        public boolean f_isActive() {
            return true;
        }
    }

    private static EVChargingStation chargingStationDescribedAs(String description) {
        var chargingStation = factory.createEVChargingStation();
        chargingStation.setName("chargingstation_test");
        chargingStation.setDescription(description);
        return chargingStation;
    }
}
