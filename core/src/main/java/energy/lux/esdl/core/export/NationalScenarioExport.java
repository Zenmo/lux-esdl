package energy.lux.esdl.core.export;

import energy.lux.engine.EnergyModel;
import energy.lux.esdl.core.ESDLReader;
import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.LuxModelFactory;
import energy.lux.esdl.core.iterator.RootIterator;
import esdl.EnergySystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Run the ESDLs of a national scenario headlessly as a chain: the first plans on the day-ahead price, every next one on
 * the price the one before it left, see {@link PlannedPriceCurve}. Every ESDL stands for a small part of the country, so
 * on its own it hardly moves the price; without the chain all of them would move into the same cheap hours.
 * <p>
 * It is one pass: an ESDL does not react to those after it, so the first ones plan on a market that is emptier than it
 * ends up. The order is therefore shuffled, so that this does not favour a pocket or an archetype. The seed is fixed,
 * so a chain can be repeated.
 * <p>
 * A chain can follow on another one: it then starts from the end price of the last ESDL of that chain instead of from
 * the day-ahead price.
 * <p>
 * A chain that was stopped continues where it was: an ESDL whose price curve is there is not run again. Every curve has
 * to start where the one before it ended, otherwise the chain stops.
 */
public class NationalScenarioExport {
    private static final Logger logger = LoggerFactory.getLogger(NationalScenarioExport.class);

    private static final long orderSeed = 20261125L;

    public static void main(String[] args) throws Exception {
        var scenarioKey = System.getProperty("scenarioKey", "");
        if (scenarioKey.isBlank()) {
            throw new IllegalArgumentException("Pass the scenario to run, as -PscenarioKey=km_hoog_tou");
        }
        var directory = Path.of(System.getProperty("lux.nationalScenarioDirectory", "../ISIE/Scenarios/National Scenario"));
        var output = System.getProperty("chainOutput", "");
        var outputDirectory = output.isBlank() ? directory.resolve("lux_results").resolve(scenarioKey) : Path.of(output);

        var chain = chainOrder(findEsdls(directory, scenarioKey, parsePockets(System.getProperty("pockets", ""))));
        logger.info("Chain of {} ESDLs of {}, results in {}", chain.size(), scenarioKey, outputDirectory.toAbsolutePath());

        double[] startPrice_eurpMWh = null;
        var previousCurve = System.getProperty("followOn", "");
        if (!previousCurve.isBlank()) {
            startPrice_eurpMWh = PlannedPriceCurve.read(Path.of(previousCurve)).end_eurpMWh();
            logger.info("The chain starts from the end price of {}", previousCurve);
        }
        runChain(chain, startPrice_eurpMWh, outputDirectory, NationalScenarioExport::runEsdl);
    }

    /** Runs one ESDL on a start price, null for its own day-ahead price, and exports its results. */
    @FunctionalInterface
    interface EsdlRun {
        PlannedPriceCurve run(NationalScenarioEsdl esdl, double[] startPrice_eurpMWh, Path outputDirectory) throws Exception;
    }

    /**
     * @param startPrice_eurpMWh what the first ESDL plans on, null for its own day-ahead price
     */
    static void runChain(
            List<NationalScenarioEsdl> chain,
            double[] startPrice_eurpMWh,
            Path outputDirectory,
            EsdlRun esdlRun
    ) throws Exception {
        keepOrder(chain, outputDirectory.resolve("order.csv"));
        double[] price_eurpMWh = startPrice_eurpMWh;
        for (int i = 0; i < chain.size(); i++) {
            var esdl = chain.get(i);
            var curveFile = curveFile(outputDirectory, esdl);
            var alreadyRun = Files.exists(curveFile);
            logger.info("{} of {}: {}{}", i + 1, chain.size(), esdl.name(), alreadyRun ? " was already run" : "");
            // A run writes its price curve last, so a curve means that the exports are there too.
            var curve = alreadyRun ? PlannedPriceCurve.read(curveFile) : esdlRun.run(esdl, price_eurpMWh, outputDirectory);
            assertStartsFrom(price_eurpMWh, curve, curveFile);
            price_eurpMWh = curve.end_eurpMWh();
        }
        logger.info("Chain done, its price is the end price of {}", chain.get(chain.size() - 1).name());
    }

