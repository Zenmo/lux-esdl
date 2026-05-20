package energy.lux.esdl;

import energy.lux.esdl.iterator.RootIterator;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static energy.lux.esdl.TestUtil.findGridConnectionById;
import static org.assertj.core.api.Assertions.assertThat;

public class Bu31WeinigFlexTest {
    @Test
    public void testWeinigFlex() {
        var javaUrl = getClass().getResource("/decorated_BU31_weinigflex_test_updated.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var luxLoader = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, luxLoader);

        var luxEngine = luxLoader.energyModel;
        var gridConnection = findGridConnectionById(luxEngine, "1aae283c-bd71-4b74-9a6d-5f31ffd3bf61");
        // TODO: why 2 batteries?
        assertThat(gridConnection.c_energyAssets).hasSize(7);

        var consumptionAsset = gridConnection.c_consumptionAssets.get(0);
        assertThat(consumptionAsset.getBaseConsumption_kWh()).isEqualTo(2494.153162899, Offset.offset(0.001));
    }
}
