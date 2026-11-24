package energy.lux.esdl.core.export;

import energy.lux.esdl.core.ESDLReader;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.iterator.RootIterator;
import energy.lux.esdl.core.loader.marketfeedback.RepresentedArchetype;
import energy.lux.esdl.core.util.CollectionUtil;
import esdl.Asset;
import esdl.Battery;
import esdl.EConnection;
import esdl.EVChargingStation;
import esdl.EnergySystem;
import esdl.HeatPump;
import esdl.PVInstallation;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import energy.lux.engine.EnergyModel;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.managementclasses.aggregatormanagements.aggregatorenergymanagements.J_ISIE_Aggregator_EMS;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.ToDoubleFunction;

/**
 * Run one scenario headlessly and export its electricity profiles, replacing the round trip
 * through the AnyLogic UI: open the model, run it, pick the scope, tick the boxes, download.
 * <p>
 * Pick the scenario with {@link #scenario} below and run it. Everything else follows from that.
 */
public class ScenarioExport {
    private static final Logger logger = LoggerFactory.getLogger(ScenarioExport.class);

    /**
     * The scenario to run. This is the only line to change.
     */
    private static final Scenario defaultScenario = Scenario.NO_TIME_OF_USE_AND_NO_CONGESTION;

    /**
     * Edit {@link #defaultScenario} above, or pass -Pscenario=NAME to run one without editing.
     */
    private static final Scenario scenario = System.getProperty("scenario") == null
            || System.getProperty("scenario").isBlank()
            ? defaultScenario
            : Scenario.valueOf(System.getProperty("scenario"));

    private static final Path esdlDirectory = Path.of(System.getProperty("lux.esdlDirectory", "../esdl-app/data_ProjectTemplate"));

    private static final Path exportDirectory = Path.of(System.getProperty("lux.exportDirectory", "build/exports"));

    /**
     * The assets the exported house should have, so that its profiles show something.
     */
    private static final Map<String, Class<?>> wantedHouseAssets = buildWantedHouseAssets();

    private static Map<String, Class<?>> buildWantedHouseAssets() {
        var wanted = new LinkedHashMap<String, Class<?>>();
        wanted.put("pv", PVInstallation.class);
        wanted.put("heat pump", HeatPump.class);
        wanted.put("ev charge point", EVChargingStation.class);
        wanted.put("battery", Battery.class);
        return wanted;
    }

