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
import energy.lux.engine.EnergyModel;
import energy.lux.engine.energyassets.J_EAEV;
import energy.lux.loader.EnergyAssetCreator;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.managementclasses.assetmanagements.heatingmanagements.I_HeatingManagement;
import energy.lux.engine.energyassets.J_EAConversionGasBurner;
import energy.lux.engine.energyassets.J_EAConversionHeatPump;
import energy.lux.engine.managementclasses.assetmanagements.heatingmanagements.J_HeatingManagementPIcontrol;
import energy.lux.engine.managementclasses.assetmanagements.heatingmanagements.J_HeatingManagementPIcontrolHybridHeatpump;
import energy.lux.engine.optionlists.OL_AmbientTempType;
import energy.lux.engine.optionlists.OL_ChargingAttitude;
import energy.lux.engine.optionlists.OL_GridConnectionHeatingType;
import energy.lux.engine.optionlists.OL_VehicleType;

import java.util.HashSet;
import java.util.Set;

import static energy.lux.esdl.core.loader.SwitchStatus.DONE;

/**
 * Iterate through the network behind EConnection
 * and add the assets to the LUX grid connection
 */
public class GridConnectionAssetIterator extends EsdlSwitch<SwitchStatus> {
    private static final Logger logger = LoggerFactory.getLogger(GridConnectionAssetIterator.class);

    /**
     * Stands in for the thermal power of a HybridHeatPump that the ESDL does not rate, so that a
     * file which omits heatPumpThermalPower does not silently get a heat pump of zero power.
     * Chosen to match what the files that do state it use.
     */
    private static final double assumedHybridHeatPumpThermalPower_kW = 6.0;

    /**
     * The heat output the gas burner of a hybrid is given, in kW.
     * <p>
     * The ESDL rates only the heat pump half of a HybridHeatPump, so nothing in the file says how
     * big the burner is. It carries the peaks the heat pump cannot follow, and the hot water draws
     * in these files reach about 48 kW, so it is rated above that. Deliberately generous rather
     * than realistic: an oversized burner only lifts a ceiling, it never produces more heat than
     * the house asks for, so it costs nothing in energy.
     */
    private static final double hybridGasBurnerHeatCapacity_kW = 50.0;

    /**
     * Converts the thermal rating the ESDL states into the electric capacity the engine wants.
     * <p>
     * ESDL states heatPumpThermalPower, the heat the pump delivers, while J_EAConversionHeatPump
     * is built from the electricity it draws and derives its own COP from an empirical curve that
     * moves with the ambient temperature. There is no single COP to divide by, so this stands in
     * for the design point. It is the divisor Zero_Loader.f_addHeatAsset uses for a hybrid.
     */
    private static final double hybridHeatPumpDesignCOP = 3.0;

    /**
     * A hybrid draws its heat from the outside air, so it has no source asset feeding it, and its
     * efficiency is not reduced below freezing. Both are what f_addHeatAsset assumes.
     */
    private static final double hybridHeatPumpSourceAssetHeatPower_kW = 0.0;

    private static final double hybridHeatPumpBelowZeroEtaReductionFactor = 1.0;

    private static final double initialStateOfChargeOfACar_fr = 1.0;

    private final GridConnection luxGridConnection;

    private final EnergyModel energyModel;

    // Temporary: the LUX loader sizes the heat assets.
    private final EnergyAssetCreator assetCreator = new EnergyAssetCreator();

    private final ElectricityDemandLoader electricityDemandLoader;

    private final MobilityDemandLoader mobilityDemandLoader;

    private final EConnection entryPoint;

    private final ProfilePointerRegistry profilePointerRegistry;

    private final Set<Port> visitedPorts = new HashSet<>();
    private final Set<EnergyAsset> processedAssets = new HashSet<>();

