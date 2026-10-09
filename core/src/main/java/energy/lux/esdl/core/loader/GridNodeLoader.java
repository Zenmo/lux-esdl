package energy.lux.esdl.core.loader;

import esdl.Import;
import esdl.Transformer;
import energy.lux.engine.EnergyModel;
import energy.lux.engine.GridNode;
import energy.lux.engine.optionlists.OL_EnergyCarriers;

public class GridNodeLoader {
    public static GridNode loadImportAsset(Import importAsset, EnergyModel luxEngine) {
        var gridNode = luxEngine.add_pop_gridNodes();
        gridNode.energyModel = luxEngine;
        gridNode.onCreate();
        gridNode.p_gridNodeID = importAsset.getId();
        gridNode.p_description = importAsset.getName() + ", " + importAsset.getDescription();
        gridNode.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;
        return gridNode;
    }

    public static GridNode loadTransformer(Transformer transformer, EnergyModel luxEngine, GridNode currentGridNode) {
        var gridNode = luxEngine.add_pop_gridNodes();
        gridNode.energyModel = luxEngine;
        gridNode.onCreate();
        gridNode.p_gridNodeID = transformer.getId();
        gridNode.p_parentNodeID = currentGridNode.p_gridNodeID;
        gridNode.p_description = transformer.getName();
        gridNode.p_energyCarrier = OL_EnergyCarriers.ELECTRICITY;
        gridNode.p_capacity_kW = transformer.getCapacity() / 1000.0;
        return gridNode;
    }
}