    /**
     * A scenario is the ESDL it reads and nothing else: the file states both the weights of the
     * time of use tariff and whether the local dynamic measure is active, and the reader sets
     * the congestion factor of the aggregators from that.
     * <p>
     * The files below are one generation of the same area and state nothing else that differs,
     * so their exports are directly comparable: the first charges neither signal, the second
     * only the time of use tariff, the third only the local dynamic measure.
     * <p>
     * The _FIXED_CONTRACT trio repeats those three with every EConnection described as a
     * fixed_contract rather than a dynamic_contract. That description is what
     * GridConnectionLoader reads to decide whether the aggregator manages a house, so in those
     * three no house is managed and neither signal has anything to steer.
     * <p>
     * ISIE is the current generation, which the ISIE_in_LUX_2 project loads. It lives in that
     * repository, so its path assumes the checkout sits next to lux-esdl, as lux2 does. The
     * project adds its main sliders and BAG homes on top; this export runs the ESDL alone.
     */
    public enum Scenario {
        NO_TIME_OF_USE_AND_NO_CONGESTION("no_time_of_use_and_no_congestion.esdl"),
        TIME_OF_USE_WITHOUT_CONGESTION("with_time_of_use_but_without_congestion.esdl"),
        CONGESTION_WITHOUT_TIME_OF_USE("no_time_of_use_but_with_congestion.esdl"),
        NO_TIME_OF_USE_AND_NO_CONGESTION_FIXED_CONTRACT("no_time_of_use_and_no_congestion_fixed_contract.esdl"),
        TIME_OF_USE_WITHOUT_CONGESTION_FIXED_CONTRACT("with_time_of_use_but_without_congestion_fixed_contract.esdl"),
        CONGESTION_WITHOUT_TIME_OF_USE_FIXED_CONTRACT("no_time_of_use_but_with_congestion_fixed_contract.esdl"),
        NO_SIGNALS_AND_NO_DYNAMIC_CONTRACT("decorated_test_notou_no_congestion_nodynamic_normalized.esdl"),
        CORRECTED_NO_SIGNALS_NO_DYNAMIC_CONTRACT("corrected_decorated_test_notou_nocongestion_nodynamic_normalized.esdl"),
        CORRECTED_TIME_OF_USE_WITHOUT_CONGESTION("corrected_decorated_test_tou_nocongestion_dynamic_normalized.esdl"),
        CORRECTED_TIME_OF_USE_WITH_CONGESTION("corrected_decorated_test_tou_congestion_dynamic_normalized.esdl"),
        DECORATED_CONGESTION_FALSE("decorated_test_congestion_false.esdl"),
        DECORATED_CONGESTION_TRUE("decorated_test_congestion_true.esdl"),
        ISIE("../../../ISIE_in_LUX_2/backend/data/isie.esdl"),
        // One house of ISIE with PV, an EV and a grafted battery, cut out by ISIE_in_LUX_2/tools/single_house_esdl.py.
        ISIE_SINGLE_HEAT_PUMP("../../../ISIE_in_LUX_2/backend/data/isie_single_heat_pump.esdl"),
        ISIE_SINGLE_HYBRID_HEAT_PUMP("../../../ISIE_in_LUX_2/backend/data/isie_single_hybrid_heat_pump.esdl"),
        // Scenarios of the ISIE model comparison, with normalised electricity profiles. They live in the ISIE repository.
        // 11 and 12 have dynamic contracts. Their heat pumps and PV match archetype 1woDH; that they stand for the km
        // stock family with the high adoption level is a guess, as the files do not say.
        ISIE_SCENARIO_10("../../../ISIE/Scenarios/Scenarios Modelvergelijking/scenario_10_normalised.esdl"),
        ISIE_SCENARIO_11(
                "../../../ISIE/Scenarios/Scenarios Modelvergelijking/scenario_11_normalised.esdl",
                new RepresentedArchetype("km", "1woDH", 0.8)
        ),
        ISIE_SCENARIO_12(
                "../../../ISIE/Scenarios/Scenarios Modelvergelijking/scenario_12_normalised.esdl",
                new RepresentedArchetype("km", "1woDH", 0.8)
        ),
        // 11 and 12 without a represented archetype, so their aggregators get the market feedback of the national
        // fleet: the planned fleet of the file stands for all flex assets in the country.
        ISIE_SCENARIO_11_NATIONAL_FLEET("../../../ISIE/Scenarios/Scenarios Modelvergelijking/scenario_11_normalised.esdl"),
        ISIE_SCENARIO_12_NATIONAL_FLEET("../../../ISIE/Scenarios/Scenarios Modelvergelijking/scenario_12_normalised.esdl");

        private final String esdlFileName;
        // Null when the ESDL stands for the whole country, as the national constants of the aggregator assume.
        private final RepresentedArchetype representedArchetype;

        Scenario(String esdlFileName) {
            this(esdlFileName, null);
        }

        Scenario(String esdlFileName, RepresentedArchetype representedArchetype) {
            this.esdlFileName = esdlFileName;
            this.representedArchetype = representedArchetype;
        }
    }

    public static void main(String[] args) throws Exception {
        var esdlFile = esdlDirectory.resolve(scenario.esdlFileName).normalize();
        logger.info("Scenario {}: reading {}", scenario, esdlFile.toAbsolutePath());

        EnergySystem esdl = ESDLReader.readResource(esdlFile.toAbsolutePath().toString());
        var energyModel = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, energyModel, scenario.representedArchetype);

        logger.info("Running the simulated year");
        energyModel.f_initializeEngine();
        energyModel.f_runRapidSimulation();

        Files.createDirectories(exportDirectory);
        var exporter = new ProfileExporter(energyModel);

        var exportHouse = findExportHouse(esdl, energyModel);
        exporter.writeElectricityProfiles(
                exportHouse,
                sheetNameOf(exportHouse),
                exportDirectory.resolve(exportFileName("woning"))
        );

        exporter.writeElectricityProfiles(
                energyModel,
                "Totaal van gebied",
                exportDirectory.resolve(exportFileName("totaal_gebied"))
        );

        exporter.writeHeatProfiles(
                exportHouse,
                sheetNameOf(exportHouse),
                exportDirectory.resolve(exportFileName("woning_warmte"))
        );
        exporter.writeHeatProfiles(
                energyModel,
                "Totaal van gebied",
                exportDirectory.resolve(exportFileName("totaal_gebied_warmte"))
        );

