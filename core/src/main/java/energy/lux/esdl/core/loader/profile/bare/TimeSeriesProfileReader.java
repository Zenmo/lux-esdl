package energy.lux.esdl.core.loader.profile.bare;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import com.zenmo.timeseries.untyped.TimeSeries;
import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.TimeSeriesProfile;
import org.apache.commons.math3.util.DoubleArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

class TimeSeriesProfileReader {
    private static final Logger logger = LoggerFactory.getLogger(TimeSeriesProfileReader.class);

    static public ArrayTimeSeries readProfile(
            TimeSeriesProfile esdlTimeSeries
    ) {
        var values = esdlTimeSeries
                .getValues()
                .stream()
                .mapToDouble(Double::doubleValue)
                .toArray();

        var stepInSeconds = esdlTimeSeries.getTimestep();
        var esdlStep = Duration.ofSeconds(stepInSeconds);

        var timeSeriesWithEsdlStep = TimeSeries.builder()
                .step(esdlStep)
                .values(values)
                .start(esdlTimeSeries.getStartDateTime().toInstant())
                .build();

        return (ArrayTimeSeries) timeSeriesWithEsdlStep;
    }
}
