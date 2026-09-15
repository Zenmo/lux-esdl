package energy.lux.esdl.core.loader.profile;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.DateTimeProfile;
import esdl.ProfileElement;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * An hourly price signal that is charged on top of the day-ahead market price.
 * LUX has no notion of a time of use tariff, so the reader folds it into the day-ahead price
 * profile before the engine ever sees it.
 * The ESDL states the tariff for the first day of every month, hour by hour. That is how the
 * seasonal variation is expressed: every day of a month repeats the tariff of that month's
 * first day.
 * The values in the file are weights between 0 and 1. What one unit of weight is worth is still
 * an open policy question and is not expected to be settled before 2028, so
 * tariffHeight_eurpMWh stands in for it.
 */
public class TimeOfUseTariff {
    private static final int monthsPerYear = 12;
    private static final int hoursPerDay = 24;
    private static final Duration expectedElementDuration = Duration.ofHours(1);
    private static final double tariffHeight_eurpMWh = 200.0;
    private final double[][] weightByMonthAndHour;

    private TimeOfUseTariff(double[][] weightByMonthAndHour) {
        this.weightByMonthAndHour = weightByMonthAndHour;
    }

    public static TimeOfUseTariff fromProfile(DateTimeProfile profile) {
        var weightByMonthAndHour = new double[monthsPerYear][hoursPerDay];
        var isFilled = new boolean[monthsPerYear][hoursPerDay];

        for (ProfileElement element : profile.getElement()) {
            assertElementCoversOneHour(element);

            var from = toLuxZone(element.getFrom().toInstant());
            var month = from.getMonthValue() - 1;
            var hour = from.getHour();

            weightByMonthAndHour[month][hour] = element.getValue();
            isFilled[month][hour] = true;
        }

        assertEveryHourIsFilled(isFilled);

        return new TimeOfUseTariff(weightByMonthAndHour);
    }

    public ArrayTimeSeries addTo(ArrayTimeSeries dayAheadPrices_eurpMWh) {
        var start = Instant.from(dayAheadPrices_eurpMWh.getStart());
        var stepSeconds = Math.round(DateTimeUtil.durationToHours(dayAheadPrices_eurpMWh.getStep()) * 3600);

        var values = dayAheadPrices_eurpMWh.copyValuesArray();
        for (int i = 0; i < values.length; i++) {
            values[i] += tariff_eurpMWh(toLuxZone(start.plusSeconds(i * stepSeconds)));
        }

        return (ArrayTimeSeries) dayAheadPrices_eurpMWh.toBuilder()
                .values(values)
                .build();
    }

    public double tariff_eurpMWh(ZonedDateTime moment) {
        return weightByMonthAndHour[moment.getMonthValue() - 1][moment.getHour()] * tariffHeight_eurpMWh;
    }

    public double peakTariff_eurpMWh() {
        var peakWeight = 0.0;
        for (double[] weightsOfMonth : weightByMonthAndHour) {
            for (double weight : weightsOfMonth) {
                peakWeight = Math.max(peakWeight, weight);
            }
        }
        return peakWeight * tariffHeight_eurpMWh;
    }

    private static ZonedDateTime toLuxZone(Instant instant) {
        return instant.atZone(DateTimeUtil.luxTimeZone);
    }

    private static void assertElementCoversOneHour(ProfileElement element) {
        var duration = Duration.between(element.getFrom().toInstant(), element.getTo().toInstant());
        if (!duration.equals(expectedElementDuration)) {
            throw new EsdlException(
                    "Time of use tariff is expected to be hourly, but an element covers " + duration
            );
        }
    }

    private static void assertEveryHourIsFilled(boolean[][] isFilled) {
        for (int month = 0; month < monthsPerYear; month++) {
            for (int hour = 0; hour < hoursPerDay; hour++) {
                if (!isFilled[month][hour]) {
                    throw new EsdlException(String.format(
                            "Time of use tariff has no value for hour %d of month %d."
                                    + " It is expected to state every hour of the first day of every month.",
                            hour,
                            month + 1
                    ));
                }
            }
        }
    }
}
