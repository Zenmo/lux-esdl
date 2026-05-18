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
        var experiment = new ExperimentSimulation<EnergyModel>() {
            @Override
            public EnergyModel createRoot(Engine engine) {
                var energyModel = new EnergyModel();
                // We can't call this here because this is the root agent.
                // It will try to make itself its own owner and fail.
                // Maybe the root agent should be a simpler agent.
//                energyModel.setEngine(engine);
//                energyModel.instantiateBaseStructure_xjal();
                return energyModel;
            }

            @Override
            public void setupRootParameters(EnergyModel e, boolean b) {
                // AnyLogic usually generates this method body
            }
        };

        // needs to start at midnight
        var start = ZonedDateTime.of(2025, 1, 1, 0, 0, 0, 0, ZoneId.of("Europe/Amsterdam"));
        var engine = experiment.getEngine();
        engine.setStartDate(Date.from(start.toInstant()));

        var energyModel = experiment.createRoot(engine);

        var loader = new Zero_Loader();
        loader.setEngine(engine);
        loader.instantiateBaseStructure_xjal();
        // intializes child agents
        // calls setupPlainVariables_xjal
        loader.doCreate();
        energyModel.createAndStart(loader);

        loader.energyModel = energyModel;
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
