package energy.lux.esdl.core.e2e;

import energy.lux.esdl.core.ESDLReader;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.iterator.RootIterator;
import esdl.EConnection;
import esdl.EnergySystem;
import org.assertj.core.data.Offset;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Test;
import zero_engine.*;

import static energy.lux.esdl.core.TestUtil.findGridConnectionById;
import static energy.lux.esdl.core.TestUtil.runLux;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of the
 * <a href="https://github.com/EvelienSmit/ISIE/tree/main/Scenarios/Test">lastest file</a>
 */
public class LatestE2eTest {
    @Test
    public void testLatest() {
        var javaUrl = getClass().getResource("/decorated_corrected_BU31_veelflex_test_updated_tou0_localcongestion.esdl");
        var esdl = ESDLReader.readResource(javaUrl);

        var luxLoader = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, luxLoader);

        var luxEngine = luxLoader.energyModel;

        assertThat(luxEngine.c_gridConnections).size().isEqualTo(141);

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
        assertThat(luxAssets)
                .filteredOn(asset -> asset instanceof J_EAEV)
                .hasSize(1);

        assertThat(luxAssets).hasSize(6);

        assertThat(gridConnection.c_consumptionAssets).hasSize(1);
        var consumptionAsset = gridConnection.c_consumptionAssets.get(0);
        assertThat(consumptionAsset.getBaseConsumption_kWh())
                .isEqualTo(2494.153162899, offset(0.001));

        var battery = gridConnection.p_batteryAsset;
        assertThat(battery).isNotNull();
        assertEquals(
                49648595.7253798 / 3_600_000,
                battery.getStorageCapacity_kWh()
        );

        luxEngine.f_initializeEngine();
        runLux(luxEngine, 7 * 24.0);

        luxEngine.f_runRapidSimulation();
    }
}
