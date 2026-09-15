package energy.lux.esdl.core.loader;

import energy.lux.esdl.core.iterator.GridConnectionAssetIterator;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import esdl.Asset;
import esdl.EConnection;
import esdl.OutPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;
import zero_engine.I_ChargingManagement;
import zero_engine.I_BatteryManagement;
import zero_engine.J_ChargingManagementExternalSetpoint;
import zero_engine.J_BatteryManagementExternalSetpoint;
import zero_engine.J_EAConversionHeatPump;
import zero_engine.J_EAProfile;
import zero_engine.J_EAStorageHeat;
import zero_engine.OL_AmbientTempType;
import zero_engine.J_HeatingPreferences;
import zero_engine.OL_EnergyAssetType;
import zero_engine.OL_GridConnectionHeatingType;
import zero_engine.ConnectionOwner;
import zerointerfaceloader.Zero_Loader;


public class GridConnectionLoader {
    private static final Logger logger = LoggerFactory.getLogger(GridConnectionLoader.class);

    /**
     * Margin on top of the sized buffer. The sizing uses the heat pump output as it stands at
     * load time, but that output is its input capacity times a COP that falls as the outside
     * air gets colder, and space heating competes for the same output. The sizing barely moves
     * with it, since the worst draw lasts half an hour and so a kW less output costs half a kWh
     * of buffer, but the margin keeps a cold winter draw off the RuntimeException that
     * manageHotWaterHeatBuffer throws when the buffer runs dry.
     */
    private static final double bufferSafetyFactor = 1.25;

    private static final double joulesPerKilowattHour = 3.6e6;

    public static GridConnection loadGridConnection(
            EConnection eConnection,
            Zero_Loader luxLoader,
            GridNode parentGridNode,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        var gridConnection = instantiateGridConnection(eConnection, luxLoader, parentGridNode);
        loadBuilding(eConnection, luxLoader, gridConnection, profilePointerRegistry);

        var gcSwitch = new GridConnectionAssetIterator(gridConnection, luxLoader, eConnection, profilePointerRegistry);
        loadAssetsOfGridConnection(eConnection, gcSwitch);
        checkHeatingAsset(eConnection, luxLoader, gridConnection);
        addHotWaterBuffer(luxLoader, gridConnection);
        addCustomAssetManagements(eConnection, luxLoader, gridConnection);
        return gridConnection;
    }

    /**
     * The assets of a house are the assets its building contains.
     * <p>
     * Following the ports out of the EConnection would be the more natural way to find them,
     * but the congestion scenario files leave every EConnection OutPort unconnected, so there
     * is no path from a grid connection to its own phase grids. That is deliberate on the side
     * that produces the files, so discovery is based on containment instead.
     */
    private static void loadAssetsOfGridConnection(EConnection eConnection, GridConnectionAssetIterator gcSwitch) {
        var building = eConnection.getContainingBuilding();
        if (building == null) {
            logger.warn(
                    "Grid connection {} is not contained in a building, falling back to following its ports",
                    eConnection.getId()
            );
            loadAssetsBehindPorts(eConnection, gcSwitch);
            return;
        }

        for (Asset asset : building.getAsset()) {
            gcSwitch.doSwitch(asset);
        }
    }

    private static void loadAssetsBehindPorts(EConnection eConnection, GridConnectionAssetIterator gcSwitch) {
        for (var port : eConnection.getPort()) {
            // skip InPort because that leaves the grid connection
            if (port instanceof OutPort outPort) {
                gcSwitch.doSwitch(outPort);
            }
        }
    }

