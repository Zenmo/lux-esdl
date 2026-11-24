package energy.lux.esdl.core.loader.profile;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.DateTimeProfile;
import esdl.ProfileElement;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * An hourly grid operator tariff that a house pays on top of the day-ahead market price, but only
 * on what it takes from the grid: feeding in earns none of it. So it is not folded into the
 * day-ahead price, which would let V2G and batteries trade on it. LUX itself has no notion of
 * it; the ISIE aggregators are given it as a profile of its own.
 * The ESDL states the tariff for the first day of every month, in blocks of whole hours. That is
 * how the seasonal variation is expressed: every day of a month repeats the tariff of that
 * month's first day. A block without a value has weight 0: EMF does not write a value equal to
 * its default.
 * The values in the file are weights between 0 and 1. What one unit of weight is worth is still
 * an open policy question and is not expected to be settled before 2028, so
 * tariffHeight_eurpMWh stands in for it.
 */
public class TimeOfUseTariff {
    private static final int monthsPerYear = 12;
    private static final int hoursPerDay = 24;
    private static final Duration hour = Duration.ofHours(1);
    /**
     * What one unit of tariff weight is worth, in EUR/MWh. 600 EUR/MWh is 60 cents/kWh.
     */
    private static final double tariffHeight_eurpMWh = 600.0;
    private final double[][] weightByMonthAndHour;

    private TimeOfUseTariff(double[][] weightByMonthAndHour) {
        this.weightByMonthAndHour = weightByMonthAndHour;
    }

    public static TimeOfUseTariff fromProfile(DateTimeProfile profile) {
        var weightByMonthAndHour = new double[monthsPerYear][hoursPerDay];
        var isFilled = new boolean[monthsPerYear][hoursPerDay];

        for (ProfileElement element : profile.getElement()) {
            for (Instant hourStart : hoursCoveredBy(element)) {
                var from = toLuxZone(hourStart);
                var month = from.getMonthValue() - 1;
                var hourOfDay = from.getHour();

                weightByMonthAndHour[month][hourOfDay] = element.getValue();
                isFilled[month][hourOfDay] = true;
            }
        }

        assertEveryHourIsFilled(isFilled);

        return new TimeOfUseTariff(weightByMonthAndHour);
    }

    /**
     * The tariff on the same timesteps as the given series, so the two line up in the engine.
     */
    public ArrayTimeSeries onTimestepsOf(ArrayTimeSeries dayAheadPrices_eurpMWh) {
        var start = Instant.from(dayAheadPrices_eurpMWh.getStart());
        var stepSeconds = Math.round(DateTimeUtil.durationToHours(dayAheadPrices_eurpMWh.getStep()) * 3600);

        var values = new double[dayAheadPrices_eurpMWh.copyValuesArray().length];
        for (int i = 0; i < values.length; i++) {
            values[i] = tariff_eurpMWh(toLuxZone(start.plusSeconds(i * stepSeconds)));
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

    private static List<Instant> hoursCoveredBy(ProfileElement element) {
        var from = element.getFrom().toInstant();
        var to = element.getTo().toInstant();
        assertCoversWholeHours(from, to);
        var hourStarts = new ArrayList<Instant>();
        for (var hourStart = from; hourStart.isBefore(to); hourStart = hourStart.plus(hour)) {
            hourStarts.add(hourStart);
        }
        return hourStarts;
    }

    private static void assertCoversWholeHours(Instant from, Instant to) {
        var duration = Duration.between(from, to);
        var startsOnTheHour = from.getEpochSecond() % hour.toSeconds() == 0 && from.getNano() == 0;
        if (!startsOnTheHour || duration.isNegative() || duration.isZero() || duration.toSeconds() % hour.toSeconds() != 0) {
            throw new EsdlException(String.format(
                    "Time of use tariff is expected in blocks of whole hours, but an element runs from %s to %s",
                    from,
                    to
            ));
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
