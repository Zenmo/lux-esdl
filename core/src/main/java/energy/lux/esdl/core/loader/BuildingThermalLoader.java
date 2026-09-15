package energy.lux.esdl.core.loader;

import com.zenmo.timeseries.untyped.ArrayTimeSeries;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.loader.profile.ProfilePointerRegistry;
import energy.lux.esdl.core.loader.profile.bare.BareProfileChecker;
import energy.lux.esdl.core.loader.profile.bare.BareProfileReader;
import energy.lux.esdl.core.util.DateTimeUtil;
import energy.lux.esdl.core.util.Util;
import esdl.AbstractBuilding;
import esdl.EnergyLabelEnum;
import esdl.GenericBuilding;
import esdl.GenericProfile;
import esdl.HeatDemandTypeEnum;
import esdl.HeatingDemand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.GridConnection;
import zero_engine.J_EAProfile;
import zero_engine.J_HeatingPreferences;
import zero_engine.OL_AssetFlowCategories;
import zero_engine.OL_EnergyCarriers;
import zero_engine.OL_GridConnectionEnergyLabel;
import zero_engine.OL_GridConnectionInsulationLabel;
import zero_engine.OL_ProfileUnits;
import zerointerfaceloader.Zero_Loader;

import java.time.Year;

public class BuildingThermalLoader {
    private static final Logger logger = LoggerFactory.getLogger(BuildingThermalLoader.class);

    private static final double defaultFloorArea = 100;

    private static final double hoursPerYear = 8760;

    private static final double litresPerCubicMetre = 1000;

    private static final double wattsPerKilowatt = 1000;

    /**
     * Correction factor because f_addBuildingHeatModel seems quite far off from the yearly heat demand.
     */
    private static final double heatDemandCorrectionFactor = 1.35;

    /**
     * How far the drawn water has to be heated: from a supply of 15 degrees to 55 degrees at
     * the tap, agreed with the people who produce the profiles.
     * <p>
     * The ESDL states a water flow and no temperature at all, and LUX has no hot water setpoint
     * to take one from, so this is the single assumption that turns the profiles into energy.
     * Everything else in the conversion is physics, and the energy scales linearly with it.
     */
    private static final double hotWaterTemperatureRise_K = 55.0 - 15.0;

    private static final double fallbackHotWaterDemand_kWhpa = 545.0;

    private static final int fallbackNumberOfResidents = 2;

    private final Zero_Loader luxLoader;

    private final ProfilePointerRegistry profilePointerRegistry;

    private final BareProfileReader bareProfileReader;

