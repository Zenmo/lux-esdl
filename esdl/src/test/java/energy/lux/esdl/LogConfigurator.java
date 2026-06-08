package energy.lux.esdl;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.LoggerFactory;

/**
 * Configures SLF4J/Logback programmatically.
 */
public class LogConfigurator {
    static {
        configure();
    }

    static void configure() {
        configure(Level.INFO);
    }

    static void configure(Level rootLevel) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();

        String pattern = "%d{yyyy-MM-dd'T'HH:mm:ss.SSSXXX} [%thread] %-5level %logger{36} - %msg%n";

        // Encoder for STDOUT
        PatternLayoutEncoder outEncoder = new PatternLayoutEncoder();
        outEncoder.setContext(context);
        outEncoder.setPattern(pattern);
        outEncoder.start();

        // Appender for INFO and DEBUG (goes to System.out)
        ConsoleAppender<ILoggingEvent> outAppender = new ConsoleAppender<>();
        outAppender.setContext(context);
        outAppender.setName("STDOUT");
        outAppender.setTarget("System.out");
        outAppender.setEncoder(outEncoder);
        outAppender.addFilter(new Filter<ILoggingEvent>() {
            @Override
            public FilterReply decide(ILoggingEvent event) {
                if (event.getLevel().isGreaterOrEqual(Level.WARN)) {
                    return FilterReply.DENY;
                } else {
                    return FilterReply.ACCEPT;
                }
            }
        });
        outAppender.start();

        // Encoder for STDERR
        PatternLayoutEncoder errEncoder = new PatternLayoutEncoder();
        errEncoder.setContext(context);
        errEncoder.setPattern(pattern);
        errEncoder.start();

        // Appender for WARN and ERROR (goes to System.err)
        ConsoleAppender<ILoggingEvent> errAppender = new ConsoleAppender<>();
        errAppender.setContext(context);
        errAppender.setName("STDERR");
        errAppender.setTarget("System.err");
        errAppender.setEncoder(errEncoder);
        errAppender.addFilter(new Filter<ILoggingEvent>() {
            @Override
            public FilterReply decide(ILoggingEvent event) {
                if (event.getLevel().isGreaterOrEqual(Level.WARN)) {
                    return FilterReply.ACCEPT;
                } else {
                    return FilterReply.DENY;
                }
            }
        });
        errAppender.start();

        Logger root = context.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.addAppender(outAppender);
        root.addAppender(errAppender);
        root.setLevel(rootLevel);
    }
}
