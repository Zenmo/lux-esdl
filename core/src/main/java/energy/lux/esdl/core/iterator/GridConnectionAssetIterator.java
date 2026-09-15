package energy.lux.esdl.core.iterator;

import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.Util;
import energy.lux.esdl.core.loader.ElectricityDemandLoader;
import energy.lux.esdl.core.loader.HomeBatteryLoader;
import energy.lux.esdl.core.loader.MobilityDemandLoader;
import energy.lux.esdl.core.loader.PVLoader;
import energy.lux.esdl.core.loader.SwitchStatus;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import esdl.*;
import esdl.util.EsdlSwitch;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.*;
import zerointerfaceloader.Zero_Loader;

import java.util.HashSet;
import java.util.Set;

import static energy.lux.esdl.core.loader.SwitchStatus.DONE;

/**
 * Iterate through the network behind EConnection
 * and add the assets to the LUX grid connection
 */
public class GridConnectionAssetIterator extends EsdlSwitch<SwitchStatus> {
    private static final Logger logger = LoggerFactory.getLogger(GridConnectionAssetIterator.class);

    private final GridConnection luxGridConnection;

    private final Zero_Loader luxLoader;
    private final EnergyModel energyModel;

    private final ElectricityDemandLoader electricityDemandLoader;

    private final MobilityDemandLoader mobilityDemandLoader;

    private final EConnection entryPoint;

    private final Set<Port> visitedPorts = new HashSet<>();
    private final Set<EnergyAsset> processedAssets = new HashSet<>();

    public GridConnectionAssetIterator(
            GridConnection luxGridConnection,
            Zero_Loader luxLoader,
            EConnection entryPoint,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        this.luxGridConnection = luxGridConnection;
        this.luxLoader = luxLoader;
        this.energyModel = luxLoader.energyModel;
        this.electricityDemandLoader = new ElectricityDemandLoader(luxLoader, profilePointerRegistry);
        this.mobilityDemandLoader = new MobilityDemandLoader(luxLoader);
        // prevent exiting the grid connection while searching through the cables
        this.entryPoint = entryPoint;
    }

    @Override
    public SwitchStatus defaultCase(EObject object) {
        throw new RuntimeException("Unexpected asset type " + object.toString());
    }

    @Override
    public SwitchStatus caseEnergyAsset(EnergyAsset energyAsset) {
        throw new NotImplemented("Not implemented loading Energy Asset " + Util.printItem(energyAsset));
    }

    @Override
    public SwitchStatus caseEConnection(EConnection eConnection) {
        if (eConnection != entryPoint) {
            throw new RuntimeException("Found a grid connection within a grid connection: " + Util.printItem(eConnection));
        }
        return DONE;
    }

