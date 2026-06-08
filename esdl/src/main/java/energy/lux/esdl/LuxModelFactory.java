package energy.lux.esdl;

import com.anylogic.engine.Engine;
import com.anylogic.engine.ExperimentSimulation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import zero_engine.EnergyModel;
import zerointerfaceloader.Settings;
import zerointerfaceloader.Zero_Loader;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class LuxModelFactory {
    /**
     * Create a LUX energy model with no assets or grid connections.
     * <p>
     * Return the loader because it might be useful for the caller,
     * and it contains the energyModel.
     * <p>
     * Caller must take care to call {@link EnergyModel#f_initializeEngine}
     * before running the simulation.
     */
    public static Zero_Loader createEnergyModel() {
        try {
            return createEnergyModelImpl();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException("Failed to create initial energy model: " + e.getMessage(), e);
        }
    }

    public static Zero_Loader createEnergyModelImpl() throws IOException, InvalidFormatException {
        // I suspect it's possible to create an EnergyModel without an experiment
        // if we do some small changes to the EnergyModel and Loader.
        var experiment = new ExperimentSimulation<Zero_Loader>() {
            @Override
            public void setupEngine(Engine engine) {
                super.setupEngine(engine);

                // needs to start at midnight
                var start = ZonedDateTime.of(2025, 1, 1, 0, 0, 0, 0, ZoneId.of("Europe/Amsterdam"));
                engine.setStartDate(Date.from(start.toInstant()));
            }

            @Override
            public Zero_Loader createRoot(Engine engine) {
                /*
                 * !! IMPORTANT !!
                 *
                 * This seems the correct way to initialize an Agent
                 *
                 * The 3-parameter constructor overload
                 *   - sets default values of parameters
                 *   - creates child agents recursively (top-to-bottom)
                 *   - sets agent links.
                 *
                 * Agent::create()
                 *   - top-to-bottom for all agents:
                 *       - calls onBeforeCreate() user hook
                 *       - sets default values of variables
                 *   - calls onCreate() user hook for all agents bottom-to-top
                 *
                 * (Agent::start() calls onStartup() of all agents bottom-to-top)
                 */
                var loader = new Zero_Loader(engine, null, null);
                loader.create();
                return loader;
            }

            @Override
            public void setupRootParameters(Zero_Loader e, boolean b) {
                // AnyLogic usually generates this method body
            }
        };

        var loader = experiment.createRoot(experiment.getEngine());
        var energyModel = loader.energyModel;

        loader.settings = Settings.builder().build();
        loader.f_setSimulationTimeParameters();

        loader.defaultProfiles_data = ExcelProfileReader.loadDefaultProfiles2025();
        loader.f_setEngineProfiles();

        energyModel.p_truckTripsCsv = loader.inputCSVtruckTrips;
        energyModel.p_householdTripsCsv = loader.inputCSVhouseholdTrips;
        energyModel.p_cookingPatternCsv = loader.inputCSVcookingActivities;

        return loader;
    }
}