    public BuildingThermalLoader(Zero_Loader luxLoader, ProfilePointerRegistry profilePointerRegistry) {
        this.luxLoader = luxLoader;
        this.profilePointerRegistry = profilePointerRegistry;

        var timeParameters = luxLoader.energyModel.p_timeParameters;
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

    private void loadGenericBuilding(GenericBuilding building, GridConnection luxGridConnection) {
        // Lux complains if these are not set
        luxGridConnection.p_energyLabel = toLuxEnergyLabel(building.getEnergyLabel());
        luxGridConnection.p_insulationLabel = toLuxInsulationLabel(building.getEnergyLabel());

        addBuildingHeatModel(building, luxGridConnection);
        addHotWaterDemand(building, luxGridConnection);
    }

    /**
     * LUX builds a simple RC model of the building. It sizes the heat loss factor from the
     * yearly space heating demand when one is given, and from the insulation label and the
     * floor area when it is not, which is what the houses without a heat pump fall back on.
     */
    private void addBuildingHeatModel(GenericBuilding building, GridConnection luxGridConnection) {
        var floorAreaM2 = Util.defaultIfZero(building.getFloorArea(), defaultFloorArea);
        var spaceHeatingDemand_kWhpa = findAnnualSpaceHeatingDemand_kWhpa(building);

        Double correctedHeatDemand_kWhpa = spaceHeatingDemand_kWhpa == null
                ? null
                : spaceHeatingDemand_kWhpa / heatDemandCorrectionFactor;

        J_HeatingPreferences heatingPreferences = new J_HeatingPreferences(); //luxLoader.f_getHouseHeatingPreferences();
        luxLoader.f_addBuildingHeatModel(luxGridConnection, floorAreaM2, correctedHeatDemand_kWhpa, heatingPreferences);
    }

    /**
     * @return the yearly space heating demand of the building, or null when the ESDL has none.
     */
    private Double findAnnualSpaceHeatingDemand_kWhpa(AbstractBuilding building) {
        var profile = findHeatingDemandProfile(building, HeatDemandTypeEnum.SPACE_HEATING);
        if (profile == null) {
            return null;
        }

        // The space heating profiles hold thermal power in kW.
        return integrateOverFullYear_kWh(this.bareProfileReader.readProfile(profile));
    }

    /**
     * Hot water is imported as the profile itself rather than as a yearly total, so that the
     * draw pattern of the ESDL survives instead of being replaced by the LUX default shape.
     */
    private void addHotWaterDemand(AbstractBuilding building, GridConnection luxGridConnection) {
        var heatingDemand = HeatingDemandFinder.findHeatingDemand(building, HeatDemandTypeEnum.HOT_TAPWATER);
        var profile = heatingDemand == null ? null : Util.findFirstProfile(heatingDemand);
        if (profile == null) {
            luxLoader.f_addHotWaterDemand(luxGridConnection, fallbackHotWaterDemand_kWhpa, fallbackNumberOfResidents);
            return;
        }

        var profilePointer = this.profilePointerRegistry.getOrCreateProfilePointer(
                profile,
                hotWaterProfilePointerName(heatingDemand),
                OL_ProfileUnits.KW,
                this::readHotWaterProfileAsKilowatt
        );

        new J_EAProfile(
                luxGridConnection,
                OL_EnergyCarriers.HEAT,
                profilePointer,
                OL_AssetFlowCategories.hotWaterConsumption_kW,
                luxLoader.energyModel.p_timeParameters
        );
    }

    /**
     * The hot tap water profiles hold the water drawn in litres per second, averaged over the
     * timestep. A flow is already a rate, so it becomes thermal power without any reference to
     * how long a timestep is:
     * <pre>
     * kW = l/s  x  kg/l  x  J/kgK  x  K  /  (W per kW)
     * </pre>
     * with the density and heat capacity of water that LUX itself carries, over
     * {@link #hotWaterTemperatureRise_K}. That comes out at 167.1 kW per l/s, so a 10 l/min
     * shower draws about 28 kW while it runs.
     */
    private ArrayTimeSeries readHotWaterProfileAsKilowatt(GenericProfile profile) {
        var timeSeries = this.bareProfileReader.readProfile(profile);

        var averagesData = luxLoader.energyModel.avgc_data;
        var kilowattPerLitrePerSecond =
                averagesData.p_waterDensity_kgpm3 / litresPerCubicMetre
                        * averagesData.p_waterHeatCapacity_JpkgK
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

    private GenericProfile findHeatingDemandProfile(AbstractBuilding building, HeatDemandTypeEnum demandType) {
        var heatingDemand = HeatingDemandFinder.findHeatingDemand(building, demandType);
        if (heatingDemand == null) {
            return null;
        }

        var profile = Util.findFirstProfile(heatingDemand);
        if (profile == null) {
            logger.warn("HeatingDemand {} of type {} has no profile", heatingDemand.getName(), demandType);
        }
        return profile;
    }

    /**
     * The heat demand profiles do not all cover exactly one year: space heating covers 364 days
     * and hot water 366. Scale the integral to the 8760 hours that LUX simulates.
     */
    private static double integrateOverFullYear_kWh(ArrayTimeSeries timeSeries) {
        var stepHours = DateTimeUtil.durationToHours(timeSeries.getStep());
        var values = timeSeries.copyValuesArray();

        var sum = 0.0;
        for (double value : values) {
            sum += value;
        }

        var coveredHours = values.length * stepHours;
        return sum * stepHours * (hoursPerYear / coveredHours);
    }

    private static String hotWaterProfilePointerName(HeatingDemand heatingDemand) {
        return Util.firstNonBlank(
                heatingDemand.getId(),
                heatingDemand.getName(),
                heatingDemand.getDescription(),
                "hot_water"
        ) + "_hot_water";
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
