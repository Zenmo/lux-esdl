package energy.lux.esdl.core.iterator;

import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.util.Util;
import energy.lux.esdl.core.loader.BuildingThermalLoader;
import energy.lux.esdl.core.loader.ChargePointSettings;
import energy.lux.esdl.core.loader.ElectricityDemandLoader;
import energy.lux.esdl.core.loader.GridConnectionLoader;
import energy.lux.esdl.core.loader.HeatingChain;
import energy.lux.esdl.core.loader.HeatingChainFinder;
import energy.lux.esdl.core.loader.HomeBatteryLoader;
import energy.lux.esdl.core.loader.MobilityDemandLoader;
import energy.lux.esdl.core.loader.PVLoader;
import energy.lux.esdl.core.loader.SwitchStatus;
import energy.lux.esdl.core.loader.WaterBufferLoader;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import esdl.*;
import esdl.util.EsdlSwitch;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import energy.lux.engine.EnergyModel;
import energy.lux.engine.energyassets.J_EAEV;
import energy.lux.engine.energyassets.J_EAProfile;
import energy.lux.engine.energyassets.J_EAStorageHeat;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.energyassets.J_EAConversionGasBurner;
import energy.lux.engine.energyassets.J_EAConversionHeatPump;
import energy.lux.engine.managementclasses.assetmanagements.heatingmanagements.J_HeatingManagementISIE;
import energy.lux.engine.optionlists.OL_AmbientTempType;
import energy.lux.engine.optionlists.OL_ChargingAttitude;
import energy.lux.engine.optionlists.OL_GridConnectionHeatingType;
import energy.lux.engine.optionlists.OL_VehicleType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
     * The heat output the gas burner of a hybrid is given, in kW, when the ESDL states no
     * gasHeaterThermalPower.
     * <p>
     * The burner carries the hot water draws, which in these files reach about 48 kW, so it is
     * rated above that. Deliberately generous rather than realistic: an oversized burner only
     * lifts a ceiling, it never produces more heat than the house asks for, so it costs nothing
     * in energy.
     */
    private static final double hybridGasBurnerHeatCapacity_kW = 50.0;

    /**
     * Converts the thermal rating the ESDL states into the electric capacity the engine wants.
     * <p>
     * ESDL states heatPumpThermalPower, the heat the pump delivers, while J_EAConversionHeatPump
     * is built from the electricity it draws and derives its own COP from an empirical curve that
     * moves with the ambient temperature. The ESDL gives a hybrid no COP to divide by, so this
     * stands in for the design point. It is the divisor Zero_Loader.f_addHeatAsset uses for a hybrid.
     */
    private static final double hybridHeatPumpDesignCOP = 3.0;

    /**
     * The heat pumps draw their heat from the outside air, so they have no source asset feeding
     * them, and their efficiency is not reduced below freezing. Both are what f_addHeatAsset assumes.
     */
    private static final double heatPumpSourceAssetHeatPower_kW = 0.0;

    private static final double heatPumpBelowZeroEtaReductionFactor = 1.0;

    // ISIE assumes an EV leaves every charging session at 80%. The ISIE aggregator plans every departure to that and
    // also has to bring the EV back to it at the end of the run, so its EVs start at the same 80%.
    private static final double initialStateOfChargeOfAManagedCar_fr = 0.8;

    // Without a dynamic contract the house charges until the battery is full, so its EV starts full. Otherwise its
    // first session would also charge the 20% up to full, which no trip in the ESDL accounts for.
    private static final double initialStateOfChargeOfAnUnmanagedCar_fr = 1.0;

    private final GridConnection luxGridConnection;

    private final EnergyModel energyModel;

    private final BuildingThermalLoader buildingThermalLoader;

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
        this.buildingThermalLoader = new BuildingThermalLoader(energyModel, profilePointerRegistry);
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
     * A heat demand is loaded by the heat pump that feeds it, see {@link #loadHeatPumpHeating}.
     * One that no heat pump feeds is not loaded.
     * <p>
     * The older ESDL files carry HeatingDemand assets without any profile, so only warn when
     * data is actually being dropped.
     */
    @Override
    public SwitchStatus caseHeatingDemand(HeatingDemand heatingDemand) {
        if (this.processedAssets.add(heatingDemand)
                && hasProfile(heatingDemand)
                && !HeatingChainFinder.isReachedByHeatPump(heatingDemand)) {
            logger.warn(
                    "Dropping the profile of {} HeatingDemand {} on grid connection {}: no heat pump feeds it,"
                            + " and loading it without one is not implemented",
                    heatingDemand.getType(),
                    heatingDemand.getName(),
                    luxGridConnection.p_gridConnectionID
            );
        }
        return DONE;
    }

    /**
     * Built by the heat pump that fills it, see {@link #loadHeatPumpHeating}, because the
     * buffer is sized on that heat pump.
     */
    @Override
    public SwitchStatus caseWaterBuffer(WaterBuffer waterBuffer) {
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
            var chains = HeatingChainFinder.findHeatPumpChains(heatPump);
            var luxHeatPump = addHeatPump(
                    readHeatPumpElectricCapacity_kW(heatPump),
                    energyModel.avgc_data.avgOutputTemperatureElectricHeatpump_degC()
            );
            loadHeatPumpHeating(heatPump, chains, luxHeatPump, null, OL_GridConnectionHeatingType.ELECTRIC_HEATPUMP);
        }
        return DONE;
    }

    @Override
    public SwitchStatus caseHybridHeatPump(HybridHeatPump hybridHeatPump) {
        if (this.processedAssets.add(hybridHeatPump)) {
            var chains = HeatingChainFinder.findHybridHeatPumpChains(hybridHeatPump);
            var luxHeatPump = addHeatPump(
                    hybridHeatPumpElectricCapacity_kW(readHybridHeatPumpThermalPower_kW(hybridHeatPump)),
                    energyModel.avgc_data.avgOutputTemperatureHybridHeatpump_degC()
            );
            var gasBurner = addGasBurner(readGasBurnerHeatCapacity_kW(hybridHeatPump));
            loadHeatPumpHeating(hybridHeatPump, chains, luxHeatPump, gasBurner, OL_GridConnectionHeatingType.HYBRID_HEATPUMP);
        }
        return DONE;
    }

    /**
     * Build the heat stores and the demand profiles behind the heat pump, and hand them to the
     * heating management by role: the grid connection holds three heat stores but knows only one.
     * <p>
     * A house without a dynamic contract gets the same management, which the aggregator does not
     * plan. With no setpoints it heats just in time.
     */
    private void loadHeatPumpHeating(
            EnergyAsset esdlHeatPump,
            List<HeatingChain> chains,
            J_EAConversionHeatPump heatPump,
            J_EAConversionGasBurner gasBurner,
            OL_GridConnectionHeatingType heatingType
    ) {
        var highestHeatOutput_kW = highestHeatOutput_kW(heatPump);
        var hotWaterChain = HeatingChainFinder.findChainOfType(chains, HeatDemandTypeEnum.HOT_TAPWATER);
        var spaceHeatingChain = HeatingChainFinder.findChainOfType(chains, HeatDemandTypeEnum.SPACE_HEATING);

        var hotWaterDemand = addHotWaterDemand(esdlHeatPump, hotWaterChain);
        var spaceHeatingDemand = buildingThermalLoader.addSpaceHeatingDemand(spaceHeatingChain.demand(), luxGridConnection);
        var spaceHeatingCapacityHeat_kW = storeCapacityHeat_kW(highestHeatOutput_kW, spaceHeatingDemand);

        var heatingManagement = new J_HeatingManagementISIE(
                luxGridConnection,
                energyModel.p_timeParameters,
                heatingType,
                heatPump,
                gasBurner,
                addHotWaterBuffer(hotWaterChain, hotWaterDemand, highestHeatOutput_kW),
                WaterBufferLoader.loadWaterBuffer(spaceHeatingChain.buffer(), luxGridConnection, energyModel, spaceHeatingCapacityHeat_kW),
                buildingThermalLoader.addHeatBattery(
                        findBuilding(esdlHeatPump),
                        spaceHeatingChain.demand(),
                        luxGridConnection,
                        spaceHeatingCapacityHeat_kW
                ),
                hotWaterDemand,
                spaceHeatingDemand
        );
        heatingManagement.setPlannedByAggregator(GridConnectionLoader.hasDynamicContract(entryPoint));
        luxGridConnection.f_setHeatingManagement(heatingManagement);
    }

    /**
     * @return null when the heat pump feeds no hot water demand, which only a hybrid may do
     */
    private J_EAProfile addHotWaterDemand(EnergyAsset esdlHeatPump, HeatingChain hotWaterChain) {
        if (hotWaterChain == null) {
            logger.warn(
                    "Heat pump {} feeds no hot water demand, so grid connection {} uses no hot water",
                    Util.printItem(esdlHeatPump),
                    luxGridConnection.p_gridConnectionID
            );
            return null;
        }
        return buildingThermalLoader.addHotWaterDemand(hotWaterChain.demand(), luxGridConnection);
    }

    /**
     * @return null for a hybrid, whose gas burner heats the hot water as it is drawn
     */
    private J_EAStorageHeat addHotWaterBuffer(HeatingChain hotWaterChain, J_EAProfile hotWaterDemand, double highestHeatOutput_kW) {
        if (hotWaterChain == null || hotWaterChain.buffer() == null) {
            return null;
        }
        return WaterBufferLoader.loadWaterBuffer(
                hotWaterChain.buffer(),
                luxGridConnection,
                energyModel,
                storeCapacityHeat_kW(highestHeatOutput_kW, hotWaterDemand)
        );
    }

    /**
     * LUX caps the flow in or out of a store at its capacityHeat_kW. A store must take what the
     * heat pump makes on its warmest hour and give what its demand draws at the peak, or the heat
     * of the grid connection does not balance. The rated thermal power of the ESDL is not enough:
     * it holds at the design COP only.
     */
    private static double storeCapacityHeat_kW(double highestHeatOutput_kW, J_EAProfile demand) {
        return Math.max(highestHeatOutput_kW, demand.getPeakConsumptionPower_kW());
    }

    /**
     * @return the heat the heat pump makes at the COP of the warmest hour of the year
     */
    private double highestHeatOutput_kW(J_EAConversionHeatPump heatPump) {
        var warmestAmbientTemperature_degC = Arrays.stream(energyModel.pp_ambientTemperature_degC.getAllValues())
                .max()
                .orElseThrow();
        return heatPump.getInputCapacity_kW()
                * heatPump.calculateCOP(heatPump.getOutputTemperature_degC(), warmestAmbientTemperature_degC);
    }

    private static GenericBuilding findBuilding(EnergyAsset esdlHeatPump) {
        var building = esdlHeatPump.getContainingBuilding();
        if (building instanceof GenericBuilding genericBuilding) {
            return genericBuilding;
        }
        throw new NotImplemented(
                "Heat pump " + Util.printItem(esdlHeatPump) + " is not in a GenericBuilding but in " + building
        );
    }

    /**
     * The ESDL states the heat the heat pump delivers as power, the engine wants the electricity
     * it draws. The ESDL COP is the design point; the engine derives its own COP per timestep
     * from the outside air.
     */
    private static double readHeatPumpElectricCapacity_kW(HeatPump heatPump) {
        Util.throwIfZero(heatPump.getPower(), heatPump, "power");
        Util.throwIfZero(heatPump.getCOP(), heatPump, "COP");
        return heatPump.getPower() * 0.001 / heatPump.getCOP();
    }

    /**
     * The ESDL gives no COP for a hybrid, so the thermal power is divided by the design COP.
     */
    private double hybridHeatPumpElectricCapacity_kW(double heatPumpThermalPower_kW) {
        return Math.max(
                energyModel.avgc_data.minHeatpumpElectricCapacity_kW(),
                heatPumpThermalPower_kW / hybridHeatPumpDesignCOP
        );
    }

    /**
     * Built directly instead of through EnergyAssetCreator.f_addHeatAsset, which takes the
     * thermal power the ESDL states for the electric capacity. Everything besides the capacity
     * is what f_addHeatAsset would have used.
     */
    private J_EAConversionHeatPump addHeatPump(double electricCapacity_kW, double outputTemperature_degC) {
        var averagesData = energyModel.avgc_data;
        // The constructor registers the heat pump with the grid connection, which also puts it in
        // EnergyModel.c_ambientDependentAssets, so its COP follows the outside air by itself.
        return new J_EAConversionHeatPump(
                luxGridConnection,
                electricCapacity_kW,
                averagesData.avgEfficiencyHeatpump_fr(),
                energyModel.p_timeParameters,
                outputTemperature_degC,
                energyModel.pp_ambientTemperature_degC.getCurrentValue(),
                heatPumpSourceAssetHeatPower_kW,
                heatPumpBelowZeroEtaReductionFactor,
                OL_AmbientTempType.AMBIENT_AIR
        );
    }

    /**
     * Built directly rather than through f_addHeatAsset, which would derive the burner of a
     * hybrid from the thermal power of its heat pump.
     */
    private J_EAConversionGasBurner addGasBurner(double heatCapacity_kW) {
        var averagesData = energyModel.avgc_data;
        // The burner registers itself with the grid connection.
        return new J_EAConversionGasBurner(
                luxGridConnection,
                heatCapacity_kW,
                averagesData.avgEfficiencyGasBurner_fr(),
                energyModel.p_timeParameters,
                averagesData.avgOutputTemperatureGasBurner_degC()
        );
    }

    /**
     * @return the thermal power of the gas heater the ESDL states, or
     *         {@link #hybridGasBurnerHeatCapacity_kW} when it states none.
     */
    private double readGasBurnerHeatCapacity_kW(HybridHeatPump hybridHeatPump) {
        var statedThermalPower_kW = hybridHeatPump.getGasHeaterThermalPower() * 0.001;
        if (statedThermalPower_kW > 0) {
            return statedThermalPower_kW;
        }
        return Math.max(energyModel.avgc_data.minGasBurnerOutputCapacity_kW(), hybridGasBurnerHeatCapacity_kW);
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
     * otherwise read from its own CSV.
     */
    @Override
    public SwitchStatus caseEVChargingStation(EVChargingStation evChargingStation) {
        if (this.processedAssets.add(evChargingStation)) {
            var maxChargingPower_W = evChargingStation.getPower();
            var maxChargingPowerKw = maxChargingPower_W * 0.001;
            var tripTracker = mobilityDemandLoader.readTripTracker(evChargingStation);

            var averagesData = energyModel.avgc_data;
            var electricVehicle = new J_EAEV(
                    luxGridConnection,
                    maxChargingPowerKw,
                    readBatteryCapacity_kWh(evChargingStation),
                    initialStateOfChargeOfACar_fr(),
                    energyModel.p_timeParameters,
                    averagesData.avgEVEnergyConsumptionCar_kWhpkm(),
                    1.0,
                    OL_VehicleType.CAR,
                    tripTracker
            );
            ChargePointSettings.read(evChargingStation).setChargingEfficienciesOf(electricVehicle);

            // Houses that the aggregator manages get their management replaced afterwards.
            if (luxGridConnection.f_getChargingManagement() == null) {
                luxGridConnection.f_addChargingManagement(OL_ChargingAttitude.SIMPLE);
            }
        }
        return DONE;
    }

    // A dynamic contract is what lets the aggregator take over the charging, see GridConnectionLoader.
    private double initialStateOfChargeOfACar_fr() {
        if (GridConnectionLoader.hasDynamicContract(entryPoint)) {
            return initialStateOfChargeOfAManagedCar_fr;
        }
        return initialStateOfChargeOfAnUnmanagedCar_fr;
    }

    /**
     * @return the battery the description of the charge point states, or the average car battery
     *         of LUX when it states none.
     */
    private double readBatteryCapacity_kWh(EVChargingStation evChargingStation) {
        var statedCapacity_kWh = ChargePointSettings.read(evChargingStation).batteryCapacity_kWh();
        if (statedCapacity_kWh == null) {
            return energyModel.avgc_data.avgEVStorageCar_kWh();
        }
        return statedCapacity_kWh;
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