        logAggregatorChecks(energyModel);
        logger.info("Exports written to {}", exportDirectory.toAbsolutePath());
    }

    /**
     * The checks the ISIE aggregators keep on how well the houses followed their plans, summed
     * over all aggregators. They count the rapid run that just ended.
     */
    private static void logAggregatorChecks(EnergyModel energyModel) {
        var aggregators = findIsieAggregators(energyModel);
        if (aggregators.isEmpty()) {
            logger.info("No ISIE aggregators, so no aggregator checks to report");
            return;
        }
        logger.info(
                "EV departures below target: {} of {}; V2G timesteps below floor: {} of {}",
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunDeparturesBelowTarget),
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunDeparturesChecked),
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunTimeStepsBelowFloor),
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunTimeStepsCheckedAgainstFloor)
        );
        logger.info(
                "Heat: unmet in plans {} kWh; house timesteps with a changed setpoint {} of {}; comfort deficit {} K·h",
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunPlannedUnmetHeat_kWh),
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunHeatingTimeStepsWithChangedSetpoints),
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunHeatingTimeStepsChecked),
                sumOf(aggregators, J_ISIE_Aggregator_EMS::getLastRapidRunComfortDeficit_Kh)
        );
    }

    private static List<J_ISIE_Aggregator_EMS> findIsieAggregators(EnergyModel energyModel) {
        var aggregators = new ArrayList<J_ISIE_Aggregator_EMS>();
        for (var energyCoop : energyModel.pop_energyCoops) {
            if (energyCoop.f_getAggregatorEnergyManagement() instanceof J_ISIE_Aggregator_EMS aggregator) {
                aggregators.add(aggregator);
            }
        }
        return aggregators;
    }

    private static double sumOf(List<J_ISIE_Aggregator_EMS> aggregators, ToDoubleFunction<J_ISIE_Aggregator_EMS> counter) {
        return aggregators.stream().mapToDouble(counter).sum();
    }

    /**
     * A house is only interesting to export if it actually has assets on it, so the first house
     * carrying all of {@link #wantedHouseAssets} is exported.
     * <p>
     * Neither congestion file has one: they hold four batteries each and none of those sits on a
     * house that also has a heat pump and a charge point. So the house with the most of them is
     * taken instead, the first one in the order the ESDL lists them.
     */
    private static GridConnection findExportHouse(EnergySystem esdl, EnergyModel energyModel) {
        EConnection bestConnection = null;
        var bestAssets = List.<String>of();

        var iterator = esdl.eAllContents();
        while (iterator.hasNext()) {
            EObject eObject = iterator.next();
            if (!(eObject instanceof EConnection eConnection) || eConnection.getId() == null) {
                continue;
            }

            var assets = wantedAssetsOf(eConnection);
            if (assets.size() > bestAssets.size()) {
                bestConnection = eConnection;
                bestAssets = assets;
            }
            if (bestAssets.size() == wantedHouseAssets.size()) {
                break;
            }
        }

        if (bestConnection == null) {
            throw new IllegalStateException("No EConnection with an id found in the ESDL");
        }

        if (bestAssets.size() < wantedHouseAssets.size()) {
            logger.warn(
                    "No house has all of {}. Exporting {}, which has {}.",
                    wantedHouseAssets, nameOf(bestConnection), bestAssets
            );
        } else {
            logger.info("Exporting house {} with {}", nameOf(bestConnection), bestAssets);
        }

        var wantedId = bestConnection.getId();
        return CollectionUtil.findSingle(
                energyModel.c_gridConnections,
                gridConnection -> Objects.equals(gridConnection.p_gridConnectionID, wantedId)
        );
    }

    private static List<String> wantedAssetsOf(EConnection eConnection) {
        var building = eConnection.getContainingBuilding();
        if (building == null) {
            return List.of();
        }

        var present = new ArrayList<String>();
        for (Asset asset : building.getAsset()) {
            for (var wanted : wantedHouseAssets.entrySet()) {
                if (wanted.getValue().isInstance(asset) && !present.contains(wanted.getKey())) {
                    present.add(wanted.getKey());
                }
            }
        }
        return present;
    }

    private static String nameOf(EConnection eConnection) {
        var building = eConnection.getContainingBuilding();
        return building != null && building.getName() != null ? building.getName() : eConnection.getId();
    }

    /**
     * The name the results UI would give the sheet of a single grid connection.
     */
    private static String sheetNameOf(GridConnection gridConnection) {
        var address = gridConnection.p_address != null ? gridConnection.p_address.getAddress() : "";
        return gridConnection.p_ownerID + ", " + address;
    }

    private static String exportFileName(String scopeName) {
        return "Export_ModelData_" + scenario.name().toLowerCase() + "_" + scopeName + ".xlsx";
    }
}
