package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.DateTimeUtil;
import esdl.DateTimeProfile;
import esdl.EVChargingStation;
import esdl.GenericProfile;
import esdl.MobilityDemand;
import esdl.Port;
import esdl.ProfileElement;
import energy.lux.engine.activitytrackers.J_ActivityTrackerTrips;
import energy.lux.engine.activitytrackers.J_ActivityTrackerTrips.TripRecord;
import energy.lux.engine.EnergyModel;

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
 * The energy of a session is what the charge point drew from the grid. Only the efficiency of
 * the charge point times that ends up in the battery, so only that much was driven. The engine
 * applies the same efficiency when it charges, so it draws the stated energy from the grid again.
 * <p>
 * That leaves the stretch before the first session, which no session accounts for. The vehicle
 * is treated as being at home then, since there is no energy to derive a distance from.
 */
public class MobilityDemandLoader {
    private static final double hoursPerYear = 8760;

    private final EnergyModel energyModel;

    private final Year simulationYear;

    public MobilityDemandLoader(EnergyModel energyModel) {
        this.energyModel = energyModel;
        this.simulationYear = Year.of(energyModel.p_timeParameters.getStartYear());
    }

    /**
     * @return a trip tracker built from the charging sessions of this charge point.
     * @throws EsdlException when the charge point has no MobilityDemand with charging sessions,
     *         since there is then nothing to derive its trips from.
     */
    public J_ActivityTrackerTrips readTripTracker(EVChargingStation chargingStation) {
        var mobilityDemand = findMobilityDemand(chargingStation);
        if (mobilityDemand == null) {
            throw new EsdlException(
                    "Charge point " + chargingStation.getName() + " is not connected to a MobilityDemand"
            );
        }

        var profile = findChargingSessionProfile(mobilityDemand);
        if (profile == null) {
            throw new EsdlException(String.format(
                    "MobilityDemand %s of charge point %s has no profile of charging sessions",
                    mobilityDemand.getName(),
                    chargingStation.getName()
            ));
        }

        var sessions = readChargingSessions(profile, chargingEfficiencyOf(chargingStation));
        var trips = toTrips(sessions, energyConsumptionOfACar_kWhpkm());

        return new J_ActivityTrackerTrips(energyModel.p_timeParameters, trips);
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

    // The EV gets the same default of no losses when the charge point states no efficiency.
    private static double chargingEfficiencyOf(EVChargingStation chargingStation) {
        var chargingEfficiency_fr = ChargePointSettings.read(chargingStation).chargingEfficiency_fr();
        if (chargingEfficiency_fr == null) {
            return 1.0;
        }
        return chargingEfficiency_fr;
    }

    /**
     * A charging session: the vehicle is at its charge point between these two moments,
     * expressed in hours since the start of the simulation year.
     *
     * @param energyIntoBattery_kWh the energy the ESDL states, after the losses of the charge point
     */
    private record ChargingSession(double arrival_h, double departure_h, double energyIntoBattery_kWh) {
    }

    private List<ChargingSession> readChargingSessions(DateTimeProfile profile, double chargingEfficiency_fr) {
        var sessions = new ArrayList<ChargingSession>();

        for (ProfileElement element : profile.getElement()) {
            var arrival_h = hoursSinceStartOfSimulationYear(element.getFrom());
            var departure_h = hoursSinceStartOfSimulationYear(element.getTo());

            // A handful of sessions run over the end of the year and come back stamped with
            // the January of the same year instead of the next one.
            if (departure_h < arrival_h) {
                departure_h += hoursPerYear;
            }

            var energyFromGrid_kWh = element.getValue();
            sessions.add(new ChargingSession(arrival_h, departure_h, energyFromGrid_kWh * chargingEfficiency_fr));
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
                    nextArrival.energyIntoBattery_kWh() / energyConsumption_kWhpkm
            ));
        }

        return trips;
    }

    /**
     * The same figure that the LUX loader would give the vehicle, so that turning energy back
     * into distance here and distance back into energy in the engine cancel out.
     */
    private double energyConsumptionOfACar_kWhpkm() {
        return energyModel.avgc_data.avgEVEnergyConsumptionCar_kWhpkm();
    }

    private double hoursSinceStartOfSimulationYear(java.util.Date timestamp) {
        return DateTimeUtil.getHourOffset(simulationYear, timestamp.toInstant());
    }
}
