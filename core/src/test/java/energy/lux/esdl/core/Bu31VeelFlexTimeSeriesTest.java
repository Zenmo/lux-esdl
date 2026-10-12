package energy.lux.esdl.core;

import energy.lux.esdl.core.iterator.RootIterator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Bu31VeelFlexTimeSeriesTest {
    @Test
    @Disabled("Loads an older ESDL generation, which the loaders reject: no hot tap water profile or no electricity demand profile")
    public void test() {
        var javaUrl = getClass().getResource("/BU31_veelflex_vTimeSeries.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var energyModel = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, energyModel);
    }
}
