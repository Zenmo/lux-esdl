package energy.lux.esdl.core.tools;

import energy.lux.esdl.core.EsdlException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NormalizeEsdlTest {
    @Test
    public void dividesAProfileInKilowattByItsYearlyEnergy() {
        // 1 + 1 + 2 + 4 kW in steps of an hour is 8 kWh.
        var result = NormalizeEsdl.normalizeElectricityDemands(demand("Total: 8.0 kwh", "1.0 1.0 2.0 4.0", true));

        assertThat(result.normalizedCount()).isEqualTo(1);
        assertThat(result.esdl()).isEqualTo(demand("Total: 8.0 kwh", "0.125 0.125 0.25 0.5", false));
    }

    @Test
    public void leavesAProfileThatIsNormalizedAlready() {
        var esdl = demand("Total: 8.0 kwh", "0.125 0.125 0.25 0.5", false);

        var result = NormalizeEsdl.normalizeElectricityDemands(esdl);

        assertThat(result.normalizedCount()).isZero();
        assertThat(result.esdl()).isEqualTo(esdl);
    }

    @Test
    public void leavesADemandThatStatesNoTotal() {
        var esdl = demand("Klant 2", "1.0 1.0 2.0 4.0", true);

        var result = NormalizeEsdl.normalizeElectricityDemands(esdl);

        assertThat(result.normalizedCount()).isZero();
        assertThat(result.esdl()).isEqualTo(esdl);
    }

    @Test
    public void leavesEverythingOutsideTheDemandsAlone() {
        var other = "<asset xsi:type=\"esdl:HeatingDemand\" name=\"Total: 8.0 kwh\">\n"
                + "  <profile xsi:type=\"esdl:TimeSeriesProfile\" timestep=\"3600\" values=\"1.0 1.0 2.0 4.0\"/>\n"
                + "</asset>\n";

        var result = NormalizeEsdl.normalizeElectricityDemands(other + demand("Total: 8.0 kwh", "1.0 1.0 2.0 4.0", true) + other);

        assertThat(result.normalizedCount()).isEqualTo(1);
        assertThat(result.esdl()).isEqualTo(other + demand("Total: 8.0 kwh", "0.125 0.125 0.25 0.5", false) + other);
    }

    @Test
    public void refusesAProfileThatDoesNotBelongToItsName() {
        var esdl = demand("Total: 100.0 kwh", "1.0 1.0 2.0 4.0", true);

        assertThatThrownBy(() -> NormalizeEsdl.normalizeElectricityDemands(esdl))
                .isInstanceOf(EsdlException.class)
                .hasMessageContaining("Total: 100.0 kwh");
    }

    /**
     * The layout of the generated files: a demand with a profile on its out port, which holds a unit as long as it
     * is in kW and none once it is a shape.
     */
    private static String demand(String name, String values, boolean withUnit) {
        var profile = "<profile xsi:type=\"esdl:TimeSeriesProfile\" startDateTime=\"2050-01-01T00:00:00.000000\" "
                + "timestep=\"3600\" values=\"" + values + "\"";
        var closedProfile = withUnit
                ? profile + ">\n"
                + "    <profileQuantityAndUnit xsi:type=\"esdl:QuantityAndUnitType\" physicalQuantity=\"POWER\" multiplier=\"KILO\" unit=\"WATT\"/>\n"
                + "  </profile>\n"
                : profile + "/>\n";

        return "<asset xsi:type=\"esdl:ElectricityDemand\" id=\"demand-1\" name=\"" + name + "\" powerFactor=\"0.95\">\n"
                + "  " + closedProfile
                + "</asset>\n";
    }
}
