package energy.lux.esdl.core.export;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.loader.marketfeedback.RepresentedArchetype;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NationalScenarioExportTest {
    @TempDir
    Path directory;

    private final List<String> runs = new ArrayList<>();

    // Stands in for LUX: the day-ahead price is 100.1, and every ESDL raises the price by a third.
    private PlannedPriceCurve fakeRun(NationalScenarioEsdl esdl, double[] startPrice_eurpMWh, Path output) throws Exception {
        runs.add(esdl.name());
        double[] start = startPrice_eurpMWh == null ? new double[]{100.1} : startPrice_eurpMWh;
        var curve = new PlannedPriceCurve(start, start, start, new double[]{start[0] + 1.0 / 3.0});
        curve.write(curveFile(output, esdl), 2050, 0.25);
        return curve;
    }

    private static Path curveFile(Path output, NationalScenarioEsdl esdl) {
        return output.resolve("prices").resolve(esdl.name() + ".csv");
    }

    private static NationalScenarioEsdl esdl(int pocket, int archetype) {
        return NationalScenarioEsdl.of(Path.of("pocket" + pocket + "_km_hoog_tou_arch" + archetype + ".esdl"));
    }

    private static final List<NationalScenarioEsdl> chain = List.of(esdl(1, 2), esdl(1, 1), esdl(2, 1));

    @Test
    public void theFileNameStatesWhatTheEsdlStandsFor() {
        assertThat(esdl(16, 3).representedArchetype()).isEqualTo(new RepresentedArchetype("km", 16, "3woDH", 0.8));
        assertThat(NationalScenarioEsdl.of(Path.of("pocket2_meerflex_minElek_laag_dyn_lokaal_arch8.esdl")).representedArchetype())
                .isEqualTo(new RepresentedArchetype("meerflex_minElek", 2, "8woDH", 0.3));
    }

    @Test
    public void everyEsdlStartsFromThePriceTheOneBeforeItLeft() throws Exception {
        NationalScenarioExport.runChain(chain, null, directory, this::fakeRun);

        assertThat(runs).containsExactly("pocket1_km_hoog_tou_arch2", "pocket1_km_hoog_tou_arch1", "pocket2_km_hoog_tou_arch1");
        var first = PlannedPriceCurve.read(curveFile(directory, chain.get(0)));
        var second = PlannedPriceCurve.read(curveFile(directory, chain.get(1)));
        assertThat(first.start_eurpMWh()).containsExactly(100.1);
        assertThat(second.start_eurpMWh()).containsExactly(first.end_eurpMWh());
    }

    @Test
    public void aChainCanStartFromThePriceThatAnotherOneLeft() throws Exception {
        NationalScenarioExport.runChain(chain, new double[]{50}, directory, this::fakeRun);

        assertThat(PlannedPriceCurve.read(curveFile(directory, chain.get(0))).start_eurpMWh()).containsExactly(50);
    }

    @Test
    public void aChainIsNotContinuedFromAnotherStartPrice() throws Exception {
        NationalScenarioExport.runChain(chain, new double[]{50}, directory, this::fakeRun);

        assertThatThrownBy(() -> NationalScenarioExport.runChain(chain, new double[]{51}, directory, this::fakeRun))
                .isInstanceOf(EsdlException.class)
                .hasMessageContaining("pocket1_km_hoog_tou_arch2.csv");
    }

    @Test
    public void aStoppedChainContinuesWhereItWas() throws Exception {
        NationalScenarioExport.runChain(chain, null, directory, this::fakeRun);
        Files.delete(curveFile(directory, chain.get(2)));
        runs.clear();

        NationalScenarioExport.runChain(chain, null, directory, this::fakeRun);

        assertThat(runs).containsExactly("pocket2_km_hoog_tou_arch1");
    }

    // For example when an ESDL in the middle of the chain was changed and run again.
    @Test
    public void aCurveThatDoesNotStartWhereTheOneBeforeItEndedIsRefused() throws Exception {
        NationalScenarioExport.runChain(chain, null, directory, this::fakeRun);
        new PlannedPriceCurve(new double[]{100.1}, new double[]{100.1}, new double[]{100.1}, new double[]{105})
                .write(curveFile(directory, chain.get(0)), 2050, 0.25);

        assertThatThrownBy(() -> NationalScenarioExport.runChain(chain, null, directory, this::fakeRun))
                .isInstanceOf(EsdlException.class)
                .hasMessageContaining("pocket1_km_hoog_tou_arch1.csv");
    }

    @Test
    public void theFolderOfAnotherChainIsRefused() throws Exception {
        NationalScenarioExport.runChain(chain, null, directory, this::fakeRun);

        assertThatThrownBy(() -> NationalScenarioExport.runChain(chain.subList(0, 2), null, directory, this::fakeRun))
                .isInstanceOf(EsdlException.class)
                .hasMessageContaining("order.csv");
    }

    @Test
    public void theOrderDoesNotDependOnHowTheFilesAreListed() {
        var reversed = new ArrayList<>(chain);
        Collections.reverse(reversed);

        assertThat(NationalScenarioExport.chainOrder(reversed)).isEqualTo(NationalScenarioExport.chainOrder(chain));
    }

    @Test
    public void findsTheEsdlsOfTheScenarioAndPockets() throws Exception {
        var scenarioDirectory = Files.createDirectories(directory.resolve("pocket_1/km_hoog_tou"));
        Files.createFile(scenarioDirectory.resolve("pocket1_km_hoog_tou_arch1.esdl"));
        Files.createFile(scenarioDirectory.resolve("arch1.json"));
        Files.createFile(Files.createDirectories(directory.resolve("pocket_2/km_hoog_tou")).resolve("pocket2_km_hoog_tou_arch1.esdl"));
        Files.createFile(Files.createDirectories(directory.resolve("pocket_1/km_laag_tou")).resolve("pocket1_km_laag_tou_arch1.esdl"));

        assertThat(NationalScenarioExport.findEsdls(directory, "km_hoog_tou", Set.of())).hasSize(2);
        assertThat(NationalScenarioExport.findEsdls(directory, "km_hoog_tou", Set.of(1)))
                .extracting(NationalScenarioEsdl::name)
                .containsExactly("pocket1_km_hoog_tou_arch1");
    }

    // Written in full, also values that have no short decimal form: the chain compares them exactly.
    @Test
    public void aPriceCurveReadBackIsTheSame() throws Exception {
        var curve = new PlannedPriceCurve(new double[]{1.0 / 3.0, -500}, new double[]{1, 2}, new double[]{3, 4}, new double[]{Math.PI, 1e-7});
        var file = directory.resolve("prices/curve.csv");
        curve.write(file, 2050, 0.25);

        var read = PlannedPriceCurve.read(file);

        assertThat(read.start_eurpMWh()).containsExactly(curve.start_eurpMWh());
        assertThat(read.end_eurpMWh()).containsExactly(curve.end_eurpMWh());
        assertThat(Files.readAllLines(file).get(2)).startsWith("2050-01-01T00:15+01:00,-500.0,");
    }
}
