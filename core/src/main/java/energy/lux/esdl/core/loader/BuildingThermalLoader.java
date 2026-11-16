package energy.lux.esdl.core.loader;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.profile.bare.BareProfileChecker;
import energy.lux.esdl.core.loader.profile.bare.BareProfileReader;
import energy.lux.esdl.core.util.DateTimeUtil;
import energy.lux.esdl.core.util.Util;
import esdl.AbstractBuilding;
import esdl.BuildingInformation;
import esdl.BuildingStructureInformation;
import esdl.EnergyLabelEnum;
import esdl.GenericBuilding;
import esdl.GenericProfile;
import esdl.HeatingDemand;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.energyassets.J_EAProfile;
import energy.lux.engine.energyassets.J_EAStorageHeat;
import energy.lux.engine.dataclasses.J_HeatingPreferences;
import energy.lux.engine.optionlists.OL_AmbientTempType;
import energy.lux.engine.optionlists.OL_AssetFlowCategories;
import energy.lux.engine.optionlists.OL_EnergyAssetType;
import energy.lux.engine.optionlists.OL_EnergyCarriers;
import energy.lux.engine.optionlists.OL_GridConnectionEnergyLabel;
import energy.lux.engine.optionlists.OL_GridConnectionInsulationLabel;
import energy.lux.engine.optionlists.OL_ProfileUnits;
import energy.lux.engine.EnergyModel;
import energy.lux.loader.EnergyAssetCreator;
import energy.lux.loader.temporary.LoaderRandom;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class BuildingThermalLoader {
    private static final double defaultFloorArea = 100;
    private static final double litresPerCubicMetre = 1000;
    private static final double wattsPerKilowatt = 1000;
    private static final double hotWaterTemperatureRise_K = 55.0 - 15.0;
    private static final double fallbackHotWaterDemand_kWhpa = 545.0;
    private static final int fallbackNumberOfResidents = 2;

    /*
     * C_in and the ventilation loss follow the RC model of DOTS, as a DOTS colleague described it
     * on 2026-11-10, based on a TNO report. DOTS names the usable area surfaceArea and the ground
     * floor area floorArea, the other way round from the decorated ESDL.
     */

    /**
     * C_in = (0.0784 MJ/K per m³ · volume + 1.97 MJ/K), from the TNO report.
     */
    private static final double internalHeatCapacityPerVolume_JpKm3 = 0.0784e6;
    private static final double internalHeatCapacityOffset_JpK = 1.97e6;

    /**
     * The ESDL states no volume. The DOTS reference house (rijwoning hoek 1965-1974, C_in
     * 29,243,792 J/K over 115.96 m² usable area) fits a volume of exactly 3 m times the usable
     * area. Not yet confirmed by DOTS.
     */
    private static final double volumePerUsableArea_m = 3.0;

    private static final double airHeatCapacityPerVolume_JpKm3 = 1230;

    /**
     * qv10 is the air leakage at 10 Pa pressure difference, in dm³/s per m² usable area. DOTS
     * takes 4 for houses built up to 1967 and lets it fall off exponentially for newer houses.
     */
    private static final int lastBuildYearWithOldAirTightness = 1967;
    private static final double oldAirTightness_dm3pspm2 = 4.0;
    private static final double newestAirTightness_dm3pspm2 = 0.3;
    private static final double airTightnessDecayYears = 16.0;

    /**
     * Scales the leakage at 10 Pa to the about 1 Pa of normal weather, with a flow exponent of 0.7.
     */
    private static final double leakageAtOnePascalPerLeakageAtTenPascal = Math.pow(10, -0.7);
    private static final double cubicMetresPerCubicDecimetre = 1e-3;

    /**
     * The share of the heat stored above the setpoint that leaves through the heat loss
     * coefficient H. Between about 0.3 (heat that goes into the walls never comes back) and 1.0
     * (all of it leaves through H, as if the walls were already warm).
     */
    private static final double heatBatteryBeta = 0.6;

    /**
     * How far a house may cool below its setpoint when the heat pump cannot keep up, before the
     * RC heat battery stops at its floor. A guess, wide enough that a house never hits it.
     */
    private static final double deepestComfortDeficit_K = 5.0;

    private final EnergyModel energyModel;
    private final ProfilePointerRegistry profilePointerRegistry;
    private final BareProfileReader bareProfileReader;

    // Temporary: the LUX loader sizes the building model. This loader will get its own model.
    private final EnergyAssetCreator assetCreator = new EnergyAssetCreator();
    private final LoaderRandom random = new LoaderRandom.Seeded();

    public BuildingThermalLoader(EnergyModel energyModel, ProfilePointerRegistry profilePointerRegistry) {
        this.energyModel = energyModel;
        this.profilePointerRegistry = profilePointerRegistry;

        var timeParameters = energyModel.p_timeParameters;
        this.bareProfileReader = new BareProfileReader(
                DateTimeUtil.hoursToDuration(timeParameters.getTimeStep_h()),
                new BareProfileChecker(Year.of(timeParameters.getStartYear()))
        );
    }

    public void loadBuilding(AbstractBuilding building, GridConnection luxGridConnection) {
        if (building instanceof GenericBuilding genericBuilding) {
            loadGenericBuilding(genericBuilding, luxGridConnection);
        } else {
            throw new NotImplemented("Not implemented building type " + Util.printItem(building));
        }
    }

    /**
     * The heating of a house with a heat pump is built from the heat pump, see
     * GridConnectionAssetIterator, because the heat stores are sized on it. The ESDL states the
     * heat demand of the other houses nowhere, so they get the LUX defaults.
     */
    private void loadGenericBuilding(GenericBuilding building, GridConnection luxGridConnection) {
        // Lux complains if these are not set
        luxGridConnection.p_energyLabel = toLuxEnergyLabel(building.getEnergyLabel());
        luxGridConnection.p_insulationLabel = toLuxInsulationLabel(building.getEnergyLabel());

        if (!HeatingChainFinder.containsHeatPump(building)) {
            addBuildingHeatModel(building, luxGridConnection);
            addDefaultHotWaterDemand(luxGridConnection);
        }
    }

    /**
     * LUX builds a simple RC model of the building, sized from the insulation label and the
     * floor area.
     */
    private void addBuildingHeatModel(GenericBuilding building, GridConnection luxGridConnection) {
        var floorAreaM2 = Util.defaultIfZero(building.getFloorArea(), defaultFloorArea);

        assetCreator.f_addBuildingHeatModel(
                luxGridConnection,
                floorAreaM2,
                null,
                new J_HeatingPreferences(),
                energyModel,
                energyModel.avgc_data,
                random
        );
    }

    /**
     * LUX takes its default hot water profile, scaled to a typical household.
     */
    private void addDefaultHotWaterDemand(GridConnection luxGridConnection) {
        assetCreator.f_addHotWaterDemand(
                luxGridConnection,
                fallbackHotWaterDemand_kWhpa,
                fallbackNumberOfResidents,
                energyModel,
                random,
                new HashMap<>()
        );
    }

    /**
     * Hot water is imported as the profile itself rather than as a yearly total, so that the
     * draw pattern of the ESDL survives instead of being replaced by the LUX default shape.
     *
     * @param heatingDemand a HOT_TAPWATER demand, usually shared with other houses
     */
    public J_EAProfile addHotWaterDemand(HeatingDemand heatingDemand, GridConnection luxGridConnection) {
        var profilePointer = this.profilePointerRegistry.getOrCreateProfilePointer(
                findProfile(heatingDemand),
                profilePointerName(heatingDemand, "hot_water"),
                OL_ProfileUnits.KW,
                this::readHotWaterProfileAsKilowatt
        );

        return new J_EAProfile(
                luxGridConnection,
                OL_EnergyCarriers.HEAT,
                profilePointer,
                OL_AssetFlowCategories.hotWaterConsumption_kW,
                energyModel.p_timeParameters
        );
    }

    /**
     * The profile is the heat that keeps the house at its setpoint. Heating above the setpoint
     * goes into the RC heat battery instead.
     *
     * @param heatingDemand a SPACE_HEATING demand, usually shared with other houses
     */
    public J_EAProfile addSpaceHeatingDemand(HeatingDemand heatingDemand, GridConnection luxGridConnection) {
        var profilePointer = this.profilePointerRegistry.getOrCreateProfilePointer(
                findProfile(heatingDemand),
                profilePointerName(heatingDemand, "space_heating"),
                OL_ProfileUnits.KW,
                // The space heating profiles hold thermal power in kW.
                this.bareProfileReader::readProfile
        );

        return new J_EAProfile(
                luxGridConnection,
                OL_EnergyCarriers.HEAT,
                profilePointer,
                OL_AssetFlowCategories.spaceHeating_kW,
                energyModel.p_timeParameters
        );
    }

    /**
     * The RC heat battery stands for the heat a house holds above its setpoint. It is empty at
     * the setpoint and full at the top of the comfort band, and leaks H / β per kelvin above the
     * setpoint. Below the setpoint its content runs negative, down to the deepest comfort deficit.
     * <p>
     * The comfort band is that of the space heating demand, so all houses sharing a demand share
     * their band.
     *
     * @param capacityHeat_kW the most heat that may flow in or out per timestep, see
     *                        {@link WaterBufferLoader#loadWaterBuffer}
     */
    public J_EAStorageHeat addHeatBattery(
            GenericBuilding building,
            HeatingDemand spaceHeatingDemand,
            GridConnection luxGridConnection,
            double capacityHeat_kW
    ) {
        assertComfortBand(spaceHeatingDemand);
        var setpoint_degC = spaceHeatingDemand.getMinTemperature();

        // Not BUILDINGTHERMALS: GridConnection would take it for its own RC model.
        var heatBattery = new J_EAStorageHeat(
                luxGridConnection,
                OL_EnergyAssetType.STORAGE_HEAT,
                capacityHeat_kW,
                heatBatteryLossFactor_WpK(building),
                energyModel.p_timeParameters,
                setpoint_degC,
                setpoint_degC - deepestComfortDeficit_K,
                spaceHeatingDemand.getMaxTemperature(),
                setpoint_degC,
                internalHeatCapacity_JpK(building),
                OL_AmbientTempType.FIXED
        );
        // The constructor does not set the ambient temperature, and FIXED never overwrites it.
        heatBattery.updateAmbientTemperature(setpoint_degC);
        return heatBattery;
    }

    private static void assertComfortBand(HeatingDemand spaceHeatingDemand) {
        if (!(spaceHeatingDemand.getMaxTemperature() > spaceHeatingDemand.getMinTemperature())) {
            throw new EsdlException(String.format(
                    "Space heating demand %s has a maximum temperature of %s °C, which is not above its setpoint of %s °C",
                    spaceHeatingDemand.getName(),
                    spaceHeatingDemand.getMaxTemperature(),
                    spaceHeatingDemand.getMinTemperature()
            ));
        }
    }

    /**
     * Then the loss of the RC heat battery divided by its content is 1 / τ.
     */
    static double heatBatteryLossFactor_WpK(GenericBuilding building) {
        return heatLossCoefficient_WpK(building) / heatBatteryBeta;
    }

    /**
     * @return C_in, the heat the inside of the house holds per kelvin
     */
    static double internalHeatCapacity_JpK(GenericBuilding building) {
        return internalHeatCapacityPerVolume_JpKm3 * volume_m3(building) + internalHeatCapacityOffset_JpK;
    }

    private static double volume_m3(GenericBuilding building) {
        return volumePerUsableArea_m * usableFloorArea_m2(building);
    }

    /**
     * @return H, the heat the house loses per kelvin between inside and outside
     */
    static double heatLossCoefficient_WpK(GenericBuilding building) {
        return ventilationLoss_WpK(building) + floorLoss_WpK(building) + transmissionLoss_WpK(building);
    }

    static double ventilationLoss_WpK(GenericBuilding building) {
        var airLeakage_m3psPerM2 = airTightness_dm3pspm2(building)
                * leakageAtOnePascalPerLeakageAtTenPascal
                * cubicMetresPerCubicDecimetre;
        return airHeatCapacityPerVolume_JpKm3 * airLeakage_m3psPerM2 * usableFloorArea_m2(building);
    }

    /**
     * @return qv10, see {@link #lastBuildYearWithOldAirTightness}
     */
    static double airTightness_dm3pspm2(GenericBuilding building) {
        var buildingYear = building.getBuildingYear();
        Util.throwIfZero(buildingYear, building, "buildingYear");
        if (buildingYear <= lastBuildYearWithOldAirTightness) {
            return oldAirTightness_dm3pspm2;
        }
        return newestAirTightness_dm3pspm2
                + (oldAirTightness_dm3pspm2 - newestAirTightness_dm3pspm2)
                * Math.exp((lastBuildYearWithOldAirTightness - buildingYear) / airTightnessDecayYears);
    }

    /**
     * The floor loses heat over the ground floor area, which the ESDL states as surfaceArea.
     */
    private static double floorLoss_WpK(GenericBuilding building) {
        var structures = findStructureInformation(building);
        return lossThroughRcValue_WpK(
                building.getSurfaceArea(),
                readStructureValue(building, structures, BuildingStructureInformation::getRcFloor, "rcFloor"),
                building,
                "floor"
        );
    }

    /**
     * R_exch + R_cond in the two-node model is the path from inside through the walls to outside,
     * so its inverse is this transmission loss.
     */
    private static double transmissionLoss_WpK(GenericBuilding building) {
        var structures = findStructureInformation(building);
        return wallLoss_WpK(building, structures)
                + roofLoss_WpK(building, structures)
                + windowLoss_WpK(building, structures)
                + doorLoss_WpK(building, structures);
    }

    private static double wallLoss_WpK(GenericBuilding building, List<BuildingStructureInformation> structures) {
        return lossThroughRcValue_WpK(
                readStructureValue(building, structures, BuildingStructureInformation::getWallArea, "wallArea"),
                readStructureValue(building, structures, BuildingStructureInformation::getRcWall, "rcWall"),
                building,
                "wall"
        );
    }

    /**
     * Flat and slanted roofs share one rc value.
     */
    private static double roofLoss_WpK(GenericBuilding building, List<BuildingStructureInformation> structures) {
        var roofArea_m2 = readStructureValue(building, structures, BuildingStructureInformation::getFlatRoofArea, "flatRoofArea")
                + readStructureValue(building, structures, BuildingStructureInformation::getSlantedRoofArea, "slantedRoofArea");
        return lossThroughRcValue_WpK(
                roofArea_m2,
                readStructureValue(building, structures, BuildingStructureInformation::getRcRoof, "rcRoof"),
                building,
                "roof"
        );
    }

    private static double windowLoss_WpK(GenericBuilding building, List<BuildingStructureInformation> structures) {
        return readStructureValue(building, structures, BuildingStructureInformation::getWindowArea, "windowArea")
                * readStructureValue(building, structures, BuildingStructureInformation::getUWindow, "uWindow");
    }

    private static double doorLoss_WpK(GenericBuilding building, List<BuildingStructureInformation> structures) {
        return readStructureValue(building, structures, BuildingStructureInformation::getDoorArea, "doorArea")
                * readStructureValue(building, structures, BuildingStructureInformation::getUDoor, "uDoor");
    }

    private static double lossThroughRcValue_WpK(double area_m2, double rcValue_m2KpW, GenericBuilding building, String surface) {
        if (area_m2 == 0.0) {
            return 0.0;
        }
        if (rcValue_m2KpW == 0.0) {
            throw new EsdlException(String.format(
                    "Building %s has a %s area of %s m² but no rc value for it",
                    Util.printItem(building),
                    surface,
                    area_m2
            ));
        }
        return area_m2 / rcValue_m2KpW;
    }

    /**
     * The ESDL states the usable floor area as floorArea.
     */
    private static double usableFloorArea_m2(GenericBuilding building) {
        Util.throwIfZero(building.getFloorArea(), building, "floorArea");
        return building.getFloorArea();
    }

    private static List<BuildingStructureInformation> findStructureInformation(GenericBuilding building) {
        var structures = new ArrayList<BuildingStructureInformation>();
        for (BuildingInformation buildingInformation : building.getBuildinginformation()) {
            if (buildingInformation instanceof BuildingStructureInformation structureInformation) {
                structures.add(structureInformation);
            }
        }
        if (structures.isEmpty()) {
            throw new EsdlException("Building " + Util.printItem(building) + " has no BuildingStructureInformation");
        }
        return structures;
    }

    /**
     * The decorator spreads the values over two BuildingStructureInformation entries, the rc and
     * u values in one and the areas in the other, and leaves every value it does not write at 0.
     *
     * @return the value of the one entry that states it, or 0 when none does
     */
    private static double readStructureValue(
            GenericBuilding building,
            List<BuildingStructureInformation> structures,
            ToDoubleFunction<BuildingStructureInformation> getter,
            String property
    ) {
        var statedValue = 0.0;
        for (BuildingStructureInformation structure : structures) {
            var value = getter.applyAsDouble(structure);
            if (value == 0.0) {
                continue;
            }
            if (statedValue != 0.0 && statedValue != value) {
                throw new EsdlException(String.format(
                        "Building %s states %s twice, as %s and %s",
                        Util.printItem(building),
                        property,
                        statedValue,
                        value
                ));
            }
            statedValue = value;
        }
        return statedValue;
    }

    private static GenericProfile findProfile(HeatingDemand heatingDemand) {
        var profile = Util.findFirstProfile(heatingDemand);
        if (profile == null) {
            throw new EsdlException(String.format(
                    "HeatingDemand %s of type %s has no profile",
                    heatingDemand.getName(),
                    heatingDemand.getType()
            ));
        }
        return profile;
    }

    /**
     * The hot tap water profiles hold the water drawn in litres per second, averaged over the timestep
     */
    private ArrayTimeSeries readHotWaterProfileAsKilowatt(GenericProfile profile) {
        var timeSeries = this.bareProfileReader.readProfile(profile);

        var kilowattPerLitrePerSecond =
                WaterBufferLoader.waterHeatCapacityPerVolume_JpKm3 / litresPerCubicMetre
                        * hotWaterTemperatureRise_K
                        / wattsPerKilowatt;

        var values = timeSeries.copyValuesArray();
        for (int i = 0; i < values.length; i++) {
            values[i] *= kilowattPerLitrePerSecond;
        }

        return (ArrayTimeSeries) timeSeries.toBuilder()
                .values(values)
                .build();
    }

    private static String profilePointerName(HeatingDemand heatingDemand, String suffix) {
        return Util.firstNonBlank(
                heatingDemand.getId(),
                heatingDemand.getName(),
                heatingDemand.getDescription(),
                suffix
        ) + "_" + suffix;
    }

    private static OL_GridConnectionEnergyLabel toLuxEnergyLabel(EnergyLabelEnum esdlEnergyLabel) {
        if (esdlEnergyLabel == null) {
            return OL_GridConnectionEnergyLabel.UNKNOWN;
        }

        return switch (esdlEnergyLabel) {
            // LUX has no labels above A, so A+ through A++++ all become A.
            case LABEL_A, LABEL_AP, LABEL_APP, LABEL_APPP, LABEL_APPPP -> OL_GridConnectionEnergyLabel.A;
            case LABEL_B -> OL_GridConnectionEnergyLabel.B;
            case LABEL_C -> OL_GridConnectionEnergyLabel.C;
            case LABEL_D -> OL_GridConnectionEnergyLabel.D;
            case LABEL_E -> OL_GridConnectionEnergyLabel.E;
            case LABEL_F -> OL_GridConnectionEnergyLabel.F;
            case LABEL_G -> OL_GridConnectionEnergyLabel.G;
            case UNDEFINED -> OL_GridConnectionEnergyLabel.NONE;
            default -> throw new NotImplemented("Unknown energy label: " + esdlEnergyLabel);
        };
    }

    private static OL_GridConnectionInsulationLabel toLuxInsulationLabel(EnergyLabelEnum esdlEnergyLabel) {
        if (esdlEnergyLabel == null) {
            return OL_GridConnectionInsulationLabel.UNKNOWN;
        }

        return switch (esdlEnergyLabel) {
            // LUX has no labels above A, so A+ through A++++ all become A.
            case LABEL_A, LABEL_AP, LABEL_APP, LABEL_APPP, LABEL_APPPP -> OL_GridConnectionInsulationLabel.A;
            case LABEL_B -> OL_GridConnectionInsulationLabel.B;
            case LABEL_C -> OL_GridConnectionInsulationLabel.C;
            case LABEL_D -> OL_GridConnectionInsulationLabel.D;
            case LABEL_E -> OL_GridConnectionInsulationLabel.E;
            case LABEL_F -> OL_GridConnectionInsulationLabel.F;
            case LABEL_G -> OL_GridConnectionInsulationLabel.G;
            case UNDEFINED -> OL_GridConnectionInsulationLabel.NONE;
            default -> throw new NotImplemented("Unknown energy label: " + esdlEnergyLabel);
        };
    }
}
