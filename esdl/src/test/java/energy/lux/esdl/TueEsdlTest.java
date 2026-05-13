package energy.lux.esdl;

import energy.lux.esdl.loader.RootLoader;
import org.junit.jupiter.api.Test;

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

        var luxLoader = LuxFactory.createEnergyModel();
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
    }
}
