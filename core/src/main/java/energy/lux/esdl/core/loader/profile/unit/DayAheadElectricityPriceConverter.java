package energy.lux.esdl.core.loader.profile.unit;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import esdl.AbstractQuantityAndUnit;
import esdl.MultiplierEnum;
import esdl.QuantityAndUnitReference;
import esdl.QuantityAndUnitType;
import esdl.UnitEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.OL_ProfileUnits;

/**
 * Converts day-ahead electricity pricing profiles to the LUX unit €/MWh.
 */
public class DayAheadElectricityPriceConverter {
    private static final Logger logger = LoggerFactory.getLogger(DayAheadElectricityPriceConverter.class);

    private static final double MIN_EXPECTED_PRICE_EUR_PER_MWH = -1000.0;
    private static final double MAX_EXPECTED_PRICE_EUR_PER_MWH = 10_000.0;

    public static TimeSeriesWithUnit timeSeriesToLuxUnit(
            ArrayTimeSeries timeSeries,
            AbstractQuantityAndUnit quantityAndUnit
    ) {
        var convertedTimeSeries = convertTimeSeries(timeSeries, abstractToReal(quantityAndUnit));

        checkExpectedPriceRange(convertedTimeSeries.timeSeries());

        return convertedTimeSeries;
    }

    private static QuantityAndUnitType abstractToReal(AbstractQuantityAndUnit quantityAndUnit) {
        if (quantityAndUnit == null) {
            return null;
        }
        if (quantityAndUnit instanceof QuantityAndUnitType actual) {
            return actual;
        }
        if (quantityAndUnit instanceof QuantityAndUnitReference reference) {
            return reference.getReference();
        }

        throw new EsdlException("Unknown QuantityAndUnit implementation " + quantityAndUnit);
    }

    private static TimeSeriesWithUnit convertTimeSeries(
            ArrayTimeSeries timeSeries,
            QuantityAndUnitType esdlQuantityAndUnit
    ) {
        if (esdlQuantityAndUnit == null || esdlQuantityAndUnit.getUnit() == null) {
            logger.error("No unit given for day-ahead electricity pricing. Assuming €/MWh");

            return new TimeSeriesWithUnit(
                    timeSeries,
                    OL_ProfileUnits.PRICE_EURPMWH
            );
        }

        checkEuroNumerator(esdlQuantityAndUnit);

        var perUnit = esdlQuantityAndUnit.getPerUnit();
        var perMultiplier = esdlQuantityAndUnit.getPerMultiplier();

        if (perUnit == UnitEnum.WATTHOUR && perMultiplier == MultiplierEnum.MEGA) {
            return new TimeSeriesWithUnit(
                    timeSeries,
                    OL_ProfileUnits.PRICE_EURPMWH
            );
        }

        if (perUnit == UnitEnum.WATTHOUR && perMultiplier == MultiplierEnum.KILO) {
            return new TimeSeriesWithUnit(
                    timeSeries.mapValues(DayAheadElectricityPriceConverter::euroPerKWhToEuroPerMWh),
                    OL_ProfileUnits.PRICE_EURPMWH
            );
        }

        if (perUnit == UnitEnum.JOULE && perMultiplier == MultiplierEnum.GIGA) {
            return new TimeSeriesWithUnit(
                    timeSeries.mapValues(DayAheadElectricityPriceConverter::euroPerGJToEuroPerMWh),
                    OL_ProfileUnits.PRICE_EURPMWH
            );
        }

        throw new EsdlException(
                String.format(
                        "Unexpected day-ahead electricity pricing unit %s per %s%s",
                        esdlQuantityAndUnit.getUnit(),
                        perMultiplier,
                        perUnit
                )
        );
    }

    private static void checkEuroNumerator(QuantityAndUnitType esdlQuantityAndUnit) {
        if (esdlQuantityAndUnit.getUnit() != UnitEnum.EURO) {
            throw new EsdlException(
                    String.format(
                            "Unexpected day-ahead electricity pricing unit %s. Expected EURO",
                            esdlQuantityAndUnit.getUnit()
                    )
            );
        }

        if (esdlQuantityAndUnit.getMultiplier() != MultiplierEnum.NONE) {
            throw new EsdlException(
                    String.format(
                            "Unexpected day-ahead electricity pricing multiplier %s",
                            esdlQuantityAndUnit.getMultiplier()
                    )
            );
        }
    }

    private static double euroPerKWhToEuroPerMWh(double value) {
        return value * 1000.0;
    }

    private static double euroPerGJToEuroPerMWh(double value) {
        return value * 3.6;
    }

    private static void checkExpectedPriceRange(ArrayTimeSeries priceTimeSeries) {
        for (var value : priceTimeSeries.copyValuesArray()) {
            if (value < MIN_EXPECTED_PRICE_EUR_PER_MWH || value > MAX_EXPECTED_PRICE_EUR_PER_MWH) {
                logger.error(
                        "Day-ahead electricity price {} €/MWh is outside the expected range [-1000, 10_000] €/MWh",
                        value
                );
            }
        }
    }
}
