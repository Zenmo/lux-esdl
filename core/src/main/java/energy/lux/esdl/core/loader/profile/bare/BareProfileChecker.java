package energy.lux.esdl.core.loader.profile.bare;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.time.Year;
import java.time.temporal.ChronoUnit;

/**
 * Check that the data of a time series is suitable for the simulation year.
 * Emit warnings if it doesn't.
 */
public class BareProfileChecker {
    private static final Logger logger = LoggerFactory.getLogger(BareProfileChecker.class);

    private final Year luxStartYear;

    public BareProfileChecker(Year luxStartYear) {
        this.luxStartYear = luxStartYear;
    }

    void checkProfileEclipsesSimulationPeriod(
            ArrayTimeSeries timeSeries,
            String id
    ) {
        var luxStart = DateTimeUtil.luxJan1stInstant(luxStartYear);
        var luxEnd = luxStart.plus(365, ChronoUnit.DAYS);

        var profileStart = Instant.from(timeSeries.getStart());
        var profileEnd = Instant.from(timeSeries.getEnd());

        if (!profileStart.isAfter(luxStart) && !profileEnd.isBefore(luxEnd)) {
            // All is fine.
            // Profile includes the entire simulation year.
            return;
        }

        var profileDuration = Duration.between(profileStart, profileEnd);
        var isTooShort = profileDuration.toDays() < 365;
        if (isTooShort) {
            logger.error(
                    "Time series is shorter than one year. Id {}, duration {}, start {}",
                    id,
                    profileDuration,
                    profileStart
            );
        }

        if (profileEnd.isBefore(luxStart)) {
            logger.error(
                    "Time series is entirely before simulation year {}. Id {}, start {}, end {}",
                    luxStartYear,
                    id,
                    profileStart,
                    profileEnd
            );
            return;
        }

        if (profileStart.isAfter(luxEnd)) {
            logger.error(
                    "Time series is entirely after simulation year. Id {}, start {}, end {}",
                    id,
                    profileStart,
                    profileEnd
            );
            return;
        }

        if (!isTooShort) {
            logger.error(
                    "Time series does not fully eclipse simulation year. Id {}, start {}, end {}",
                    id,
                    profileStart,
                    profileEnd
            );
        }
    }
}