    private static GridConnection instantiateGridConnection(
            EConnection eConnection, Zero_Loader luxLoader, GridNode parentGridNode
    ) {
        EnergyModel energyModel = luxLoader.energyModel;
        var gridConnection = energyModel.add_pop_gridConnections();
        gridConnection.p_gridConnectionID = eConnection.getId();
        gridConnection.p_parentNodeElectricID = parentGridNode.p_gridNodeID;
        ConnectionOwner owner = energyModel.add_pop_connectionOwners();
        String ownerID = gridConnection.p_gridConnectionID + " owner";
        gridConnection.p_ownerID = ownerID;
        owner.p_actorID = ownerID;
        owner.p_detailedCompany = true;
        return gridConnection;
    }

    private static void loadBuilding(
            EConnection eConnection,
            Zero_Loader luxLoader,
            GridConnection luxGridConnection,
            ProfilePointerRegistry profilePointerRegistry
    ) {
        var building = eConnection.getContainingBuilding();
        if (building != null) {
            new BuildingThermalLoader(luxLoader, profilePointerRegistry)
                    .loadBuilding(building, luxGridConnection);
        }
        // It seems valid to have a grid connection without a building, no warning necessary.
    }

    private static void addCustomAssetManagements(EConnection eConnection, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        // All houses have already gotten heating management PI Control
        // For other assets houses with a dynamic contract have their assets managed by the aggregator on the parent GridNode
        // Houses without a dynamic contract have the default SIMPLE charging & SELF CONSUMPTION battery algorithms.
        EnergyModel energyModel = luxLoader.energyModel;
        if (eConnection.getDescription().contains("dynamic_contract")) { // TODO: Make this check more robust?
            I_ChargingManagement chargingManagement = new J_ChargingManagementExternalSetpoint(luxGridConnection, energyModel.p_timeParameters);
            luxGridConnection.f_setChargingManagement(chargingManagement);
            I_BatteryManagement batteryManagement = new J_BatteryManagementExternalSetpoint(luxGridConnection, energyModel.p_timeParameters);
            luxGridConnection.f_setBatteryManagement(batteryManagement);
        }
    }

    /**
     * Give the house a hot water cylinder.
     * <p>
     * The ESDL states no buffer, and without one J_HeatingManagementPIcontrol has to meet every
     * tap draw from the heat pump in the timestep it falls in. The draws are far peakier than
     * any domestic heat source: Home102_1 asks 39 kW of a 2 kW heat pump, so the balance comes
     * up short and the run pauses. A real house of that kind has a cylinder, which is what
     * p_heatBuffer models, and the PI control already knows how to charge and discharge one.
     * <p>
     * Only houses with an electric heat pump get a buffer. They are the ones that get
     * J_HeatingManagementPIcontrol from {@link GridConnectionAssetIterator}, and that is the
     * only management here proven to drive a buffer. Houses that fell back to a gas burner keep
     * the management f_addHeatAsset chose for them and are left alone.
     */
    private static void addHotWaterBuffer(Zero_Loader luxLoader, GridConnection luxGridConnection) {
        var hotWaterAsset = luxGridConnection.p_DHWAsset;
        if (hotWaterAsset == null) {
            // The PI control refuses a buffer that has no hot water demand to hold water for.
            return;
        }

        if (luxGridConnection.c_heatingAssets.size() != 1
                || !(luxGridConnection.c_heatingAssets.get(0) instanceof J_EAConversionHeatPump heatPump)) {
            return;
        }

        var storedEnergy_kWh = shortfallAgainstHeatingPower_kWh(hotWaterAsset, heatPump.getOutputCapacity_kW());
        if (storedEnergy_kWh <= 0) {
            // The heat pump keeps up with every draw on its own, so a buffer would do nothing.
            return;
        }

        var capacity_kWh = storedEnergy_kWh * bufferSafetyFactor;
        // The buffer carries the whole draw whenever the heat pump is already at its output, so
        // rate it for the peak. f_updateFlexAssetFlows takes the flow as a fraction of this.
        var power_kW = hotWaterAsset.getPeakConsumptionPower_kW();

        createHotWaterBuffer(luxLoader, luxGridConnection, power_kW, capacity_kWh);

        logger.debug(
                "Hot water buffer of {} kWh at {} kW for grid connection {}, heat pump delivers {} kW",
                capacity_kWh, power_kW, luxGridConnection.p_gridConnectionID, heatPump.getOutputCapacity_kW()
        );
    }

