package energy.lux.esdl.core.export;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.loader.marketfeedback.RepresentedArchetype;

import java.nio.file.Path;
import java.util.regex.Pattern;

/**
 * One ESDL of a national scenario: an archetype without district heating in a pocket. Its file name states all three,
 * as ISIE/Scenarios/National Scenario/generate_pockets.py writes it: pocket1_km_hoog_tou_arch1.esdl.
 */
record NationalScenarioEsdl(Path file, int pocket, String scenarioKey, int archetype) {
    private static final Pattern fileNamePattern = Pattern.compile("pocket(\\d+)_(.+)_arch(\\d+)\\.esdl");
    // The stock family, the adoption level and the price signal, see Scenario's totaal in scenarios-flex-assets.xlsx.
    private static final Pattern scenarioKeyPattern = Pattern.compile("(.+)_(laag|hoog)_(.+)");

    static boolean isNamedAsOne(Path file) {
        return fileNamePattern.matcher(file.getFileName().toString()).matches();
    }

    static NationalScenarioEsdl of(Path file) {
        var matcher = fileNamePattern.matcher(file.getFileName().toString());
        if (!matcher.matches()) {
            throw new EsdlException(file + " is not named pocket<n>_<scenario key>_arch<a>.esdl");
        }
        return new NationalScenarioEsdl(
                file,
                Integer.parseInt(matcher.group(1)),
                matcher.group(2),
                Integer.parseInt(matcher.group(3))
        );
    }

    String name() {
        return "pocket" + pocket + "_" + scenarioKey + "_arch" + archetype;
    }

    RepresentedArchetype representedArchetype() {
        var matcher = scenarioKeyPattern.matcher(scenarioKey);
        if (!matcher.matches()) {
            throw new EsdlException("Scenario key " + scenarioKey + " names no adoption level");
        }
        // adoptieniveau_prijsprikkels of the scenarios.
        double dynamicContractShare = matcher.group(2).equals("laag") ? 0.3 : 0.8;
        return new RepresentedArchetype(matcher.group(1), pocket, archetype + "woDH", dynamicContractShare);
    }
}
