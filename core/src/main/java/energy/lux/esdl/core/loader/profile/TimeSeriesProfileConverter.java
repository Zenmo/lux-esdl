package energy.lux.esdl.core.loader.profile;

import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.TimeSeriesProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

public class TimeSeriesProfileConverter {
    private static final Logger logger = LoggerFactory.getLogger(TimeSeriesProfileConverter.class);

    static public UnitlessProfile convertTimeSeries(
            TimeSeriesProfile esdlTimeSeries,
            int luxStartYear,
            Function<Double, Double> valueTransformer
    ) {
        sanityChecks(esdlTimeSeries, luxStartYear);

        var values = esdlTimeSeries
                .getValues()
                .stream()
                .mapToDouble(valueTransformer::apply)
                .toArray();

        var firstHour = DateTimeUtil.getHourOffset(luxStartYear, esdlTimeSeries.getStartDateTime().toInstant());
        var stepInSeconds = esdlTimeSeries.getTimestep();
        var stepInHours = stepInSeconds / 3600.0;

        return new UnitlessProfile(firstHour, stepInHours, values);
    }

    private static void sanityChecks(
            TimeSeriesProfile esdlTimeSeries,
            int luxStartYear
    ) {
        var luxStart = DateTimeUtil.luxJan1stInstant(luxStartYear);
        var luxEnd = luxStart.plus(365, ChronoUnit.DAYS);

        var profileStart = esdlTimeSeries.getStartDateTime().toInstant();
        var profileEnd = getProfileEnd(esdlTimeSeries);

        if (!profileStart.isAfter(luxStart) && !profileEnd.isBefore(luxEnd)) {
            // All is fine.
            // Profile includes the entire simulation year.
            return;
        }

        var profileDuration = getProfileDuration(esdlTimeSeries);
        if (profileDuration.toDays() < 365) {
            logger.error(
                    "Time series is shorter than one year. Id {}, duration {}",
                    esdlTimeSeries.getId(),
                    profileDuration
            );
            return;
        }

        logger.error(
                "Time series is outside of simulation year. Id {}, size {}, start {}, end {}",
                esdlTimeSeries.getId(),
                esdlTimeSeries.getValues().size(),
                profileStart,
                profileEnd
        );

        // We could check the alignment of the timeseries to prevent erroneous wrap-around behaviour,
        // but I think this is more of a core LUX issue.
    }

    private static Instant getProfileEnd(TimeSeriesProfile timeSeriesProfile) {
        var secondsLength = timeSeriesProfile.getTimestep() * timeSeriesProfile.getValues().size();

        return timeSeriesProfile
                .getStartDateTime()
                .toInstant()
                .plusSeconds(secondsLength);
    }

    private static Duration getProfileDuration(TimeSeriesProfile esdlTimeSeries) {
        var secondsLength = esdlTimeSeries.getTimestep() * esdlTimeSeries.getValues().size();
        return Duration.ofSeconds(secondsLength);
    }
}
