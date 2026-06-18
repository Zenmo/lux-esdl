package energy.lux.esdl.core.loader.profile.unit;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import esdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.OL_ProfileUnits;

import java.util.Arrays;

/**
 * This code is called after the raw time series has been read.
 *
 * It reads takes the unit from ESDL and, if necessary,
 * does a conversion to the unit used in LUX.
 */
public class OutsideTemperatureConverter {
    private static final Logger logger = LoggerFactory.getLogger(OutsideTemperatureConverter.class);

    private static final double minReasonableTemperatureC = -50.0;
    private static final double maxReasonableTemperatureC = 50.0;

    public static TimeSeriesWithUnit timeSeriesToLuxUnit(
            ArrayTimeSeries timeSeries,
            AbstractQuantityAndUnit quantityAndUnit
    ) {
        return timeSeriesToLuxUnit(timeSeries, abstractToReal(quantityAndUnit));
    }

    private static QuantityAndUnitType abstractToReal(AbstractQuantityAndUnit quantityAndUnit) {
        if (quantityAndUnit == null) {
            return null;
        } if (quantityAndUnit instanceof QuantityAndUnitType actual) {
            return actual;
        } else if (quantityAndUnit instanceof QuantityAndUnitReference reference) {
            return reference.getReference();
        } else {
            throw new EsdlException("Unknown QuantityAndUnit implementation " + quantityAndUnit);
        }
    }

    private static TimeSeriesWithUnit timeSeriesToLuxUnit(
            ArrayTimeSeries timeSeries,
            QuantityAndUnitType esdlQuantityAndUnit
    ) {
        checkUnexpectedUnitOrQuantity(esdlQuantityAndUnit);

        var convertedTimeSeries = convertTimeSeries(timeSeries, esdlQuantityAndUnit);

        checkReasonableOutsideTemperature(convertedTimeSeries.timeSeries());

        return convertedTimeSeries;
    }

    private static TimeSeriesWithUnit convertTimeSeries(
            ArrayTimeSeries timeSeries,
            QuantityAndUnitType esdlQuantityAndUnit
    ) {
        var unit = esdlQuantityAndUnit == null ? null : esdlQuantityAndUnit.getUnit();
        if (unit == null) {
            logger.warn("No unit given for outside temperature. Assuming Celsius");

            unit = UnitEnum.DEGREES_CELSIUS;
        }

        return switch (unit) {
            case DEGREES_CELSIUS -> new TimeSeriesWithUnit(
                    timeSeries,
                    OL_ProfileUnits.TEMPERATURE_DEGC
            );
            case KELVIN -> new TimeSeriesWithUnit(
                    timeSeries.mapValues(OutsideTemperatureConverter::kelvinToCelsius),
                    OL_ProfileUnits.TEMPERATURE_DEGC
            );
            default -> throw new EsdlException("Unexpected temperature unit " + unit);
        };
    }

    private static double kelvinToCelsius(double v) {
        return v - 273.15;
    }

    private static void checkReasonableOutsideTemperature(ArrayTimeSeries timeSeries) {
        var values = timeSeries.copyValuesArray();

        var minTempC = Arrays.stream(values).min().getAsDouble();
        var maxTempC = Arrays.stream(values).max().getAsDouble();

        if (minTempC < minReasonableTemperatureC
                || maxTempC > maxReasonableTemperatureC
        ) {
            throw new EsdlException(
                    String.format(
                            "Profile has unreasonable temperature range of %.0f to %.0f °C",
                            minTempC,
                            maxTempC
                    )

            );
        }
    }
    
    private static void checkUnexpectedUnitOrQuantity(QuantityAndUnitType esdlQuantityAndUnit) {
        if (esdlQuantityAndUnit == null) {
            return;
        }
        
        checkQuantity(esdlQuantityAndUnit.getPhysicalQuantity());

        var perUnit = esdlQuantityAndUnit.getPerUnit();
        if (perUnit != UnitEnum.NONE) {
            throw new EsdlException(
                    String.format(
                            "Unexpected Per Unit %s for outside temperature",
                            perUnit
                    )
            );
        }
        var perTimeUnit = esdlQuantityAndUnit.getPerTimeUnit();
        if (perTimeUnit != TimeUnitEnum.NONE) {
            throw new EsdlException(
                    String.format(
                            "Unexpected Per Time Unit %s for outside temperature",
                            perTimeUnit
                    )
            );
        }
        var multiplier = esdlQuantityAndUnit.getMultiplier();
        if (multiplier != MultiplierEnum.NONE) {
            throw new EsdlException(
                    String.format(
                            "Unexpected multiplier %s for outside temperature",
                            multiplier
                    )
            );
        }
    }

    private static void checkQuantity(PhysicalQuantityEnum quantityEnum) {
        if (quantityEnum == null) {
            return;
        }

        if (quantityEnum != PhysicalQuantityEnum.TEMPERATURE) {
            throw new EsdlException(
                    String.format(
                            "Unexpected physical quantity %s for outside temperature",
                            quantityEnum
                    )
            );
        }
    }
}

