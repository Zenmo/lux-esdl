package energy.lux.esdl.core.loader.profile.unit;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import zero_engine.OL_ProfileUnits;

public record TimeSeriesWithUnit(
        ArrayTimeSeries timeSeries,
        OL_ProfileUnits unit
) {
}
