package energy.lux.esdl.core.util;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DateTimeUtil {
    public static Instant luxJan1stInstant(int year) {
        return luxJan1stInstant(Year.of(year));
    }

    public static Instant luxJan1stInstant(Year year) {
        // LUX usually runs in the timezone Europe/Amsterdam
        var timeZone = ZoneId.of("Europe/Amsterdam");
        return year.atMonth(1).atDay(1).atStartOfDay(timeZone).toInstant();
    }

    public static double hoursBetween(Date from, Date to) {
        var milliseconds = to.getTime() - from.getTime();
        return (double) milliseconds / Duration.ofHours(1).toMillis();
    }

    public static double hoursBetween(Instant from, Date to) {
         var milliseconds = to.getTime() - from.toEpochMilli();
         return (double) milliseconds / Duration.ofHours(1).toMillis();
    }

    public static double getHourOffset(Year simulationYear, Temporal timestampToCheck) {
        var simulationYearStart = luxJan1stInstant(simulationYear);
        var durationBetween = Duration.between(simulationYearStart, timestampToCheck);
        return durationBetween.getSeconds() / 3600.0;
    }

    public static Duration hoursToDuration(double hours) {
        var seconds = hours * 3600;
        return Duration.ofSeconds((long) seconds);
    }

    public static double durationToHours(TemporalAmount duration) {
        var seconds = 0L;

        for (TemporalUnit unit : duration.getUnits()) {
            seconds += duration.get(unit) * unit.getDuration().getSeconds();
        }

        return seconds / 3600.0;
    }
}
