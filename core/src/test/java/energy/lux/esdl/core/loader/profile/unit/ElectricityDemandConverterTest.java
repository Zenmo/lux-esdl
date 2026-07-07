package energy.lux.esdl.core.loader.profile.unit;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.NotImplemented;
import esdl.EsdlFactory;
import esdl.MultiplierEnum;
import esdl.UnitEnum;
import org.junit.jupiter.api.Test;
import zero_engine.OL_ProfileUnits;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ElectricityDemandConverterTest {
    private final EsdlFactory esdlFactory = EsdlFactory.eINSTANCE;

    @Test
    public void testWattIsConvertedToKilowatt() {
        var timeSeries = ArrayTimeSeries.builder()
                .step(Duration.ofHours(1))
                .values(new double[]{1000.0, 2000.0})
                .start(Instant.now())
                .build();
        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.WATT);
        quantityAndUnit.setMultiplier(MultiplierEnum.NONE);

        var result = ElectricityDemandConverter.timeSeriesToLuxUnit(timeSeries, quantityAndUnit);

        assertEquals(OL_ProfileUnits.KW, result.unit());
        assertEquals(1.0, result.timeSeries().copyValuesArray()[0]);
        assertEquals(2.0, result.timeSeries().copyValuesArray()[1]);
    }

    @Test
    public void testKilowattIsKeptAsIs() {
        var timeSeries = ArrayTimeSeries.builder()
                .step(Duration.ofHours(1))
                .values(new double[]{1.0, 2.0})
                .start(Instant.now())
                .build();
        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.WATT);
        quantityAndUnit.setMultiplier(MultiplierEnum.KILO);

        var result = ElectricityDemandConverter.timeSeriesToLuxUnit(timeSeries, quantityAndUnit);

        assertEquals(OL_ProfileUnits.KW, result.unit());
        assertEquals(1.0, result.timeSeries().copyValuesArray()[0]);
        assertEquals(2.0, result.timeSeries().copyValuesArray()[1]);
    }

    @Test
    public void testNoUnitAssumesWattAndConvertsToKilowatt() {
        var timeSeries = ArrayTimeSeries.builder()
                .step(Duration.ofHours(1))
                .values(new double[]{1000.0})
                .start(Instant.now())
                .build();

        var result = ElectricityDemandConverter.timeSeriesToLuxUnit(timeSeries, null);

        assertEquals(OL_ProfileUnits.KW, result.unit());
        assertEquals(1.0, result.timeSeries().copyValuesArray()[0]);
    }

    @Test
    public void testUnsupportedUnitThrowsNotImplemented() {
        var timeSeries = ArrayTimeSeries.builder()
                .step(Duration.ofHours(1))
                .values(new double[]{1.0})
                .start(Instant.now())
                .build();
        var quantityAndUnit = esdlFactory.createQuantityAndUnitType();
        quantityAndUnit.setUnit(UnitEnum.JOULE);

        assertThrows(NotImplemented.class, () ->
            ElectricityDemandConverter.timeSeriesToLuxUnit(timeSeries, quantityAndUnit)
        );
    }
}
