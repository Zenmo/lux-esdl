package energy.lux.esdl.core;

import energy.lux.engine.EnergyModel;
import energy.lux.engine.activitytrackers.J_ActivityTrackerTrips;
import energy.lux.engine.dataclasses.J_AVGC_data;
import energy.lux.engine.dataclasses.J_HeatingPreferences;
import energy.lux.engine.energyassets.J_EAEV;
import energy.lux.engine.energyassets.J_EAProduction;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.optionlists.OL_ChargingAttitude;
import energy.lux.engine.optionlists.OL_EnergyAssetType;
import energy.lux.engine.optionlists.OL_GridConnectionHeatingType;
import energy.lux.engine.optionlists.OL_PVOrientation;
import energy.lux.engine.optionlists.OL_VehicleType;
import energy.lux.loader.EnergyAssetCreator;
import energy.lux.loader.gridconnectionbuilders.HouseBuilder;
import energy.lux.loader.temporary.LoaderRandom;

import java.util.HashMap;

/**
 * What the ESDL loaders need from LUX to put assets on a grid connection, on top of an energy model
 * that the LUX loader has already prepared.
 * <p>
 * Each method forwards to {@link EnergyAssetCreator}, which asks for the energy model, the averages
 * and the random source on every call. They are held here once so that the ESDL loaders do not have to.
 */
public class LuxModelBuilder {
    public final EnergyModel energyModel;
    public final J_AVGC_data averagesData;

    private final EnergyAssetCreator assetCreator;
    private final LoaderRandom random;
    private final HeatingPreferencesSource heatingPreferencesSource = new HeatingPreferencesSource();

    public LuxModelBuilder(EnergyModel preparedEnergyModel) {
        this(preparedEnergyModel, new EnergyAssetCreator(), new LoaderRandom.Seeded());
    }

    public LuxModelBuilder(EnergyModel preparedEnergyModel, EnergyAssetCreator assetCreator, LoaderRandom random) {
        this.energyModel = preparedEnergyModel;
        this.averagesData = preparedEnergyModel.avgc_data;
        this.assetCreator = assetCreator;
        this.random = random;
    }

    public J_HeatingPreferences newHouseHeatingPreferences() {
        return heatingPreferencesSource.draw(random);
    }

    public J_EAProduction addPVProductionAsset(
            GridConnection gridConnection,
            String name,
            double installedPower_kW,
            OL_PVOrientation orientation
    ) {
        return assetCreator.f_addPVProductionAsset(gridConnection, name, installedPower_kW, orientation, energyModel);
    }

    public void addElectricityDemandProfile(
            GridConnection gridConnection,
            double yearlyDemand_kWh,
            Double pvPower_kW,
            boolean hasQuarterlyData,
            String profileName
    ) {
        assetCreator.f_addElectricityDemandProfile(gridConnection, yearlyDemand_kWh, pvPower_kW, hasQuarterlyData, profileName, energyModel);
    }

    public void addBuildingHeatModel(
            GridConnection gridConnection,
            double floorArea_m2,
            Double heatDemand_kWhpa,
            J_HeatingPreferences heatingPreferences
    ) {
        assetCreator.f_addBuildingHeatModel(gridConnection, floorArea_m2, heatDemand_kWhpa, heatingPreferences, energyModel, averagesData, random);
    }

    /**
     * Without hot water profiles to pick from, LUX falls back to its default hot water profile.
     * The LUX loader does not read its profile collection at the moment, so that is always the case here.
     */
    public void addHotWaterDemand(GridConnection gridConnection, double yearlyDemand_kWh, int numberOfResidents) {
        assetCreator.f_addHotWaterDemand(gridConnection, yearlyDemand_kWh, numberOfResidents, energyModel, random, new HashMap<>());
    }

    /**
     * Adds the heating management too, using the given preferences.
     */
    public void addHeatAsset(
            GridConnection gridConnection,
            OL_GridConnectionHeatingType heatingType,
            double maxHeatOutputPower_kW,
            J_HeatingPreferences heatingPreferences
    ) {
        assetCreator.f_addHeatAsset(gridConnection, heatingType, maxHeatOutputPower_kW, heatingPreferences, energyModel, averagesData);
    }

    public void addStorage(
            GridConnection gridConnection,
            double power_kW,
            double capacity_kWh,
            OL_EnergyAssetType storageType
    ) {
        assetCreator.f_addStorage(gridConnection, power_kW, capacity_kWh, storageType, energyModel);
    }

    /**
     * The trips of the given tracker are kept as they are. Adds the charging management of the given attitude too.
     */
    public J_EAEV addElectricVehicle(
            GridConnection gridConnection,
            OL_VehicleType vehicleType,
            boolean isDefaultVehicle,
            double annualTravelDistance_km,
            double maxChargingPower_kW,
            OL_ChargingAttitude chargingAttitude,
            J_ActivityTrackerTrips tripTracker
    ) {
        return assetCreator.f_addElectricVehicle(
                gridConnection, vehicleType, isDefaultVehicle, annualTravelDistance_km, maxChargingPower_kW,
                chargingAttitude, tripTracker, energyModel, averagesData
        );
    }

    /**
     * The LUX loader only offers the draw of heating preferences as a protected method of its house builder.
     */
    private static class HeatingPreferencesSource extends HouseBuilder {
        J_HeatingPreferences draw(LoaderRandom random) {
            return f_getHouseHeatingPreferences(random);
        }
    }
}
