package energy.lux.esdl.core;

import energy.lux.engine.optionlists.OL_GridOperator;
import energy.lux.loader.Loader;
import energy.lux.loader.User;
import energy.lux.loader.optionlists.OL_SurveyType;

import java.nio.file.Path;

public class LuxModelFactory {
    /**
     * The ESDL files we load describe the year 2050, and LUX evaluates a profile by its offset
     * from the 1st of January of the simulation year, so the simulation has to run in 2050 too.
     */
    private static final int simulationStartYear = 2050;

    /**
     * Matches the default grid operator of the ISIE project.
     */
    private static final OL_GridOperator gridOperator = OL_GridOperator.ENEXIS;

    /**
     * Use the loader of the project that will run the model, so that its settings,
     * profiles and overrides apply. The loader's project must start in {@link #simulationStartYear}.
     * <p>
     * Caller must take care to call {@link energy.lux.engine.EnergyModel#f_initializeEngine}
     * before running the simulation.
     */
    public static LuxModelBuilder createModelBuilder(Loader loader) {
        return new LuxModelBuilder(loader.createPreparedModel());
    }

    /**
     * Create a LUX energy model with no assets or grid connections, for runs that have no project around them.
     */
    public static LuxModelBuilder createEnergyModel() {
        var project = EsdlProjectSettings.builder()
                .dataPath(Path.of("."))
                .project_name("ESDL")
                .survey_type(OL_SurveyType.NONE)
                .grid_operator(gridOperator)
                .start_year(simulationStartYear)
                .build();

        var loader = Loader.builder()
                .project(project)
                .user(User.builder().build())
                .build();

        return createModelBuilder(loader);
    }
}
