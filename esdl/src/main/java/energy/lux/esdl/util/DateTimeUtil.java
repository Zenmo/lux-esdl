package energy.lux.esdl.util;

import java.time.*;
import java.time.temporal.Temporal;
import java.util.Date;

public class DateTimeUtil {
    public static Instant luxJan1stInstant(int year) {
        // LUX usually runs in the timezone Europe/Amsterdam
        var timeZone = ZoneId.of("Europe/Amsterdam");
        return ZonedDateTime.of(year, 1, 1, 0, 0, 0, 0, timeZone)
                .toInstant();
    }

    public static double hoursBetween(Instant from, Date to) {
         var milliseconds = to.getTime() - from.toEpochMilli();
         return (double) milliseconds / Duration.ofHours(1).toMillis();
    }

    public static double getHourOffset(int simulationYear, Temporal timestampToCheck) {
        var simulationYearStart = luxJan1stInstant(simulationYear);
        var milliOffset = Instant.from(timestampToCheck).toEpochMilli() - simulationYearStart.toEpochMilli();
        var hourOffset = (double) milliOffset / Duration.ofHours(1).toMillis();
        return hourOffset;
    }
}
