package energy.lux.esdl.core;

import energy.lux.esdl.core.iterator.RootIterator;
import org.junit.jupiter.api.Test;

public class Bu31VeelFlexTest {
    @Test
    public void testVeelFlex() {
        var javaUrl = getClass().getResource("/decorated_BU31_veelflex_test_updated.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var luxLoader = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, luxLoader);
    }
}
