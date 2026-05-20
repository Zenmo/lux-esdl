package energy.lux.esdl;

import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;

import java.util.Objects;

import static energy.lux.esdl.util.CollectionUtil.findSingle;

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

    static void runLux(EnergyModel luxEngine, double hours) {
        while (hours > 0.0) {
            luxEngine.f_runTimestep();
            hours -= luxEngine.p_timeParameters.getTimeStep_h();
        }
    }
}
