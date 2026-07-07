package energy.lux.esdl.core.loader.profile.unit;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import esdl.AbstractQuantityAndUnit;
import esdl.MultiplierEnum;
import esdl.QuantityAndUnitReference;
import esdl.QuantityAndUnitType;
import esdl.UnitEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.OL_ProfileUnits;

/**
 * Converts electricity demand profiles to the LUX unit kW.
 */
public class ElectricityDemandConverter {
    private static final Logger logger = LoggerFactory.getLogger(ElectricityDemandConverter.class);

    public static TimeSeriesWithUnit timeSeriesToLuxUnit(
            ArrayTimeSeries timeSeries,
            AbstractQuantityAndUnit quantityAndUnit
    ) {
        return timeSeriesToLuxUnit(timeSeries, abstractToReal(quantityAndUnit));
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

    private static TimeSeriesWithUnit timeSeriesToLuxUnit(
            ArrayTimeSeries timeSeries,
            QuantityAndUnitType esdlQuantityAndUnit
    ) {
        if (esdlQuantityAndUnit == null || esdlQuantityAndUnit.getUnit() == null) {
            logger.error("No unit given for electricity demand. Assuming W");

            return new TimeSeriesWithUnit(
                    timeSeries.mapValues(ElectricityDemandConverter::wattToKilowatt),
                    OL_ProfileUnits.KW
            );
        }

        var unit = esdlQuantityAndUnit.getUnit();
        var multiplier = esdlQuantityAndUnit.getMultiplier();

        if (unit == UnitEnum.WATT) {
            if (multiplier == MultiplierEnum.NONE) {
                return new TimeSeriesWithUnit(
                        timeSeries.mapValues(ElectricityDemandConverter::wattToKilowatt),
                        OL_ProfileUnits.KW
                );
            }

            if (multiplier == MultiplierEnum.KILO) {
                return new TimeSeriesWithUnit(
                        timeSeries,
                        OL_ProfileUnits.KW
                );
            }
        }

        throw new NotImplemented(
                String.format(
                        "Electricity demand unit %s%s is not implemented",
                        multiplier == MultiplierEnum.NONE ? "" : multiplier.toString(),
                        unit
                )
        );
    }

    private static double wattToKilowatt(double watt) {
        return watt * 0.001;
    }
}