    /**
     * The buffer starts at its maximum temperature, so all of the capacity it is sized for is
     * there from the first timestep. f_addStorage would have started it half way up its
     * temperature band, which costs twice the tank for the same usable energy, so this builds
     * the asset directly rather than going through the loader. The two are otherwise the same:
     * f_addStorage adds no management to a heat buffer, and registering the asset with the grid
     * connection is what the constructor does anyway.
     * <p>
     * The initial temperature is also the one storeStatesAndReset returns to, so a rapid run
     * starts from a full buffer as well.
     */
    private static void createHotWaterBuffer(
            Zero_Loader luxLoader,
            GridConnection luxGridConnection,
            double power_kW,
            double capacity_kWh
    ) {
        var averagesData = luxLoader.energyModel.avgc_data;
        var minTemperature_degC = averagesData.p_avgMinHeatBufferTemperature_degC;
        var maxTemperature_degC = averagesData.p_avgMaxHeatBufferTemperature_degC;

        // No losses yet, the same as f_addStorage: the loss factor of a cylinder depends on
        // where it stands, which the ESDL does not say.
        var lossFactor_WpK = 0.0;
        var heatCapacity_JpK = capacity_kWh * joulesPerKilowattHour / (maxTemperature_degC - minTemperature_degC);

        new J_EAStorageHeat(
                luxGridConnection,
                OL_EnergyAssetType.STORAGE_HEAT,
                power_kW,
                lossFactor_WpK,
                luxLoader.energyModel.p_timeParameters,
                maxTemperature_degC,
                minTemperature_degC,
                maxTemperature_degC,
                maxTemperature_degC,
                heatCapacity_JpK,
                OL_AmbientTempType.AMBIENT_AIR
        );
    }

    /**
     * @return the most heat the buffer ever has to have standing by, in kWh.
     * <p>
     * Walks the hot water profile keeping a running shortfall: every timestep the draw asks for
     * more than the heat pump can make, the difference has to come out of the buffer, and every
     * timestep it asks for less, the heat pump puts the difference back. The largest the
     * shortfall ever gets is the amount the buffer has to be holding when that draw starts, so
     * that manageHotWaterHeatBuffer never finds itself empty.
     */
    private static double shortfallAgainstHeatingPower_kWh(J_EAProfile hotWaterAsset, double heatingPower_kW) {
        var profilePointer = hotWaterAsset.getProfilePointer();
        var stepHours = profilePointer.getDataTimeStep_h();
        var toKilowatt = hotWaterAsset.getProfileUnitScaler_fr() * hotWaterAsset.getProfileScaling_fr();

        var shortfall_kWh = 0.0;
        var worstShortfall_kWh = 0.0;
        for (double value : profilePointer.getAllValues()) {
            var demand_kW = value * toKilowatt;
            shortfall_kWh = Math.max(0, shortfall_kWh + (demand_kW - heatingPower_kW) * stepHours);
            worstShortfall_kWh = Math.max(worstShortfall_kWh, shortfall_kWh);
        }
        return worstShortfall_kWh;
    }

    private static void checkHeatingAsset(EConnection eConnection, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        // Some houses, like beca94a3-5a38-4a62-ad76-43c7948f9fc7 in BU31_veelflex.esdl, have no heating asset.
        // We give these houses a gas burner
        if (luxGridConnection.c_heatingAssets.isEmpty()) {
            double outputPower_kW = 10;
            J_HeatingPreferences heatingPreferences = luxLoader.f_getHouseHeatingPreferences();
            luxLoader.f_addHeatAsset(luxGridConnection, OL_GridConnectionHeatingType.GAS_BURNER, outputPower_kW, heatingPreferences);
        }
    }
}
