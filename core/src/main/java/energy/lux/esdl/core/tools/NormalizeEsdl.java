package energy.lux.esdl.core.tools;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.NotImplemented;
import energy.lux.esdl.core.loader.ElectricityDemandLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Turns the electricity demand profiles of an ESDL into the shape the ESDL loader reads.
 * <p>
 * The loader expects a demand that states its yearly total in its name, like "Total: 3958.0 kwh", to hold a
 * profile that integrates to 1 over the year. That lets the engine keep one shape and scale it by the total.
 * Some generators write the demand itself instead: the same name, but a profile in kW. This divides such a
 * profile by its yearly energy, and drops the unit because a shape has none.
 * <p>
 * Demands that are already normalized, or that state no total, are left as they are.
 * <p>
 * The file is edited as text and only those profiles change. Reading it as an EMF resource and saving it again
 * would write every value as an element of its own and rewrite everything else along the way.
 * <p>
 * Usage: {@code NormalizeEsdl <input.esdl> <output.esdl>}, or the Gradle task {@code normalizeEsdl}.
 */
public class NormalizeEsdl {
    private static final Logger logger = LoggerFactory.getLogger(NormalizeEsdl.class);

    private static final double secondsPerHour = 3600.0;

    /**
     * A profile that integrates to this close to 1 is taken as normalized already.
     * The same tolerance as the loader uses to accept one.
     */
    private static final double alreadyNormalizedTolerance = 0.01;

    /**
     * How far the yearly energy of the profile may be from the total in the name. The generators round to
     * about nine digits, so anything above this is a profile that does not belong to its name.
     */
    private static final double statedTotalTolerance = 1e-6;

    private static final Pattern electricityDemand = Pattern.compile(
            "(<asset xsi:type=\"esdl:ElectricityDemand\"[^>]*>)(.*?)(</asset>)",
            Pattern.DOTALL
    );

    private static final Pattern nameAttribute = Pattern.compile("\\sname=\"([^\"]*)\"");

    /**
     * A time series profile with its values as an attribute, closed either at once or after its unit.
     */
    private static final Pattern timeSeriesProfile = Pattern.compile(
            "<profile xsi:type=\"esdl:TimeSeriesProfile\"([^>]*?)\\svalues=\"([^\"]*)\"([^>]*?)"
                    + "(?:/>|>\\s*(?:<profileQuantityAndUnit[^>]*/>\\s*)?</profile>)",
            Pattern.DOTALL
    );

    private static final Pattern timestepAttribute = Pattern.compile("\\stimestep=\"(\\d+)\"");

    /**
     * @param esdl            the ESDL with the profiles normalized
     * @param normalizedCount the number of profiles that were changed
     */
    public record Result(String esdl, int normalizedCount) {}

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Usage: NormalizeEsdl <input.esdl> <output.esdl>");
        }

        var inputFile = Path.of(args[0]);
        var outputFile = Path.of(args[1]);

        logger.info("Reading {}", inputFile.toAbsolutePath());
        var result = normalizeElectricityDemands(Files.readString(inputFile, StandardCharsets.UTF_8));

        Files.writeString(outputFile, result.esdl(), StandardCharsets.UTF_8);
        logger.info(
                "Normalized {} electricity demand profile(s), written to {}",
                result.normalizedCount(),
                outputFile.toAbsolutePath()
        );
    }

    public static Result normalizeElectricityDemands(String esdl) {
        var matcher = electricityDemand.matcher(esdl);
        var output = new StringBuilder(esdl.length());
        var normalizedCount = 0;

        while (matcher.find()) {
            var normalizedBody = normalizeDemand(matcher.group(1), matcher.group(2));
            if (normalizedBody != null) {
                normalizedCount++;
            }
            matcher.appendReplacement(
                    output,
                    Matcher.quoteReplacement(matcher.group(1) + (normalizedBody != null ? normalizedBody : matcher.group(2)) + matcher.group(3))
            );
        }
        matcher.appendTail(output);

        return new Result(output.toString(), normalizedCount);
    }

    /**
     * @return the body of the demand with its profile normalized, or null when it is to be left as it is
     */
    private static String normalizeDemand(String openingTag, String body) {
        var statedTotal_kWh = findStatedTotal(openingTag);
        if (statedTotal_kWh == null || !body.contains("esdl:TimeSeriesProfile")) {
            return null;
        }

        var profile = timeSeriesProfile.matcher(body);
        if (!profile.find()) {
            throw new NotImplemented("A time series profile of this layout cannot be normalized: " + openingTag);
        }

        var attributes = profile.group(1) + profile.group(3);
        var values = parseValues(profile.group(2));
        var yearlyEnergy_kWh = integrate(values, readTimestepSeconds(attributes, openingTag) / secondsPerHour);
        if (Math.abs(yearlyEnergy_kWh - 1.0) <= alreadyNormalizedTolerance) {
            return null;
        }
        assertMatchesStatedTotal(openingTag, yearlyEnergy_kWh, statedTotal_kWh);

        var normalizedProfile = "<profile xsi:type=\"esdl:TimeSeriesProfile\"" + profile.group(1)
                + " values=\"" + formatValues(values, yearlyEnergy_kWh) + "\"" + profile.group(3) + "/>";
        return body.substring(0, profile.start()) + normalizedProfile + body.substring(profile.end());
    }

    private static Double findStatedTotal(String openingTag) {
        var name = nameAttribute.matcher(openingTag);
        return name.find() ? ElectricityDemandLoader.parseAnnualDemandKwh(name.group(1)) : null;
    }

    private static double[] parseValues(String values) {
        return Arrays.stream(values.trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
    }

    private static int readTimestepSeconds(String attributes, String openingTag) {
        var timestep = timestepAttribute.matcher(attributes);
        if (!timestep.find()) {
            throw new EsdlException("The profile of " + openingTag + " has no timestep");
        }
        return Integer.parseInt(timestep.group(1));
    }

    private static double integrate(double[] values, double stepHours) {
        var integral = 0.0;
        for (double value : values) {
            integral += value * stepHours;
        }
        return integral;
    }

    private static void assertMatchesStatedTotal(String openingTag, double yearlyEnergy_kWh, double statedTotal_kWh) {
        if (Math.abs(yearlyEnergy_kWh - statedTotal_kWh) > statedTotalTolerance * statedTotal_kWh) {
            throw new EsdlException(String.format(
                    "%s states a yearly total in its name, but its profile holds %s kWh",
                    openingTag,
                    yearlyEnergy_kWh
            ));
        }
    }

    private static String formatValues(double[] values, double yearlyEnergy_kWh) {
        var formatted = new StringBuilder(values.length * 22);
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                formatted.append(' ');
            }
            formatted.append(values[i] / yearlyEnergy_kWh);
        }
        return formatted.toString();
    }
}
