package energy.lux.esdl;

import energy.lux.esdl.loader.RootLoader;
import org.junit.jupiter.api.Test;

public class Bu31WeinigFlexTest {
    @Test
    public void testWeinigFlex() {
        var javaUrl = getClass().getResource("/decorated_BU31_weinigflex_test_updated.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var luxLoader = LuxModelFactory.createEnergyModel();
        RootLoader.loadEsdlIntoLux(esdl, luxLoader);

        var luxEngine = luxLoader.energyModel;
        
    }
}
