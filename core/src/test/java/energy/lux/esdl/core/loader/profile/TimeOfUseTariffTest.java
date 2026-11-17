package energy.lux.esdl.core.loader.profile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import energy.lux.esdl.core.EsdlException;
import esdl.DateTimeProfile;
import esdl.EsdlFactory;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 * The tariff as the November 2026 ISIE scenarios state it: for the first day of every month, in UTC, 0.5 from 00:00,
 * 0.3 from 03:00, nothing from 10:00 to 17:00, 0.3 from 17:00 and 0.7 from 19:00 until midnight. One unit of weight
 * is worth 600 EUR/MWh.
 */
public class TimeOfUseTariffTest {
    private static final ZoneId amsterdam = ZoneId.of("Europe/Amsterdam");

    @Test
    void everyHourOfABlockHasTheWeightOfTheBlock() {
        var tariff = TimeOfUseTariff.fromProfile(scenarioProfile());

        // 21:00 in Amsterdam in June is 19:00 UTC.
        assertThat(tariff.tariff_eurpMWh(LocalDateTime.of(2050, 6, 15, 21, 0).atZone(amsterdam))).isCloseTo(420, within(1e-9));
        // 01:00 in Amsterdam is 23:00 UTC, the last hour of that block.
        assertThat(tariff.tariff_eurpMWh(LocalDateTime.of(2050, 6, 15, 1, 0).atZone(amsterdam))).isCloseTo(420, within(1e-9));
        assertThat(tariff.tariff_eurpMWh(LocalDateTime.of(2050, 6, 15, 7, 0).atZone(amsterdam))).isCloseTo(180, within(1e-9));
        assertThat(tariff.peakTariff_eurpMWh()).isCloseTo(420, within(1e-9));
    }

    @Test
    void aBlockWithoutAValueChargesNothing() {
        var tariff = TimeOfUseTariff.fromProfile(scenarioProfile());

        assertThat(tariff.tariff_eurpMWh(LocalDateTime.of(2050, 6, 15, 13, 0).atZone(amsterdam))).isZero();
    }

    @Test
    void aBlockThatIsNotWholeHoursIsRefused() {
        var profile = scenarioProfile();
        profile.getElement().get(0).setTo(Date.from(utc(2050, 1, 1, 1, 30)));

        assertThatThrownBy(() -> TimeOfUseTariff.fromProfile(profile)).isInstanceOf(EsdlException.class);
    }

    private static DateTimeProfile scenarioProfile() {
        var profile = EsdlFactory.eINSTANCE.createDateTimeProfile();
        for (int month = 1; month <= 12; month++) {
            addBlock(profile, month, 0, 3, 0.5);
            addBlock(profile, month, 3, 10, 0.3);
            addBlockWithoutValue(profile, month, 10, 17);
            addBlock(profile, month, 17, 19, 0.3);
            addBlock(profile, month, 19, 24, 0.7);
        }
        return profile;
    }

    private static void addBlock(DateTimeProfile profile, int month, int fromHour, int toHour, double weight) {
        addBlockWithoutValue(profile, month, fromHour, toHour);
        profile.getElement().get(profile.getElement().size() - 1).setValue(weight);
    }

    private static void addBlockWithoutValue(DateTimeProfile profile, int month, int fromHour, int toHour) {
        var element = EsdlFactory.eINSTANCE.createProfileElement();
        element.setFrom(Date.from(utc(2050, month, 1, fromHour, 0)));
        element.setTo(Date.from(utc(2050, month, 1, 0, 0).plusSeconds(toHour * 3600L)));
        profile.getElement().add(element);
    }

    private static Instant utc(int year, int month, int day, int hour, int minute) {
        return LocalDateTime.of(year, month, day, hour, minute).toInstant(ZoneOffset.UTC);
    }
}
