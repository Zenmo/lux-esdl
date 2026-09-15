package energy.lux.esdl.core.loader.pv;

import energy.lux.esdl.core.EsdlException;
import energy.lux.esdl.core.loader.profile.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static energy.lux.esdl.core.util.DateTimeUtil.durationToHours;

/**
 * Turns the irradiance of the ESDL into one normalized production profile per PV orientation,
 * by running pvlib.
 * pvlib is a Python package with no Java equivalent, so it runs as a separate process. Starting
 * an interpreter and importing pvlib costs seconds while modelling one more orientation costs
 * a fraction of one, so every orientation in the file is sent in a single request.
 */
public class PvlibProfileGenerator {
    private static final Logger logger = LoggerFactory.getLogger(PvlibProfileGenerator.class);

    private static final String pythonExecutableProperty = "lux.pythonExecutable";
    private static final String defaultPythonExecutable = "python";
    private static final String scriptResource = "/pv/generate_pv_profiles.py";
    private static final Duration generatorTimeout = Duration.ofMinutes(3);
    private static final double fallbackAmbientTemperature_degC = 20.0;
    private static final double windSpeedMPerS = 1.0;
    private final PVSite site;

    public PvlibProfileGenerator(PVSite site) {
        this.site = site;
    }

    /**
     * Weather contains the irradiance data to model the production from,
     * and the outside temperature the cells warm up from
     * Returns one profile per requested orientation, normalized to a fraction of installed power,
     * on the same time axis as the irradiance data.
     */
    public Map<PVOrientation, double[]> generateProfiles(
            Weather weather,
            Collection<PVOrientation> orientations
    ) {
        if (orientations.isEmpty()) {
            return Map.of();
        }

        Path workingDirectory = createWorkingDirectory();
        try {
            var requestFile = workingDirectory.resolve("request.txt");
            var responseFile = workingDirectory.resolve("response.txt");
            var scriptFile = copyScriptTo(workingDirectory);

            writeRequest(requestFile, weather, orientations);

            logger.info("Generating {} PV profile(s) with pvlib at {}", orientations.size(), site);
            runGenerator(scriptFile, requestFile, responseFile);

            var profiles = readResponse(responseFile);
            assertEveryOrientationWasGenerated(orientations, profiles);
            return profiles;
        } finally {
            deleteRecursively(workingDirectory);
        }
    }

    private Path createWorkingDirectory() {
        try {
            return Files.createTempDirectory("lux-pv-profiles");
        } catch (IOException e) {
            throw new EsdlException("Could not create a directory to generate PV profiles in", e);
        }
    }

    /**
     * The script travels inside the jar, so it has to be on the file system
     * before an interpreter can run it.
     */
    private Path copyScriptTo(Path workingDirectory) {
        var scriptFile = workingDirectory.resolve("generate_pv_profiles.py");
        try (InputStream script = PvlibProfileGenerator.class.getResourceAsStream(scriptResource)) {
            if (script == null) {
                throw new EsdlException("PV profile generator script is missing from the jar at " + scriptResource);
            }
            Files.copy(script, scriptFile);
        } catch (IOException e) {
            throw new EsdlException("Could not unpack the PV profile generator script", e);
        }
        return scriptFile;
    }

    private void writeRequest(
            Path requestFile,
            Weather weather,
            Collection<PVOrientation> orientations
    ) {
        var globalHorizontalIrradiance_wpm2 = weather.globalHorizontalIrradiance_wpm2();
        var values = globalHorizontalIrradiance_wpm2.copyValuesArray();
        var stepSeconds = (long) (durationToHours(globalHorizontalIrradiance_wpm2.getStep()) * 3600);

        try (BufferedWriter writer = Files.newBufferedWriter(requestFile, StandardCharsets.UTF_8)) {
            writer.write("latitude " + site.latitudeDegrees() + "\n");
            writer.write("longitude " + site.longitudeDegrees() + "\n");
            writer.write("time_zone " + site.timeZone() + "\n");
            writer.write("start " + globalHorizontalIrradiance_wpm2.getStart() + "\n");
            writer.write("step_seconds " + stepSeconds + "\n");
            writer.write("wind_speed_m_per_s " + windSpeedMPerS + "\n");

            var keys = orientations.stream().map(PVOrientation::toKey).toList();
            writer.write("orientations " + String.join(" ", keys) + "\n");

            writeAmbientTemperature(writer, weather);
            writeValues(writer, "global_horizontal_irradiance_w_per_m2", values);
        } catch (IOException e) {
            throw new EsdlException("Could not write the PV profile generator request", e);
        }
    }

