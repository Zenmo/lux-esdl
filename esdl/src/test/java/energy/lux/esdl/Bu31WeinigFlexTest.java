package energy.lux.esdl;

import energy.lux.esdl.iterator.RootIterator;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import zero_engine.*;

import static energy.lux.esdl.TestUtil.findGridConnectionById;
import static energy.lux.esdl.TestUtil.runLux;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Bu31WeinigFlexTest {
    @Test
    public void testWeinigFlex() {
        var javaUrl = getClass().getResource("/decorated_BU31_weinigflex_test_updated.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var luxLoader = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, luxLoader);

        var luxEngine = luxLoader.energyModel;

        // random grid connection
        var gridConnection = findGridConnectionById(luxEngine, "1aae283c-bd71-4b74-9a6d-5f31ffd3bf61");

        var luxAssets = gridConnection.c_energyAssets;
        assertThat(luxAssets)
                .filteredOn(asset -> asset instanceof J_EAStorageElectric)
                .hasSize(1);
        assertThat(luxAssets)
                .filteredOn(asset -> asset instanceof J_EABuilding)
                .hasSize(1);
        assertThat(luxAssets)
                .filteredOn(asset -> asset instanceof J_EAProduction)
                .hasSize(1);
        assertThat(luxAssets)
                .filteredOn(asset -> asset instanceof J_EAConversionHeatPump)
                .hasSize(1);
        assertThat(luxAssets)
                .filteredOn(asset -> asset instanceof J_EAConsumption)
                .hasSize(1);

        assertThat(luxAssets).hasSize(5);

        assertThat(gridConnection.c_consumptionAssets).hasSize(1);
        var consumptionAsset = gridConnection.c_consumptionAssets.get(0);
        assertThat(consumptionAsset.getBaseConsumption_kWh())
                .isEqualTo(2494.153162899, Offset.offset(0.001));

        var battery = gridConnection.p_batteryAsset;
        assertThat(battery).isNotNull();
        assertEquals(
                battery.getStorageCapacity_kWh(),
                45700308.94104158 / 3_600_000
        );

        luxEngine.f_initializeEngine();
        runLux(luxEngine, 24.0);
    }
}