    public GridConnectionAssetIterator(
            GridConnection luxGridConnection,
            EnergyModel energyModel,
            EConnection entryPoint,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        this.luxGridConnection = luxGridConnection;
        this.energyModel = energyModel;
        this.electricityDemandLoader = new ElectricityDemandLoader(energyModel, profilePointerRegistry);
        this.mobilityDemandLoader = new MobilityDemandLoader(energyModel);
        this.profilePointerRegistry = profilePointerRegistry;
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
            HomeBatteryLoader.loadBattery(battery, luxGridConnection, energyModel);
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
            PVLoader.loadPVInstallation(pvInstallation, luxGridConnection, energyModel, profilePointerRegistry);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHeatPump(HeatPump heatPump) {
        if (this.processedAssets.add(heatPump)) {
            var maxThermalPowerKw = heatPump.getPower() * 0.001;
            assetCreator.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP, maxThermalPowerKw, energyModel, energyModel.avgc_data);
            I_HeatingManagement heatingManagement = new J_HeatingManagementPIcontrol(luxGridConnection, energyModel.p_timeParameters, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP);
            luxGridConnection.f_setHeatingManagement(heatingManagement);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHybridHeatPump(HybridHeatPump hybridHeatPump) {
        if (this.processedAssets.add(hybridHeatPump)) {
            addHybridHeatingAssets(readHybridHeatPumpThermalPower_kW(hybridHeatPump));
            I_HeatingManagement heatingManagement = new J_HeatingManagementPIcontrolHybridHeatpump(luxGridConnection, energyModel.p_timeParameters, OL_GridConnectionHeatingType.HYBRID_HEATPUMP);
            luxGridConnection.f_setHeatingManagement(heatingManagement);
        }
        return DONE;
    }

    /**
     * Build the heat pump and the gas burner of a hybrid directly, instead of through
     * Zero_Loader.f_addHeatAsset.
     * <p>
     * That method derives both halves from a single number: the heat pump gets a third of it and
     * the burner all of it. With the 6 kW these files state, the burner ends up at 6 kW too, so
     * the pair tops out near 11 kW of heat while the hot water draws reach 48 kW. The house then
     * cannot meet its demand and the engine reports a heat unbalance in every timestep it falls
     * short.
     * <p>
     * A hybrid house cannot fall back on a hot water buffer either, because
     * J_HeatingManagementPIcontrolHybridHeatpump only accepts one alongside solar thermal, which
     * these houses do not have. That is deliberate in the engine, so the burner has to carry the
     * peaks by itself and is rated for them here.
     * <p>
     * Everything besides the two capacities is what f_addHeatAsset would have used.
     */
    private void addHybridHeatingAssets(double heatPumpThermalPower_kW) {
        var averagesData = energyModel.avgc_data;

        var heatPumpElectricCapacity_kW = Math.max(
                averagesData.minHeatpumpElectricCapacity_kW(),
                heatPumpThermalPower_kW / hybridHeatPumpDesignCOP
        );

        // The constructor registers the heat pump with the grid connection, which also puts it in
        // EnergyModel.c_ambientDependentAssets, so its COP follows the outside air by itself.
        new J_EAConversionHeatPump(
                luxGridConnection,
                heatPumpElectricCapacity_kW,
                averagesData.avgEfficiencyHeatpump_fr(),
                energyModel.p_timeParameters,
                averagesData.avgOutputTemperatureHybridHeatpump_degC(),
                energyModel.pp_ambientTemperature_degC.getCurrentValue(),
                hybridHeatPumpSourceAssetHeatPower_kW,
                hybridHeatPumpBelowZeroEtaReductionFactor,
                OL_AmbientTempType.AMBIENT_AIR
        );

        // The burner registers itself the same way.
        new J_EAConversionGasBurner(
                luxGridConnection,
                Math.max(averagesData.minGasBurnerOutputCapacity_kW(), hybridGasBurnerHeatCapacity_kW),
                averagesData.avgEfficiencyGasBurner_fr(),
                energyModel.p_timeParameters,
                averagesData.avgOutputTemperatureGasBurner_degC()
        );
    }

    /**
     * @return the thermal power the ESDL states, or {@link #assumedHybridHeatPumpThermalPower_kW}
     *         when it states none.
     */
    private static double readHybridHeatPumpThermalPower_kW(HybridHeatPump hybridHeatPump) {
        var statedThermalPower_kW = hybridHeatPump.getHeatPumpThermalPower() * 0.001;
        if (statedThermalPower_kW > 0) {
            return statedThermalPower_kW;
        }

        logger.warn(
                "Hybrid heat pump {} states no thermal power, assuming {} kW so that its house"
                        + " can meet its heat demand. Its electricity use is a placeholder.",
                hybridHeatPump.getName(),
                assumedHybridHeatPumpThermalPower_kW
        );
        return assumedHybridHeatPumpThermalPower_kW;
    }

    /**
     * The charging sessions of the ESDL replace the weekly trip patterns that LUX would
     * otherwise read from its own CSV. When the ESDL states none, the annual distance derived
     * from the full load hours of the charge point still steers those default patterns.
     */
    @Override
    public SwitchStatus caseEVChargingStation(EVChargingStation evChargingStation) {
        if (this.processedAssets.add(evChargingStation)) {
            var maxChargingPower_W = evChargingStation.getPower();
            var maxChargingPowerKw = maxChargingPower_W * 0.001;
            var tripTracker = mobilityDemandLoader.readTripTracker(evChargingStation);

            double consumedEnergy_kWh = evChargingStation.getFullLoadHours() * maxChargingPowerKw;
            double traveledDistance_km = consumedEnergy_kWh / energyModel.avgc_data.avgEVEnergyConsumptionCar_kWhpkm();

            var averagesData = energyModel.avgc_data;
            var electricVehicle = new J_EAEV(
                    luxGridConnection,
                    maxChargingPowerKw,
                    averagesData.avgEVStorageCar_kWh(),
                    initialStateOfChargeOfACar_fr,
                    energyModel.p_timeParameters,
                    averagesData.avgEVEnergyConsumptionCar_kWhpkm(),
                    1.0,
                    OL_VehicleType.CAR,
                    tripTracker
            );
            if (tripTracker == null) {
                electricVehicle.getTripTracker().setAnnualDistance_km(traveledDistance_km);
            }

            // Houses that the aggregator manages get their management replaced afterwards.
            if (luxGridConnection.f_getChargingManagement() == null) {
                luxGridConnection.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
            }
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
