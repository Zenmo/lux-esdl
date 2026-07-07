package energy.lux.esdl.core;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.slf4j.LoggerFactory;
import zero_engine.EnergyModel;
import zero_engine.GridConnection;
import zero_engine.GridNode;

import java.util.List;
import java.util.Objects;

import static energy.lux.esdl.core.util.CollectionUtil.findSingle;

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

    /**
     * TODO: unregister after use by implementing Closeable.
     */
    public static List<ILoggingEvent> captureLogs() {
        var loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        var listAppender = new ListAppender<ILoggingEvent>();
        listAppender.setContext(loggerContext);
        listAppender.start();

        var rootLogger = loggerContext.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        rootLogger.addAppender(listAppender);

        return listAppender.list;
    }
}
