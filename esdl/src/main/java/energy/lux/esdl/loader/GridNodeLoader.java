package energy.lux.esdl.loader;

import esdl.Import;
import esdl.Transformer;
import zero_engine.EnergyModel;
import zero_engine.GridNode;
import zero_engine.OL_EnergyCarriers;
import zerointerfaceloader.Zero_Loader;

public class GridNodeLoader {
    static GridNode loadImportAsset(Import importAsset, EnergyModel luxEngine) {
        var gridNode = luxEngine.add_pop_gridNodes();
        gridNode.p_gridNodeID = importAsset.getId();
        gridNode.p_description = importAsset.getName() + ", " + importAsset.getDescription();
        gridNode.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;

        return gridNode;
    }

    static GridNode loadTransformer(Transformer transformer, EnergyModel luxEngine) {
        var gridNode = luxEngine.add_pop_gridNodes();
        gridNode.p_gridNodeID = transformer.getId();
        gridNode.p_description = transformer.getName();
        gridNode.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;
        return gridNode;
    }
}
