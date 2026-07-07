package energy.lux.esdl.core.profile;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.loader.profile.GlobalProfileLoader;
import esdl.EsdlFactory;
import esdl.MultiplierEnum;
import esdl.UnitEnum;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import static energy.lux.esdl.core.TestUtil.captureLogs;
import static energy.lux.esdl.core.util.DateTimeUtil.luxJan1stInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayAheadElectricityPriceTest {
    private final EsdlFactory esdlFactory = EsdlFactory.eINSTANCE;

    @Test
    public void testEuroPerMegawattHourIsKept() {
        var energyMarket = createEnergyMarket(UnitEnum.WATTHOUR, MultiplierEnum.MEGA, List.of(100.0));

        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);
        globalProfileLoader.loadDayAheadElectricityPricing(energyMarket);

        var luxPrice = luxLoader.energyModel.pp_dayAheadElectricityPricing_eurpMWh;

        assertEquals(100.0, luxPrice.getValue(0));
    }

    @Test
    public void testEuroPerKilowattHourIsConvertedToEuroPerMegawattHour() {
        var energyMarket = createEnergyMarket(UnitEnum.WATTHOUR, MultiplierEnum.KILO, List.of(0.25));

        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);
        globalProfileLoader.loadDayAheadElectricityPricing(energyMarket);

        var luxPrice = luxLoader.energyModel.pp_dayAheadElectricityPricing_eurpMWh;

        assertEquals(250.0, luxPrice.getValue(0));
    }

    @Test
    public void testEuroPerGigajouleIsConvertedToEuroPerMegawattHour() {
        var energyMarket = createEnergyMarket(UnitEnum.JOULE, MultiplierEnum.GIGA, List.of(10.0));

        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);
        globalProfileLoader.loadDayAheadElectricityPricing(energyMarket);

        var luxPrice = luxLoader.energyModel.pp_dayAheadElectricityPricing_eurpMWh;

        assertEquals(36.0, luxPrice.getValue(0));
    }

    @Test
    public void testNoUnitLogsErrorAndAssumesEuroPerMegawattHour() {
        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.getValues().addAll(List.of(123.0));

        var energyMarket = esdlFactory.createEnergyMarket();
        energyMarket.setMarketPrice(profile);

        var luxLoader = LuxModelFactory.createEnergyModel();
        var globalProfileLoader = new GlobalProfileLoader(luxLoader);

        var logEvents = captureLogs();
        globalProfileLoader.loadDayAheadElectricityPricing(energyMarket);

        var errorMessages = logEvents.stream()
                .filter(event -> event.getLevel() == Level.ERROR)
                .map(ILoggingEvent::getMessage);

        assertThat(errorMessages).anyMatch(
                message -> message.contains("No unit given for day-ahead electricity pricing. Assuming €/MWh")
        );

        var luxPrice = luxLoader.energyModel.pp_dayAheadElectricityPricing_eurpMWh;

        assertEquals(123.0, luxPrice.getValue(0));
    }

    private esdl.EnergyMarket createEnergyMarket(
            UnitEnum perUnit,
            MultiplierEnum perMultiplier,
            List<Double> values
    ) {
        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.EURO);
        quantityAndUnit.setMultiplier(MultiplierEnum.NONE);
        quantityAndUnit.setPerUnit(perUnit);
        quantityAndUnit.setPerMultiplier(perMultiplier);

        var profile = esdlFactory.createTimeSeriesProfile();
        profile.setTimestep((int) Duration.ofHours(1).toSeconds());
        profile.setStartDateTime(Date.from(luxJan1stInstant(2025)));
        profile.setProfileQuantityAndUnit(quantityAndUnit);
        profile.getValues().addAll(values);

        var energyMarket = esdlFactory.createEnergyMarket();
        energyMarket.setMarketPrice(profile);

        return energyMarket;
    }
}
