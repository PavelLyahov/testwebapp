package web.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.exceptions.LoggerException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger {
    private static final Logger log = LogManager.getLogger(MyLogger.class);
    boolean logSteps = true;
    private static final String MESSAGE_TEMPLATE_WITH_THREAD_ID = "[%1$s] %2$s";
    private static ThreadLocal<MyLogger> loggerHolder = new InheritableThreadLocal<>();

    public static MyLogger get() {

        if (loggerHolder.get() != null) {
            return loggerHolder.get();
        } else {
            throw new LoggerException("Can't get Logger instance (is null).");
        }
    }

    public void step(final int step, final String message) {
        logDelimMsg(String.format("Step: %s : %s", step, message));
    }

    /**
     * This method is using for formatting almost all log records
     *
     * @param msg Formatted message
     */
    private void logDelimMsg(final String msg) {
        if (logSteps) {
            info(String.format("====-----[ %1$s ]-----====", msg));
        }
    }

    /**
     * Debug log
     *
     * @param message Message
     */
    public void debug(final String message) {
        log.debug(addThreadId(message));
    }
    // All methods below are using for creation messages with a different level of importance

    /**
     * Info log
     *
     * @param message Message
     */
    public void info(final String message) {
        log.info(addThreadId(message));
    }

    /**
     * Warning log
     *
     * @param message Message
     */
    public void warn(final String message) {
        log.warn(addThreadId(message));
    }

    /**
     * Error log
     *
     * @param message Message
     */
    public void error(final String message) {
        log.error(addThreadId(message));
    }

    /**
     * Fatal log
     *
     * @param message Message
     */
    public void fatal(final String message, Throwable throwable) {
        log.fatal(addThreadId(message), throwable);
    }

    public String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
        return String.format("[%s] ", dateFormat.format(new Date()));
    }

    private String addThreadId(String message) {
        return String.format(MESSAGE_TEMPLATE_WITH_THREAD_ID, Thread.currentThread().getId(), message);
    }
}
