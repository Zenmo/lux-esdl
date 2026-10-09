package energy.lux.esdl.core;

import energy.lux.engine.EnergyModel;
import energy.lux.esdl.core.iterator.RootIterator;
import energy.lux.loader.EnergyAssetCreator;
import energy.lux.loader.GISBuilder;
import energy.lux.loader.InterfaceStartup;
import energy.lux.loader.Loader;
import energy.lux.loader.ModelLoader;
import energy.lux.loader.SliderGCBuilder;
import energy.lux.loader.datareader.DataReader;
import energy.lux.loader.datarecords.GridNodeData;
import energy.lux.loader.gridconnectionbuilders.BatteryBuilder;
import energy.lux.loader.gridconnectionbuilders.SolarParkBuilder;
import energy.lux.loader.gridconnectionbuilders.WindFarmBuilder;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Loads an energy model from an ESDL file instead of from a project's data files.
 * <p>
 * The LUX {@link Loader} only prepares the model: averages, time parameters, heating strategies and profiles.
 * Its builders for houses, companies and the like are not used, so the grid connections are exactly the ones
 * in the ESDL, plus the main slider grid connections that the LUX user interface expects. The loader's
 * project must start in 2050, the year the ESDL files describe.
 */
public class EsdlModelLoader implements ModelLoader {
    private final Loader loader;
    private final Path esdlFile;

    public EsdlModelLoader(Loader loader, Path esdlFile) {
        this.loader = loader;
        this.esdlFile = esdlFile;
    }

    @Override
    public EnergyModel loadAndBuild() {
        if (!Files.isRegularFile(esdlFile)) {
            throw new EsdlException("No ESDL file at " + esdlFile.toAbsolutePath());
        }
        var esdl = ESDLReader.readResource(esdlFile.toAbsolutePath().toString());

        var modelBuilder = LuxModelFactory.createModelBuilder(loader);
        RootIterator.loadEsdlIntoLux(esdl, modelBuilder);

        var energyModel = modelBuilder.energyModel;
        addMainSliderGridConnections(energyModel);
        energyModel.f_initializeEngine();
        InterfaceStartup.initialAssetOrdering(energyModel);
        return energyModel;
    }

    /**
     * The sliders for solar, wind and battery sit on the top grid node. They are made by the LUX builders from
     * data records, so the records are collected in a reader that has not read anything.
     */
    private static void addMainSliderGridConnections(EnergyModel energyModel) {
        var topGridNode = energyModel.f_getRootGridNodes().get(0);

        var sliderData = new DataReader();
        sliderData.c_gridNode_data.add(GridNodeData.builder().gridnode_id(topGridNode.p_gridNodeID).build());
        new SliderGCBuilder().initializeSpecificSliderGC(sliderData);

        var assetCreator = new EnergyAssetCreator();
        var gisBuilder = new GISBuilder();
        new SolarParkBuilder().f_createSolarParks(sliderData.c_solarfarm_data, assetCreator, gisBuilder, energyModel.avgc_data, energyModel);
        new WindFarmBuilder().f_createWindFarms(sliderData.c_windfarm_data, assetCreator, gisBuilder, energyModel);
        new BatteryBuilder().f_createBatteries(sliderData.c_battery_data, energyModel, assetCreator, gisBuilder);
    }
}
