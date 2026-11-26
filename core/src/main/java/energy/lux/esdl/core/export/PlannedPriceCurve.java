package energy.lux.esdl.core.export;

import energy.lux.engine.EnergyModel;
import energy.lux.engine.dataclasses.J_PriceCurves;
import energy.lux.engine.dataclasses.J_PriceCurves.Stage;
import energy.lux.esdl.core.EsdlException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static energy.lux.esdl.core.util.DateTimeUtil.luxTimeZone;

/**
 * The price an aggregator planned on over a run, one value per timestep: the price it started from, and what the market
 * feedback of each kind of asset made of it. It holds no congestion term, no taxes and no time of use tariff, which
 * belong to one neighbourhood or house and not to the market.
 * <p>
 * The end price is what the next ESDL of a chain starts from, see {@link NationalScenarioExport}.
 */
record PlannedPriceCurve(
        double[] start_eurpMWh,
        double[] afterHeatPumps_eurpMWh,
        double[] afterEvs_eurpMWh,
        double[] end_eurpMWh
) {
    private static final String header =
            "timestamp,start_eurpMWh,after_heat_pumps_eurpMWh,after_evs_eurpMWh,end_eurpMWh";

    private static final DateTimeFormatter timestampFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmXXX");

    /**
     * The curve of the rapid run that just ended.
     */
    static PlannedPriceCurve of(EnergyModel energyModel) {
        var aggregators = ScenarioExport.findIsieAggregators(energyModel);
        // Each aggregator starts from the same price and knows only its own feedback, so several leave no one end price.
        if (aggregators.size() != 1) {
            throw new EsdlException("Expected one ISIE aggregator to take the price curve from, found " + aggregators.size());
        }
        var curves = aggregators.get(0).getLastRapidRunPriceCurves();
        return new PlannedPriceCurve(
                curveOf(curves, Stage.DAY_AHEAD),
                curveOf(curves, Stage.AFTER_HEAT_PUMPS),
                curveOf(curves, Stage.AFTER_EVS),
                curveOf(curves, Stage.AFTER_BATTERIES)
        );
    }

    private static double[] curveOf(J_PriceCurves curves, Stage stage) {
        var curve = curves == null ? null : curves.getCurve_eurpMWh(stage);
        if (curve == null) {
            throw new EsdlException("The aggregator kept no price curve " + stage);
        }
        for (int i = 0; i < curve.length; i++) {
            if (!Double.isFinite(curve[i])) {
                throw new EsdlException("The price curve " + stage + " has no value in timestep " + i);
            }
        }
        return curve;
    }

    /**
     * The values are written in full, so that reading them back gives the same curve. The file only gets its name once
     * it is complete.
     */
    void write(Path destination, int startYear, double timeStep_h) throws IOException {
        var start = ZonedDateTime.of(startYear, 1, 1, 0, 0, 0, 0, luxTimeZone);
        var lines = new ArrayList<String>();
        lines.add(header);
        for (int i = 0; i < start_eurpMWh.length; i++) {
            var timestamp = start.plus(Duration.ofSeconds(Math.round(i * timeStep_h * 3600)));
            lines.add(timestamp.format(timestampFormat)
                    + "," + start_eurpMWh[i]
                    + "," + afterHeatPumps_eurpMWh[i]
                    + "," + afterEvs_eurpMWh[i]
                    + "," + end_eurpMWh[i]);
        }
        Files.createDirectories(destination.getParent());
        var partial = destination.resolveSibling(destination.getFileName() + ".part");
        Files.write(partial, lines);
        Files.move(partial, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    static PlannedPriceCurve read(Path file) throws IOException {
        var lines = Files.readAllLines(file);
        if (lines.isEmpty() || !lines.get(0).equals(header)) {
            throw new EsdlException(file + " should start with " + header);
        }
        var rows = lines.subList(1, lines.size()).stream().map(line -> line.split(",")).toList();
        return new PlannedPriceCurve(column(rows, 1), column(rows, 2), column(rows, 3), column(rows, 4));
    }

    private static double[] column(List<String[]> rows, int column) {
        return rows.stream().mapToDouble(row -> Double.parseDouble(row[column])).toArray();
    }
}
