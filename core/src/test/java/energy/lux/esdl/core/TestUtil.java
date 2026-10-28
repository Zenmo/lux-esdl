package energy.lux.esdl.core;

import energy.lux.engine.EnergyModel;
import energy.lux.engine.gridconnections.GridConnection;
import energy.lux.engine.GridNode;

import com.anylogic.engine.analysis.DataSet;

import java.util.Objects;

import static energy.lux.esdl.core.util.CollectionUtil.findSingle;

public class TestUtil {
    static double yMax(DataSet dataSet) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < dataSet.size(); i++) {
            max = Math.max(max, dataSet.getY(i));
        }
        return max;
    }

    static double yMean(DataSet dataSet) {
        double sum = 0;
        for (int i = 0; i < dataSet.size(); i++) {
            sum += dataSet.getY(i);
        }
        return sum / dataSet.size();
    }

    static GridNode findGridNodeById(EnergyModel energyModel, String gridNodeId) {
        return findSingle(
                energyModel.pop_gridNodes,
                gn -> Objects.equals(gn.p_gridNodeID, gridNodeId)
        );
    }

    static GridConnection findGridConnectionById(EnergyModel energyModel, String gridConnectionId) {
        return findSingle(
                energyModel.c_gridConnections,
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