    private static Path curveFile(Path outputDirectory, NationalScenarioEsdl esdl) {
        return outputDirectory.resolve("prices").resolve(esdl.name() + ".csv");
    }

    private static void assertStartsFrom(double[] price_eurpMWh, PlannedPriceCurve curve, Path curveFile) {
        if (price_eurpMWh != null && !Arrays.equals(price_eurpMWh, curve.start_eurpMWh())) {
            throw new EsdlException(
                    "The start price of " + curveFile + " is not the end price of the ESDL before it."
                            + " Delete it and the curves after it, in the order of order.csv, to run those ESDLs again."
            );
        }
    }

    private static PlannedPriceCurve runEsdl(NationalScenarioEsdl scenarioEsdl, double[] startPrice_eurpMWh, Path outputDirectory)
            throws IOException {
        EnergySystem esdl = ESDLReader.readResource(scenarioEsdl.file().toAbsolutePath().toString());
        EnergyModel energyModel = LuxModelFactory.createEnergyModel();
        RootIterator.loadEsdlIntoLux(esdl, energyModel, scenarioEsdl.representedArchetype(), startPrice_eurpMWh);

        energyModel.f_initializeEngine();
        energyModel.f_runRapidSimulation();

        var curve = PlannedPriceCurve.of(energyModel);
        var curveFile = curveFile(outputDirectory, scenarioEsdl);
        assertStartsFrom(startPrice_eurpMWh, curve, curveFile);
        ScenarioExport.exportResults(esdl, energyModel, scenarioEsdl.name(), outputDirectory);
        var timeParameters = energyModel.p_timeParameters;
        curve.write(curveFile, timeParameters.getStartYear(), timeParameters.getTimeStep_h());
        return curve;
    }

    /** The ESDLs of the scenario, of all pockets when none are given. */
    static List<NationalScenarioEsdl> findEsdls(Path directory, String scenarioKey, Set<Integer> pockets) throws IOException {
        List<NationalScenarioEsdl> esdls;
        try (Stream<Path> files = Files.walk(directory, 3)) {
            esdls = files.filter(NationalScenarioEsdl::isNamedAsOne)
                    .map(NationalScenarioEsdl::of)
                    .filter(esdl -> esdl.scenarioKey().equals(scenarioKey))
                    .filter(esdl -> pockets.isEmpty() || pockets.contains(esdl.pocket()))
                    .toList();
        }
        if (esdls.isEmpty()) {
            throw new EsdlException("No ESDLs of " + scenarioKey + " in " + directory.toAbsolutePath());
        }
        return esdls;
    }

    static List<NationalScenarioEsdl> chainOrder(List<NationalScenarioEsdl> esdls) {
        var chain = new ArrayList<>(esdls);
        // Sorted first, so that the order does not depend on how the file system lists the files.
        chain.sort(Comparator.comparingInt(NationalScenarioEsdl::pocket).thenComparingInt(NationalScenarioEsdl::archetype));
        Collections.shuffle(chain, new Random(orderSeed));
        return chain;
    }

    // The results of one chain belong together, so the folder of another chain is refused.
    private static void keepOrder(List<NationalScenarioEsdl> chain, Path orderFile) throws IOException {
        var lines = new ArrayList<String>();
        lines.add("position,esdl");
        for (int i = 0; i < chain.size(); i++) {
            lines.add((i + 1) + "," + chain.get(i).name());
        }
        if (Files.exists(orderFile) && !Files.readAllLines(orderFile).equals(lines)) {
            throw new EsdlException(orderFile + " belongs to a chain of other ESDLs or another order. Use another output folder.");
        }
        Files.createDirectories(orderFile.getParent());
        Files.write(orderFile, lines);
    }

    static Set<Integer> parsePockets(String pockets) {
        return Arrays.stream(pockets.split(","))
                .map(String::trim)
                .filter(pocket -> !pocket.isEmpty())
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }
}
