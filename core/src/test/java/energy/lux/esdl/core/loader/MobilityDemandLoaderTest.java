package energy.lux.esdl.core.loader;

import energy.lux.engine.activitytrackers.J_ActivityTrackerTrips.TripRecord;
import energy.lux.esdl.core.loader.MobilityDemandLoader.ChargingSession;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * How the trip from the last charging session of the year back to the first one is laid out at
 * both ends of the year. A car consuming 0.2 kWh/km drives 50 km on 10 kWh.
 */
public class MobilityDemandLoaderTest {
    private static final double hoursPerYear = 8760;
    private static final double energyConsumption_kWhpkm = 0.2;

    @Test
    public void aLastSessionInDecemberLeavesForTheNextYearWithoutEnergy() {
        var sessions = List.of(
                new ChargingSession(18, 32, 10),
                new ChargingSession(42, 56, 12),
                new ChargingSession(8730, 8744, 8)
        );

        var trips = MobilityDemandLoader.toTrips(sessions, energyConsumption_kWhpkm);

        assertThat(trips).containsExactly(
                new TripRecord(0, 18, 50),
                new TripRecord(32, 42, 60),
                new TripRecord(56, 8730, 40),
                new TripRecord(8744, hoursPerYear + 18, 0)
        );
    }

    @Test
    public void aLastSessionIntoTheNextYearIsPluggedInWhenTheYearEnds() {
        var sessions = List.of(
                new ChargingSession(18, 32, 10),
                new ChargingSession(8754, hoursPerYear + 8, 8)
        );

        var trips = MobilityDemandLoader.toTrips(sessions, energyConsumption_kWhpkm);

        assertThat(trips).containsExactly(
                new TripRecord(8, 18, 50),
                new TripRecord(32, 8754, 40)
        );
    }

    @Test
    public void aLastSessionPastTheFirstArrivalLeavesNoTripBeforeIt() {
        var sessions = List.of(
                new ChargingSession(6, 20, 10),
                new ChargingSession(8754, hoursPerYear + 8, 8)
        );

        var trips = MobilityDemandLoader.toTrips(sessions, energyConsumption_kWhpkm);

        assertThat(trips).containsExactly(new TripRecord(20, 8754, 40));
    }
}
