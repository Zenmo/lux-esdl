package energy.lux.esdl;

import com.anylogic.engine.Engine;
import com.anylogic.engine.ExperimentSimulation;
import zero_engine.EnergyModel;
import zerointerfaceloader.Zero_Loader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("This is my first commit");

        var experiment = new ExperimentSimulation<EnergyModel>() {
            @Override
            public EnergyModel createRoot(Engine engine) {
                return new EnergyModel();
            }

            @Override
            public void setupRootParameters(EnergyModel e, boolean b) {
                // AnyLogic usually generates this method body
            }
        };

        var energyModel = experiment.createRoot(experiment.getEngine());
        //energyModel.createAndStart();

        var loader = new Zero_Loader();
        loader.setEngine(experiment.getEngine());
        loader.instantiateBaseStructure_xjal();
        // intializes child agents
        // calls setupPlainVariables_xjal
        loader.doCreate();
        energyModel.createAndStart(loader);

        loader.energyModel = energyModel;
        loader.f_setSimulationTimeParameters();
    }
}
