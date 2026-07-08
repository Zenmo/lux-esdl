package energy.lux.esdl.core.e2e;

import energy.lux.esdl.core.ESDLReader;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.iterator.RootIterator;
import org.junit.jupiter.api.Test;

public class Bu31VeelFlexTimeSeriesTest {
    @Test
    public void test() {
        var javaUrl = getClass().getResource("/BU31_veelflex_vTimeSeries.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var luxLoader = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, luxLoader);
    }
}
