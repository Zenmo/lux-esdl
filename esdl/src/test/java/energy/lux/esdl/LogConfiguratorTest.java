package energy.lux.esdl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogConfiguratorTest {
    @Test
    public void testLogging() {
        Logger logger = LoggerFactory.getLogger(LogConfiguratorTest.class);
        
        System.out.println("--- Starting Test (INFO level) ---");
        logger.debug("DEBUG: This should NOT be shown");
        logger.info("INFO: This should go to STDOUT");
        logger.warn("WARN: This should go to STDERR");
        logger.error("ERROR: This should go to STDERR");

        System.out.println("--- Switching to DEBUG level ---");
        LogConfigurator.configure(ch.qos.logback.classic.Level.DEBUG);
        logger.debug("DEBUG: This SHOULD be shown now in STDOUT");
        logger.info("INFO: This should go to STDOUT");
    }
}
