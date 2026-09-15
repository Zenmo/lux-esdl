package energy.lux.esdl.core.export;

import energy.lux.esdl.core.ESDLReader;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.iterator.RootIterator;
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
import zero_engine.EnergyModel;
import zero_engine.GridConnection;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    private static final Scenario defaultScenario = Scenario.TIME_OF_USE_TARIFF;

    /**
     * Edit {@link #defaultScenario} above, or pass -Pscenario=NAME to run one without editing.
     */
    private static final Scenario scenario = System.getProperty("scenario") == null
            || System.getProperty("scenario").isBlank()
            ? defaultScenario
            : Scenario.valueOf(System.getProperty("scenario"));

    private static final Path esdlDirectory = Path.of("..", "esdl-app", "data_ProjectTemplate");

    private static final Path exportDirectory = Path.of("build", "exports");

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
     * The two decorated_test_congestion files carry the same non-zero tariff and differ only in
     * the local dynamic measure, so neither of them can describe an area without any signal at
     * all. Only the newest generation of files states a tariff of zero, and it describes a
     * different area, so {@link #NO_CONGESTION_SIGNAL} is not directly comparable to the two
     * below it.
     */
    public enum Scenario {
        NO_CONGESTION_SIGNAL("decorated_corrected_BU31_veelflex_test_updated_tou0_nolocalcongestion.esdl"),
        TIME_OF_USE_TARIFF("decorated_test_congestion_false.esdl"),
        DYNAMIC_CONGESTION_TARIFF("decorated_test_congestion_true.esdl");

        private final String esdlFileName;

        Scenario(String esdlFileName) {
            this.esdlFileName = esdlFileName;
        }
    }

    public static void main(String[] args) throws Exception {
        var esdlFile = esdlDirectory.resolve(scenario.esdlFileName);
        logger.info("Scenario {}: reading {}", scenario, esdlFile.toAbsolutePath());

        EnergySystem esdl = ESDLReader.readResource(esdlFile.toAbsolutePath().toString());
        var luxLoader = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, luxLoader);

        var energyModel = luxLoader.energyModel;

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

        logger.info("Exports written to {}", exportDirectory.toAbsolutePath());
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
                energyModel.pop_gridConnections,
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
