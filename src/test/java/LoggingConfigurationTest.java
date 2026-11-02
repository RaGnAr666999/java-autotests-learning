import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggingConfigurationTest {

    @Test
    void logsInfoWithSimpleLogger() {
        assertEquals("org.slf4j.simple.SimpleLoggerFactory",
                LoggerFactory.getILoggerFactory().getClass().getName());

        Logger logger = LoggerFactory.getLogger(LoggingConfigurationTest.class);
        assertTrue(logger.isInfoEnabled());
        assertFalse(logger.isDebugEnabled());
        logger.info("Console logging is configured successfully");
    }
}
