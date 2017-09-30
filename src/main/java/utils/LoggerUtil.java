package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static java.lang.Thread.currentThread;

public final class LoggerUtil {
    private static Logger logger;

    private LoggerUtil() {
    }

    public static Logger getInstance() {
        Logger log = logger;
        if (log == null) {
            synchronized (LoggerUtil.class) {
                PropertyConfigurator.configure(currentThread().getContextClassLoader().getResource("lo4j.properties").getPath());
                logger = log = Logger.getLogger(new Object() {
                }.getClass());
            }
        }
        return log;
    }
}