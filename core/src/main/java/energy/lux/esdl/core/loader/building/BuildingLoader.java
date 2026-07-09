package energy.lux.esdl.core.loader.building;

import esdl.AbstractBuilding;
import zero_engine.GridConnection;
import zerointerfaceloader.Zero_Loader;

public class BuildingLoader {
    public static void loadBuilding(AbstractBuilding building, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        BuildingGisLoader.loadGis(building, luxLoader, luxGridConnection);
        BuildingThermalLoader.loadBuilding(building, luxLoader, luxGridConnection);
    }
}
