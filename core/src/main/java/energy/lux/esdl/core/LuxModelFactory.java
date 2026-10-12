package energy.lux.esdl.core;

import com.anylogic.engine.Agent;
import energy.lux.engine.EnergyModel;
import energy.lux.engine.dataclasses.J_TimeParameters;
import energy.lux.engine.dataclasses.J_TimeVariables;
import energy.lux.engine.optionlists.OL_GridOperator;
import energy.lux.loader.DefaultHeatingStrategySettings;
import energy.lux.loader.EngineProfileBuilder;
import energy.lux.loader.LoaderProjectSettings;
import energy.lux.loader.datareader.AVGCDataReader;
import energy.lux.loader.datareader.DataReader;
import energy.lux.loader.optionlists.OL_SurveyType;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Prepares an energy model without any grid connections for the tests and the scenario export,
 * the way the LUX loader does before it reads a project's data.
 * <p>
 * A project that loads an ESDL has its own LUX loader and does not use this.
 */
public class LuxModelFactory {
    /**
     * The ESDL files we load describe the year 2050, and LUX evaluates a profile by its offset
     * from the 1st of January of the simulation year, so the simulation has to run in 2050 too.
     */
    private static final int simulationStartYear = 2050;

    /**
     * LUX has no averages or default profiles for 2050. Like the AnyLogic loader did, these take the 2025 data.
     */
    private static final int dataYear = 2025;

    /**
     * Matches the default grid operator of the ISIE project.
     */
    private static final OL_GridOperator gridOperator = OL_GridOperator.ENEXIS;

    /**
     * Caller must take care to call {@link EnergyModel#f_initializeEngine}
     * before running the simulation.
     */
    public static EnergyModel createEnergyModel() {
        var simulationProject = EsdlProjectSettings.builder()
                .dataPath(Path.of("."))
                .project_name("ESDL")
                .survey_type(OL_SurveyType.NONE)
                .grid_operator(gridOperator)
                .start_year(simulationStartYear)
                .build();
        var dataProject = simulationProject.toBuilder().start_year(dataYear).build();

        Agent.resetRandomStream();
        var energyModel = new EnergyModel();
        energyModel.avgc_data = new AVGCDataReader().buildAVGCData(dataProject);
        energyModel.p_timeParameters = new J_TimeParameters(
                simulationProject.time_step_h(),
                simulationProject.start_year(),
                simulationProject.run_start_time_h(),
                simulationProject.run_end_time_h(),
                simulationProject.summer_week_number(),
                simulationProject.winter_week_number()
        );
        energyModel.p_timeVariables = new J_TimeVariables();
        new DefaultHeatingStrategySettings().setDefaultHeatingStrategies(energyModel);

        var profileReader = new ProfileReader();
        profileReader.readProfiles(dataProject);
        new EngineProfileBuilder().f_setEngineProfiles(
                profileReader.defaultProfiles_data,
                profileReader.c_customProfiles_data,
                energyModel
        );
        return energyModel;
    }

    /**
     * DataReader.read reads all of a project's files, and the methods for the profiles alone are protected.
     */
    private static class ProfileReader extends DataReader {
        void readProfiles(LoaderProjectSettings project) {
            try {
                readDefaultProfilesData(project.dataPath(), project);
                readCustomProfilesData(project.dataPath(), project);
            } catch (IOException e) {
                throw new RuntimeException("Failed to read the default profiles of LUX", e);
            }
        }
    }
}
