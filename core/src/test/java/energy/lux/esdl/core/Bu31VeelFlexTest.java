package energy.lux.esdl.core;

import energy.lux.esdl.core.iterator.RootIterator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

public class Bu31VeelFlexTest {
    @Test
    @Disabled("Loads an older ESDL generation, which the loaders reject: no hot tap water profile or no electricity demand profile")
    public void testVeelFlex() {
        var javaUrl = getClass().getResource("/decorated_BU31_veelflex_test_updated.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var energyModel = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, energyModel);
    }
}
