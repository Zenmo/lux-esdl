package energy.lux.esdl;

import energy.lux.esdl.loader.RootLoader;
import org.junit.jupiter.api.Test;
import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;

import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test tue.esdl supplied by partners.
 */
public class TueEsdlTest {
    @Test
    public void testReadTueESDL() throws URISyntaxException {
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
        var simulationYearStart = ZonedDateTime.of(2025, 1, 1, 0, 0, 0, 0, timeZone);
        var milliOffset = timestampToCheck.toInstant().toEpochMilli() - simulationYearStart.toInstant().toEpochMilli();
        var hourOffset = (double) milliOffset / Duration.ofHours(1).toMillis();

        var degC = luxEngine.pp_ambientTemperature_degC.getValue(hourOffset);
        // The ESDL file seems to have kelvin but the ESDL spec says it should be Celsius
        assertEquals(295.85, degC, 0.01);

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
    }

    private GridNode findGridNodeById(EnergyModel energyModel, String gridNodeId) {
        for (int i = 0; i < energyModel.pop_gridNodes.size(); i++) {
            GridNode gridNode = energyModel.pop_gridNodes.get(i);
            if (gridNodeId.equals(gridNode.p_gridNodeID)) return gridNode;
        }
        return null;
    }

    private GridConnection findGridConnectionById(EnergyModel energyModel, String gridConnectionId) {
        for (int i = 0; i < energyModel.pop_gridConnections.size(); i++) {
            GridConnection gridConnection = energyModel.pop_gridConnections.get(i);
            if (gridConnectionId.equals(gridConnection.p_gridConnectionID)) return gridConnection;
        }
        return null;
    }
}
