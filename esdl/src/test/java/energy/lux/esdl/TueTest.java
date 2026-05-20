package energy.lux.esdl;

import energy.lux.esdl.loader.RootLoader;
import org.junit.jupiter.api.Test;
import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;
import zero_engine.OL_EnergyCarriers;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test tue.esdl supplied by partners.
 */
public class TueTest {
    @Test
    public void testReadTueESDL() {
        var javaUrl = getClass().getResource("/tue.esdl");
        var energySystem = ESDLReader.readResource(javaUrl);
        assertNotNull(energySystem);
    }

    @Test
    public void testLoadTueESDL() {
        var javaUrl = getClass().getResource("/tue.esdl");
        var esdl = ESDLReader.readResource(javaUrl);
        assertNotNull(esdl);

        var luxLoader = LuxModelFactory.createEnergyModel();
        RootLoader.loadEsdlIntoLux(esdl, luxLoader);

        var luxEngine = luxLoader.energyModel;

        var timeZone = ZoneId.of("Europe/Amsterdam");
        var timestampToCheck = LocalDateTime.parse("2020-08-11T01:30:00.000000").atZone(timeZone);
        var hourOffset = DateTimeUtil.getHourOffset(2025, timestampToCheck);

        var degC = luxEngine.pp_ambientTemperature_degC.getValue(hourOffset);
        // The ESDL file seems to have kelvin,
        // but the ESDL spec says it should be Celsius
        assertEquals(295.85 - 273.15, degC, 0.01);

        var eurpMWh = luxEngine.pp_dayAheadElectricityPricing_eurpMWh.getValue(hourOffset);
        assertEquals(98.2, eurpMWh, 0.01);

        assertEquals(2, luxEngine.pop_gridNodes.size());
        var importGridNode = findGridNodeById(luxEngine, "35c99886-75dc-482e-9747-7a84d9d739ad");
        assertNotNull(importGridNode, "Import grid node not loaded");
        var transformerGridNode = findGridNodeById(luxEngine, "d2411d31-08fd-4965-bc85-78a1fb4b3b8d");
        assertNotNull(transformerGridNode, "Transformer grid node not loaded");

        assertEquals(2, luxEngine.pop_gridConnections.size());
        var connectionHome1 = findGridConnectionById(luxEngine, "5c19dcff-b004-4644-99b9-f42d15a34f3a");
        assertNotNull(connectionHome1, "ConnectionHome1 not found");
        assertEquals(transformerGridNode.p_gridNodeID, connectionHome1.p_parentNodeElectricID);
        var connectionHome2 = findGridConnectionById(luxEngine, "1412f71f-a9d2-4c66-a834-385cf91c3767");
        assertNotNull(connectionHome2, "ConnectionHome2 not found");
        assertEquals(transformerGridNode.p_gridNodeID, connectionHome2.p_parentNodeElectricID);

        // 1. PV
        // 2. EV
        // 3. fixed consumption
        // 4. heat pump
        // 5. gas burner (hybrid configuration)
        // 6. building thermals
        assertEquals(6, connectionHome1.c_energyAssets.size());
        // fixed consumption + building thermals
        assertEquals(2, connectionHome2.c_energyAssets.size());

        assertThat(connectionHome1.p_BuildingThermalAsset.getHeatCapacity_JpK())
                .isGreaterThan(1.0);

        luxEngine.f_initializeEngine();
        // run for 24 hours
        var i = 0;
        for (
                double hours = 0.0;
                hours < 24;
                hours += luxEngine.p_timeParameters.getTimeStep_h()
        ) {
            i++;
            luxEngine.f_runTimestep();
        }

        assertEquals(i, luxEngine.v_timeStepsElapsed);

        // Sanity checks
        var demandDataSet = luxEngine.v_liveData.dsm_liveDemand_kW.get(OL_EnergyCarriers.ELECTRICITY);
        assertThat(demandDataSet.getYMean()).isBetween(0.1, 10.0);
        assertThat(demandDataSet.getYMax()).isBetween(1.0, 40.0);

        var supplyDataSet = luxEngine.v_liveData.dsm_liveSupply_kW.get(OL_EnergyCarriers.ELECTRICITY);
        // 32 m2 of solar = 6 kWp
        assertThat(supplyDataSet.getYMean()).isBetween(0.001, 1.0);
        assertThat(supplyDataSet.getYMax()).isBetween(0.01, 3.0);
    }

    private GridNode findGridNodeById(EnergyModel energyModel, String gridNodeId) {
        for (GridNode gridNode : energyModel.pop_gridNodes) {
            if (gridNodeId.equals(gridNode.p_gridNodeID)) return gridNode;
        }
        return null;
    }

    private GridConnection findGridConnectionById(EnergyModel energyModel, String gridConnectionId) {
        for (GridConnection gridConnection : energyModel.pop_gridConnections) {
            if (gridConnectionId.equals(gridConnection.p_gridConnectionID)) return gridConnection;
        }
        return null;
    }
}
