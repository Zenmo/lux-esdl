package energy.lux.esdl.core.loader.profile;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.EsdlFactory;
import esdl.PhysicalQuantityEnum;
import esdl.UnitEnum;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static energy.lux.esdl.core.TestUtil.captureLogs;
import static energy.lux.esdl.core.util.DateTimeUtil.luxJan1stInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OutsideTemperatureTest {
    private final EsdlFactory esdlFactory = EsdlFactory.eINSTANCE;

    @Test
    public void testHappyFlowHasNoWarnings() {
        // Create ESDL
        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.DEGREES_CELSIUS);
        quantityAndUnit.setPhysicalQuantity(PhysicalQuantityEnum.TEMPERATURE);

        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.setProfileQuantityAndUnit(quantityAndUnit);
        profile.getValues().addAll(createYearOfValues());

        var environmentalProfiles = esdlFactory.createEnvironmentalProfiles();
        environmentalProfiles.setOutsideTemperatureProfile(profile);

        // Set up LUX loader
        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);

        var logEvents = captureLogs();
        globalProfileLoader.loadOutsideTemperature(environmentalProfiles);

        var warningMessags = logEvents.stream()
                .filter(event -> event.getLevel().isGreaterOrEqual(Level.WARN));

        assertThat(warningMessags).isEmpty();

        var luxTemperature = luxLoader.energyModel.pp_ambientTemperature_degC;

        var july1st12h = ZonedDateTime.of(2025, 7, 1, 12, 0, 0, 0, ZoneId.of("Europe/Amsterdam"));
        var hourOffset = DateTimeUtil.getHourOffset(Year.of(2025), july1st12h);
        // minus 1 because of summer time
        assertEquals(11.0, luxTemperature.getValue(hourOffset));
    }

    /**
     * Should convert from hours to quarter-hours.
     */
    @Test
    public void testHourlyToQuarterly() {
        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(2.2, 2.0, 1.8));

        var environmentalProfiles = esdlFactory.createEnvironmentalProfiles();
        environmentalProfiles.setOutsideTemperatureProfile(profile);

        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);

        var luxTemperature = luxLoader.energyModel.pp_ambientTemperature_degC;

        assertEquals(2.2, luxTemperature.getValue(0.0));
        assertEquals(2.2, luxTemperature.getValue(0.75));
        assertEquals(2.0, luxTemperature.getValue(1.0));
        assertEquals(2.0, luxTemperature.getValue(1.75));
        assertEquals(1.8, luxTemperature.getValue(2.0));
        assertEquals(1.8, luxTemperature.getValue(2.75));
        // Ideally, this would be an exception
        assertEquals(2.2, luxTemperature.getValue(3.0));
    }

    @Test
    public void testTooShortTimeSeriesGivesError() {
        // Create ESDL
        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(2.2, 2.0, 1.8));

        var environmentalProfiles = esdlFactory.createEnvironmentalProfiles();
        environmentalProfiles.setOutsideTemperatureProfile(profile);

        // Set up LUX loader
        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);

        var logEvents = captureLogs();
        globalProfileLoader.loadOutsideTemperature(environmentalProfiles);

        var errorMessages = logEvents.stream()
                .filter(event -> event.getLevel() == Level.ERROR)
                .map(ILoggingEvent::getMessage);

        var warningMessages = logEvents.stream()
                .filter(event -> event.getLevel() == Level.WARN)
                .map(ILoggingEvent::getMessage);

        assertThat(errorMessages).anyMatch(
                message -> message.contains("Time series is shorter than one year")
        );

        assertThat(warningMessages).anyMatch(
                message -> message.contains("No unit given for outside temperature. Assuming Celsius")
        );
    }

    @Test
    public void testWrongYearGivesError() {
        // Create ESDL
        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2024)));
        profile.getValues().addAll(List.of(2.2, 2.0, 1.8));

        var environmentalProfiles = esdlFactory.createEnvironmentalProfiles();
        environmentalProfiles.setOutsideTemperatureProfile(profile);

        // Set up LUX loader
        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);

        var logEvents = captureLogs();
        globalProfileLoader.loadOutsideTemperature(environmentalProfiles);

        var errorMessages = logEvents.stream()
                .filter(event -> event.getLevel() == Level.ERROR)
                .map(ILoggingEvent::getMessage);

        assertThat(errorMessages).anyMatch(
                message -> message.contains("Time series is entirely before simulation year")
        );
    }

    @Test
    public void testHighTemperatureThrows() {
        // Create ESDL
        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(2.0, 100.0, 2.0));

        var environmentalProfiles = esdlFactory.createEnvironmentalProfiles();
        environmentalProfiles.setOutsideTemperatureProfile(profile);

        // Set up LUX loader
        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);

        var exception = assertThrows(
                EsdlException.class,
                () -> globalProfileLoader.loadOutsideTemperature(environmentalProfiles)
        );
        assertEquals("Profile has unreasonable temperature range of 2 to 100 °C", exception.getMessage());
    }

    @Test
    public void testKelvinToCelcius() {
        // Create ESDL
        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.KELVIN);
        quantityAndUnit.setPhysicalQuantity(PhysicalQuantityEnum.TEMPERATURE);

        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(293.15));
        profile.setProfileQuantityAndUnit(quantityAndUnit);

        var environmentalProfiles = esdlFactory.createEnvironmentalProfiles();
        environmentalProfiles.setOutsideTemperatureProfile(profile);

        // Set up LUX loader
        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);
        globalProfileLoader.loadOutsideTemperature(environmentalProfiles);

        var luxTemperature = luxLoader.energyModel.pp_ambientTemperature_degC;

        assertEquals(20.0, luxTemperature.getValue(0));
    }

    private static List<Double> createYearOfValues() {
        var values = new ArrayList<Double>();
        for (var i = 0; i < 365 * 24; i++) {
            values.add((double) (i % 24));
        }
        return values;
    }
}
