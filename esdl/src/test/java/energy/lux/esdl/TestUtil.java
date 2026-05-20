package energy.lux.esdl;

import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;

import java.util.Objects;

import static energy.lux.esdl.Util.findSingle;

public class TestUtil {

    static GridNode findGridNodeById(EnergyModel energyModel, String gridNodeId) {
        return findSingle(
                energyModel.pop_gridNodes,
                gn -> Objects.equals(gn.p_gridNodeID, gridNodeId)
        );
    }

    static GridConnection findGridConnectionById(EnergyModel energyModel, String gridConnectionId) {
        return findSingle(
                energyModel.pop_gridConnections,
                gc -> Objects.equals(gc.p_gridConnectionID, gridConnectionId)
        );
    }
}
