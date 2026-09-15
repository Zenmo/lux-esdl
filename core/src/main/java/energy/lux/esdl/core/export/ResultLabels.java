package energy.lux.esdl.core.export;

import zero_engine.OL_AssetFlowCategories;
import zero_engine.OL_EnergyCarriers;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * The column names that the LUX results UI puts in its export.
 * <p>
 * These are copied from UI_Results, where they are built in the same function that builds the
 * chart colours. They live in the project interface of the AnyLogic model, which a headless run
 * never creates: {@code Zero_Loader.f_createInterface} throws unless a project supplies its own
 * interface, and the LUX_ProjectTemplate one is in the alp rather than in luxdeps. Copying the
 * two tables is what makes a headless export land on the same columns as the manual one.
 * <p>
 * If the labels in UI_Results change, these go stale silently. They are short enough to compare
 * by eye against the block below {@code lm_assetFlowLabels = new EnumMap<>} in UI_Results.
 */
public class ResultLabels {

    /**
     * The asset flows the results UI shows under electricity.
     * Mirrors {@code UI_Results.v_electricAssetFlows}.
     */
    public static final EnumSet<OL_AssetFlowCategories> electricAssetFlows = EnumSet.of(
            OL_AssetFlowCategories.fixedConsumptionElectric_kW,
            OL_AssetFlowCategories.batteriesChargingPower_kW,
            OL_AssetFlowCategories.batteriesDischargingPower_kW,
            OL_AssetFlowCategories.CHPProductionElectric_kW,
            OL_AssetFlowCategories.electricHobConsumption_kW,
            OL_AssetFlowCategories.electrolyserElectricityConsumption_kW,
            OL_AssetFlowCategories.evChargingPower_kW,
            OL_AssetFlowCategories.heatPumpElectricityConsumption_kW,
            OL_AssetFlowCategories.pvProductionElectric_kW,
            OL_AssetFlowCategories.V2GPower_kW,
            OL_AssetFlowCategories.windProductionElectric_kW,
            OL_AssetFlowCategories.airConditionersElectricPower_kW,
            OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW,
            OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW,
            OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW
    );

    /**
     * Mirrors {@code UI_Results.lm_assetFlowLabels}.
     */
    private static final Map<OL_AssetFlowCategories, String> assetFlowLabels = buildAssetFlowLabels();

    private static Map<OL_AssetFlowCategories, String> buildAssetFlowLabels() {
        var labels = new EnumMap<OL_AssetFlowCategories, String>(OL_AssetFlowCategories.class);
        labels.put(OL_AssetFlowCategories.fixedConsumptionElectric_kW, "Elektr. behoefte basis");
        labels.put(OL_AssetFlowCategories.batteriesChargingPower_kW, "Opladen batterijen");
        labels.put(OL_AssetFlowCategories.batteriesDischargingPower_kW, "Ontladen batterijen");
        labels.put(OL_AssetFlowCategories.CHPProductionElectric_kW, "Elektr. opwek WKK");
        labels.put(OL_AssetFlowCategories.districtHeatDelivery_kW, "Warmte uit warmtenet");
        labels.put(OL_AssetFlowCategories.electricHobConsumption_kW, "Elektrisch koken");
        labels.put(OL_AssetFlowCategories.electrolyserElectricityConsumption_kW, "Elektr. behoefte elektrolysers");
        labels.put(OL_AssetFlowCategories.evChargingPower_kW, "Opladen EVs");
        labels.put(OL_AssetFlowCategories.heatPumpElectricityConsumption_kW, "Elektr. behoefte warmte");
        labels.put(OL_AssetFlowCategories.ptProductionHeat_kW, "Warmte zonnecollectoren");
        labels.put(OL_AssetFlowCategories.pvProductionElectric_kW, "Opwek zonne-energie");
        labels.put(OL_AssetFlowCategories.V2GPower_kW, "Vehicle to Grid");
        labels.put(OL_AssetFlowCategories.windProductionElectric_kW, "Opwek wind");
        labels.put(OL_AssetFlowCategories.airConditionersElectricPower_kW, "Elektr. behoefte Airco's");
        labels.put(OL_AssetFlowCategories.dieselGeneratorProductionElectric_kW, "Elektr. opwek diesel gen.");
        labels.put(OL_AssetFlowCategories.methaneGeneratorProductionElectric_kW, "Elektr. opwek gas gen.");
        labels.put(OL_AssetFlowCategories.hydrogenFuelCellProductionElectric_kW, "Elektr. opwek H2 fuelcell");
        return labels;
    }

    public static String assetFlowLabel(OL_AssetFlowCategories assetFlow) {
        var label = assetFlowLabels.get(assetFlow);
        if (label == null) {
            throw new IllegalArgumentException("No label for asset flow " + assetFlow);
        }
        return label;
    }

    /**
     * Mirrors {@code UI_Results.f_getECName}.
     */
    public static String energyCarrierName(OL_EnergyCarriers energyCarrier) {
        return switch (energyCarrier) {
            case ELECTRICITY -> "Elektriciteit";
            case HEAT -> "Warmte";
            case METHANE -> "Gas";
            case PETROLEUM_FUEL -> "Diesel & Benzine";
            case HYDROGEN -> "Waterstof";
            case IRON_POWDER -> "IJzerpoeder";
            default -> throw new IllegalArgumentException("Unknown energy carrier " + energyCarrier);
        };
    }

    /**
     * Mirrors {@code ChartProfielen.f_getProfileTypeName}.
     */
    public static String profileTypeName(double profileSignalResolution_h, double timeStep_h) {
        if (profileSignalResolution_h == timeStep_h) {
            return "Netto ";
        }
        if (profileSignalResolution_h == 24) {
            return "Dag gemiddeld ";
        }
        throw new IllegalArgumentException("Unsupported profile resolution " + profileSignalResolution_h);
    }
}
