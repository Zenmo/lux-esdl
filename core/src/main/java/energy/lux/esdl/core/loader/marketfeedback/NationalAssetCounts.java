package energy.lux.esdl.core.loader.marketfeedback;

import energy.lux.esdl.core.EsdlException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * How many households and flex assets the whole country has in one archetype, whatever their contract. One row of
 * national_asset_counts.csv, which generate_national_asset_counts.py makes from ISIE/Pockets_to_archetypes.
 * The counts are fractional: the archetype data divides national totals over pockets and archetypes.
 */
public record NationalAssetCounts(
        double households,
        double heatPumps,
        double hybridHeatPumps,
        double evs,
        double v2gEvs,
        double batteries
) {
    private static final String tableResource = "/marketfeedback/national_asset_counts.csv";
    private static final String expectedHeader =
            "stock_family,sub_archetype,households,heat_pumps,hybrid_heat_pumps,evs,v2g_evs,batteries";

    public static NationalAssetCounts of(RepresentedArchetype archetype) {
        for (String row : readRows()) {
            String[] cells = row.split(",");
            if (cells[0].equals(archetype.stockFamily()) && cells[1].equals(archetype.subArchetype())) {
                return parseCounts(cells);
            }
        }
        throw new EsdlException(String.format(
                "%s has no row for stock family %s and sub-archetype %s",
                tableResource,
                archetype.stockFamily(),
                archetype.subArchetype()
        ));
    }

    private static NationalAssetCounts parseCounts(String[] cells) {
        return new NationalAssetCounts(
                Double.parseDouble(cells[2]),
                Double.parseDouble(cells[3]),
                Double.parseDouble(cells[4]),
                Double.parseDouble(cells[5]),
                Double.parseDouble(cells[6]),
                Double.parseDouble(cells[7])
        );
    }

    // The rows after the header, which is checked so a regenerated table with other columns is not misread.
    private static List<String> readRows() {
        List<String> lines = readLines();
        if (lines.isEmpty() || !lines.get(0).equals(expectedHeader)) {
            throw new EsdlException(String.format(
                    "%s should start with %s, but starts with %s",
                    tableResource,
                    expectedHeader,
                    lines.isEmpty() ? "nothing" : lines.get(0)
            ));
        }
        return lines.subList(1, lines.size());
    }

    private static List<String> readLines() {
        try (InputStream table = NationalAssetCounts.class.getResourceAsStream(tableResource)) {
            if (table == null) {
                throw new EsdlException("Resource " + tableResource + " not found");
            }
            var reader = new BufferedReader(new InputStreamReader(table, StandardCharsets.UTF_8));
            return reader.lines().filter(line -> !line.isBlank()).toList();
        } catch (IOException exception) {
            throw new EsdlException("Could not read " + tableResource, exception);
        }
    }
}
