package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.DateTimeProfile;
import esdl.EVChargingStation;
import esdl.GenericProfile;
import esdl.MobilityDemand;
import esdl.Port;
import esdl.ProfileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.J_ActivityTrackerTrips;
import zero_engine.J_ActivityTrackerTrips.TripRecord;
import zerointerfaceloader.Zero_Loader;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Turn the yearly charging sessions of an ESDL MobilityDemand into the trips of a vehicle.
 * <p>
 * The ESDL and LUX describe the same thing from opposite sides. The ESDL states when a car was
 * plugged in and how much energy it took while it was; LUX drives trips and charges in between.
 * A session is the car standing at its charge point, so the gap from the end of one session to
 * the start of the next is a trip, and the energy of the session that follows a trip is what
 * that trip consumed, which gives its distance.
 * <p>
 * That leaves the stretch before the first session, which no session accounts for. The vehicle
 * is treated as being at home then, since there is no energy to derive a distance from.
 */
public class MobilityDemandLoader {
    private static final Logger logger = LoggerFactory.getLogger(MobilityDemandLoader.class);

    private static final double hoursPerYear = 8760;

    private final Zero_Loader luxLoader;

    private final Year simulationYear;

    public MobilityDemandLoader(Zero_Loader luxLoader) {
        this.luxLoader = luxLoader;
        this.simulationYear = Year.of(luxLoader.energyModel.p_timeParameters.getStartYear());
    }

    /**
     * @return a trip tracker built from the charging sessions of this charge point,
     *         or null when the ESDL states none, in which case LUX falls back to its own
     *         weekly trip patterns.
     */
    public J_ActivityTrackerTrips readTripTracker(EVChargingStation chargingStation) {
        var mobilityDemand = findMobilityDemand(chargingStation);
        if (mobilityDemand == null) {
            return null;
        }

        var profile = findChargingSessionProfile(mobilityDemand);
        if (profile == null) {
            logger.warn(
                    "MobilityDemand {} of charging station {} has no profile of charging sessions",
                    mobilityDemand.getName(),
                    chargingStation.getName()
            );
            return null;
        }

        var sessions = readChargingSessions(profile);
        var trips = toTrips(sessions, energyConsumptionOfACar_kWhpkm());

        return new J_ActivityTrackerTrips(luxLoader.energyModel.p_timeParameters, trips);
    }

    private static MobilityDemand findMobilityDemand(EVChargingStation chargingStation) {
        for (Port port : chargingStation.getPort()) {
            for (Port connectedPort : connectedPorts(port)) {
                if (connectedPort.getEnergyasset() instanceof MobilityDemand mobilityDemand) {
                    return mobilityDemand;
                }
            }
        }
        return null;
    }

    private static List<? extends Port> connectedPorts(Port port) {
        if (port instanceof esdl.OutPort outPort) {
            return outPort.getConnectedTo();
        }
        if (port instanceof esdl.InPort inPort) {
            return inPort.getConnectedTo();
        }
        return List.of();
    }

    private static DateTimeProfile findChargingSessionProfile(MobilityDemand mobilityDemand) {
        GenericProfile profile = energy.lux.esdl.core.util.Util.findFirstProfile(mobilityDemand);
        if (profile == null) {
            return null;
        }
        if (!(profile instanceof DateTimeProfile dateTimeProfile)) {
            throw new NotImplemented(
                    "Charging sessions are expected to be a DateTimeProfile, found " + profile
            );
        }
        return dateTimeProfile;
    }

    /**
     * A charging session: the vehicle is at its charge point between these two moments,
     * expressed in hours since the start of the simulation year.
     */
    private record ChargingSession(double arrival_h, double departure_h, double chargedEnergy_kWh) {
    }

    private List<ChargingSession> readChargingSessions(DateTimeProfile profile) {
        var sessions = new ArrayList<ChargingSession>();

        for (ProfileElement element : profile.getElement()) {
            var arrival_h = hoursSinceStartOfSimulationYear(element.getFrom());
            var departure_h = hoursSinceStartOfSimulationYear(element.getTo());

            // A handful of sessions run over the end of the year and come back stamped with
            // the January of the same year instead of the next one.
            if (departure_h < arrival_h) {
                departure_h += hoursPerYear;
            }

            sessions.add(new ChargingSession(arrival_h, departure_h, element.getValue()));
        }

        sessions.sort(Comparator.comparingDouble(ChargingSession::arrival_h));
        return sessions;
    }

    /**
     * Every gap between two consecutive sessions is one trip. Sessions that touch leave no gap
     * and so produce no trip; the energy of the second one is then simply charged on arrival.
     */
    private static List<TripRecord> toTrips(List<ChargingSession> sessions, double energyConsumption_kWhpkm) {
        var trips = new ArrayList<TripRecord>();

        for (int i = 0; i + 1 < sessions.size(); i++) {
            var departure = sessions.get(i).departure_h();
            var nextArrival = sessions.get(i + 1);
            if (nextArrival.arrival_h() <= departure) {
                continue;
            }

            trips.add(new TripRecord(
                    departure,
                    nextArrival.arrival_h(),
                    nextArrival.chargedEnergy_kWh() / energyConsumption_kWhpkm
            ));
        }

        return trips;
    }

    /**
     * The same figure that the LUX loader would give the vehicle, so that turning energy back
     * into distance here and distance back into energy in the engine cancel out.
     */
    private double energyConsumptionOfACar_kWhpkm() {
        return luxLoader.avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;
    }

    private double hoursSinceStartOfSimulationYear(java.util.Date timestamp) {
        return DateTimeUtil.getHourOffset(simulationYear, timestamp.toInstant());
    }
}