    public SwitchStatus caseBattery(Battery battery) {
        if (this.processedAssets.add(battery)) {
            HomeBatteryLoader.loadBattery(battery, luxGridConnection, luxLoader);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseInPort(InPort inPort) {
        if (this.visitedPorts.add(inPort)) {
            doSwitch(inPort.getEnergyasset());
            for (var outPort: inPort.getConnectedTo()) {
                doSwitch(outPort);
            }
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseOutPort(OutPort outPort) {
        if (this.visitedPorts.add(outPort)) {
            doSwitch(outPort.getEnergyasset());
            for (var inPort: outPort.getConnectedTo()) {
                doSwitch(inPort);
            }
        }
        return DONE;
    }

    /**
     * The phase grids are the only route from a house to its demand assets, because the ESDL
     * decorator puts those in the area and shares each one between three or four houses.
     * <p>
     * Assets that do sit in a building are skipped: they either belong to this house, in which
     * case the containment walk already offers them to this switch, or they belong to one of
     * the other houses sharing the demand, which must not end up on this grid connection.
     */
    @Override
    public SwitchStatus caseElectricityNetwork(ElectricityNetwork electricityNetwork) {
        for (Port port : electricityNetwork.getPort()) {
            if (!(port instanceof OutPort outPort)) {
                continue;
            }
            for (InPort connectedInPort : outPort.getConnectedTo()) {
                var connectedAsset = connectedInPort.getEnergyasset();
                if (connectedAsset.getContainingBuilding() == null) {
                    this.doSwitch(connectedAsset);
                }
            }
        }
        return DONE;
    }

    /**
     * Heat demand is not loaded yet: space heating becomes a yearly total for the RC model and
     * hot water becomes a profile asset, both still to be implemented.
     * <p>
     * The older ESDL files carry HeatingDemand assets without any profile, so only warn when
     * data is actually being dropped.
     */
    @Override
    public SwitchStatus caseHeatingDemand(HeatingDemand heatingDemand) {
        if (this.processedAssets.add(heatingDemand) && hasProfile(heatingDemand)) {
            logger.warn(
                    "Dropping the profile of {} HeatingDemand {} on grid connection {}, loading it is not implemented",
                    heatingDemand.getType(),
                    heatingDemand.getName(),
                    luxGridConnection.p_gridConnectionID
            );
        }
        return DONE;
    }

    private static boolean hasProfile(EnergyAsset asset) {
        for (Port port : asset.getPort()) {
            if (!port.getProfile().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public SwitchStatus casePVInstallation(PVInstallation pvInstallation) {
        if (this.processedAssets.add(pvInstallation)) {
            PVLoader.loadPVInstallation(pvInstallation, luxGridConnection, luxLoader);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHeatPump(HeatPump heatPump) {
        if (this.processedAssets.add(heatPump)) {
            var maxThermalPowerKw = heatPump.getPower() * 0.001;
            var heatingPreferences = luxLoader.f_getHouseHeatingPreferences();
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, maxThermalPowerKw, heatingPreferences);
            I_HeatingManagement heatingManagement = new J_HeatingManagementPIcontrol(luxGridConnection, energyModel.p_timeParameters, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP);
            luxGridConnection.f_setHeatingManagement(heatingManagement);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHybridHeatPump(HybridHeatPump hybridHeatPump) {
        if (this.processedAssets.add(hybridHeatPump)) {
            var maxThermalPowerKw = hybridHeatPump.getHeatPumpThermalPower() * 0.001;
            var heatingPreferences = luxLoader.f_getHouseHeatingPreferences();
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.HYBRID_HEATPUMP, maxThermalPowerKw, heatingPreferences);
            I_HeatingManagement heatingManagement = new J_HeatingManagementPIcontrolHybridHeatpump(luxGridConnection, energyModel.p_timeParameters, OL_GridConnectionHeatingType.HYBRID_HEATPUMP);
            luxGridConnection.f_setHeatingManagement(heatingManagement);
        }
        return DONE;
    }

    /**
     * The charging sessions of the ESDL replace the weekly trip patterns that LUX would
     * otherwise read from its own CSV. When the ESDL states none, the annual distance derived
     * from the full load hours of the charge point still steers those default patterns.
     */
    @Override
    public SwitchStatus caseEVChargingStation(EVChargingStation evChargingStation) {
        if (this.processedAssets.add(evChargingStation)) {
            // The congestion scenario files state this in kW, an 11 kW charger is power="11.0".
            // The older files state watts, so those are now a thousand times too large.
            // TODO: decide per file, or get the unit into the ESDL.
            var maxChargingPowerKw = evChargingStation.getPower();
            var tripTracker = mobilityDemandLoader.readTripTracker(evChargingStation);

            double consumedEnergy_kWh = evChargingStation.getFullLoadHours() * maxChargingPowerKw;
            double traveledDistance_km = consumedEnergy_kWh / luxLoader.avgc_data.p_avgEVEnergyConsumptionCar_kWhpkm;

            luxLoader.f_addElectricVehicle(
                    luxGridConnection,
                    OL_EnergyAssetType.ELECTRIC_VEHICLE,
                    false,
                    traveledDistance_km,
                    maxChargingPowerKw,
                    OL_ChargingAttitude.SIMPLE,
                    tripTracker
            );
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseElectricityDemand(ElectricityDemand demand) {
        if (!this.processedAssets.add(demand)) {
            return DONE;
        }

        this.electricityDemandLoader.loadElectricityDemand(demand, luxGridConnection);
        return DONE;
    }
}
