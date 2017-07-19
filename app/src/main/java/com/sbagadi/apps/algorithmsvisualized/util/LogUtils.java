package com.sbagadi.apps.algorithmsvisualized.util;

import android.util.Log;

import com.sbagadi.apps.algorithmsvisualized.BuildConfig;

/**
 * An utility class containing helper methods for logging messages to logcat.
 */
public class LogUtils {
    private static final String LOG_PREFIX = "av_";
    private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    private static final int MAX_LOG_TAG_LENGTH = 23;

    public static boolean LOGGING_ENABLED = !BuildConfig.BUILD_TYPE.equalsIgnoreCase("release");

    /**
     * Creates a log tag using the provided class name.
     *
     * @param className The class name for which to generate a log tag.
     * @return A {@link String} created by adding the class name to the {@link LogUtils#LOG_PREFIX}.
     */
    private static String makeLogTag(String className) {
        if (className.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + className.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }

        return LOG_PREFIX + className;
    }

    /**
     * Creates a log tag using the provided class name.
     * Note: Do not use this when obfuscating class names!
     *
     * @param cls The class for which to generate a log tag.
     * @return A {@link String} created by adding the class name to the {@link LogUtils#LOG_PREFIX}.
     */
    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    /**
     * Logs a debug message when logging is enabled and debug log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     */
    public static void LOGD(final String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, message);
            }
        }
    }

    /**
     * Logs a debug message with the cause when logging is enabled and debug log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     * @param cause A {@link Throwable} with the cause for logging.
     */
    public static void LOGD(final String tag, String message, Throwable cause) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, message, cause);
            }
        }
    }

    /**
     * Logs a verbose message when logging is enabled and verbose log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     */
    public static void LOGV(final String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, message);
            }
        }
    }

    /**
     * Logs a verbose message with the cause when logging is enabled and verbose log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     * @param cause A {@link Throwable} with the cause for logging.
     */
    public static void LOGV(final String tag, String message, Throwable cause) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, message, cause);
            }
        }
    }

    /**
     * Logs an info message when logging is enabled and info log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     */
    public static void LOGI(final String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.INFO)) {
                Log.i(tag, message);
            }
        }
    }

    /**
     * Logs an info message with the cause when logging is enabled and info log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     * @param cause A {@link Throwable} with the cause for logging.
     */
    public static void LOGI(final String tag, String message, Throwable cause) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.INFO)) {
                Log.i(tag, message, cause);
            }
        }
    }

    /**
     * Logs a warning message when logging is enabled and warning log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     */
    public static void LOGW(final String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.WARN)) {
                Log.w(tag, message);
            }
        }
    }

    /**
     * Logs a warning message with the cause when logging is enabled and warning log level is
     * loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     * @param cause A {@link Throwable} with the cause for logging.
     */
    public static void LOGW(final String tag, String message, Throwable cause) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.WARN)) {
                Log.w(tag, message, cause);
            }
        }
    }

    /**
     * Logs an error message when logging is enabled and error log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     */
    public static void LOGE(final String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, message);
            }
        }
    }

    /**
     * Logs an error message with the cause when logging is enabled and error log level is loggable.
     *
     * @param tag The tag to be used for logging.
     * @param message The message to be logged.
     * @param cause A {@link Throwable} with the cause for logging.
     */
    public static void LOGE(final String tag, String message, Throwable cause) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, message, cause);
            }
        }
    }

    private LogUtils() {
    }
}