    /**
     * A temperature for every moment when the ESDL states one, a single fixed temperature when
     * it does not. The generator reads whichever of the two it is handed.
     */
    private void writeAmbientTemperature(
            BufferedWriter writer,
            Weather weather
    ) throws IOException {
        var outsideTemperature_degC = weather.outsideTemperature_degC();
        if (outsideTemperature_degC == null) {
            logger.warn(
                    "The ESDL states no outside temperature, modelling the PV cells at a fixed {} degrees C",
                    fallbackAmbientTemperature_degC
            );
            writer.write("ambient_temperature_deg_c " + fallbackAmbientTemperature_degC + "\n");
            return;
        }

        writeValues(writer, "ambient_temperature_deg_c", outsideTemperature_degC.copyValuesArray());
    }

    private void writeValues(BufferedWriter writer, String name, double[] values) throws IOException {
        writer.write("values " + name + " " + values.length + "\n");
        for (double value : values) {
            writer.write(Double.toString(value));
            writer.write("\n");
        }
    }

    private void runGenerator(Path scriptFile, Path requestFile, Path responseFile) {
        var pythonExecutable = System.getProperty(pythonExecutableProperty, defaultPythonExecutable);

        var processBuilder = new ProcessBuilder(
                pythonExecutable,
                scriptFile.toString(),
                requestFile.toString(),
                responseFile.toString()
        );
        processBuilder.redirectErrorStream(true);

        Process process;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            throw new EsdlException(
                    "Could not start " + pythonExecutable + " to generate PV profiles."
                            + " Set -D" + pythonExecutableProperty
                            + " to an interpreter that has pvlib installed.",
                    e
            );
        }

        var output = readProcessOutput(process);
        waitForGenerator(process, pythonExecutable, output);
    }

    /**
     * Reading the output to its end is also what keeps the generator from blocking on a full
     * pipe buffer while it reports progress.
     */
    private String readProcessOutput(Process process) {
        try (var reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))
        ) {
            var output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("pvlib: {}", line);
                output.append(line).append("\n");
            }
            return output.toString();
        } catch (IOException e) {
            throw new EsdlException("Could not read the output of the PV profile generator", e);
        }
    }

    private void waitForGenerator(Process process, String pythonExecutable, String output) {
        boolean finished;
        try {
            finished = process.waitFor(generatorTimeout.toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            process.destroy();
            Thread.currentThread().interrupt();
            throw new EsdlException("Interrupted while generating PV profiles", e);
        }

        if (!finished) {
            process.destroy();
            throw new EsdlException(
                    "Generating PV profiles took longer than " + generatorTimeout.toMinutes() + " minutes"
            );
        }

        if (process.exitValue() != 0) {
            throw new EsdlException(
                    pythonExecutable + " failed to generate PV profiles, it exited with "
                            + process.exitValue() + " and said:\n" + output
            );
        }
    }

    /**
     * The first line names the orientations, in the order their values appear on every
     * following line. One line holds one moment in time.
     */
    private Map<PVOrientation, double[]> readResponse(Path responseFile) {
        List<String> lines;
        try {
            lines = Files.readAllLines(responseFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new EsdlException("Could not read the generated PV profiles", e);
        }

        if (lines.isEmpty()) {
            throw new EsdlException("The PV profile generator produced an empty response");
        }

        var keys = lines.get(0).trim().split(" ");
        var numberOfSteps = lines.size() - 1;

        var valuesByColumn = new double[keys.length][numberOfSteps];
        for (int step = 0; step < numberOfSteps; step++) {
            var fields = lines.get(step + 1).trim().split(" ");
            if (fields.length != keys.length) {
                throw new EsdlException(
                        "The PV profile generator returned " + fields.length + " value(s) for step "
                                + step + " while it named " + keys.length + " orientation(s)"
                );
            }
            for (int column = 0; column < keys.length; column++) {
                valuesByColumn[column][step] = Double.parseDouble(fields[column]);
            }
        }

        var profiles = new LinkedHashMap<PVOrientation, double[]>();
        for (int column = 0; column < keys.length; column++) {
            profiles.put(PVOrientation.fromKey(keys[column]), valuesByColumn[column]);
        }
        return profiles;
    }

    private void assertEveryOrientationWasGenerated(
            Collection<PVOrientation> requested,
            Map<PVOrientation, double[]> generated
    ) {
        for (PVOrientation orientation : requested) {
            if (!generated.containsKey(orientation)) {
                throw new EsdlException("The PV profile generator returned no profile for " + orientation);
            }
        }
    }

    private void deleteRecursively(Path directory) {
        try (var entries = Files.walk(directory)) {
            entries.sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.deleteIfExists(path);
                        } catch (IOException e) {
                            logger.warn("Could not delete {}", path, e);
                        }
                    });
        } catch (IOException e) {
            logger.warn("Could not clean up {}", directory, e);
        }
    }
}
