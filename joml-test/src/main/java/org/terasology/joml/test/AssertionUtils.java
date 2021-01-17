package org.terasology.joml.test;

import org.junit.platform.commons.util.StringUtils;
import org.opentest4j.AssertionFailedError;

import java.util.function.Supplier;

public class AssertionUtils {

    private AssertionUtils() {
    }

    public static boolean isValid(Object expected, Object actual) {
        if (expected == null) {
            if (actual == null) {
                return false;
            }
            failNotEqual(expected, actual);
        }
        return true;
    }

    public static boolean isValid(Object expected, Object actual, Supplier<String> message) {
        if (expected == null) {
            if (actual == null) {
                return false;
            }
            failNotEqual(expected, actual, message);
        }
        return true;
    }

    public static boolean isValid(Object expected, Object actual, String message) {
        if (expected == null) {
            if (actual == null) {
                return false;
            }
            failNotEqual(expected, actual, message);
        }
        return true;
    }

    public static String buildPrefix(String message) {
        return (StringUtils.isNotBlank(message) ? message + " ==> " : "");
    }

    public static String formatValues(Object expected, Object actual) {
        String expectedString = StringUtils.nullSafeToString(expected);
        String actualString = StringUtils.nullSafeToString(actual);
        return String.format("expected: <%s> but was: <%s>", expectedString, actualString);
    }

    public static void failNotEqual(Object expected, Object actual) {
        throw new AssertionFailedError(formatValues(expected, actual), expected, actual);
    }

    public static void failNotEqual(Object expected, Object actual, String prefix) {
        throw new AssertionFailedError(buildPrefix(prefix) + formatValues(expected, actual), expected, actual);
    }

    public static void failNotEqual(Object expected, Object actual, Supplier<String> prefix) {
        throw new AssertionFailedError(buildPrefix(nullSafeGet(prefix)) + formatValues(expected, actual), expected, actual);
    }

    public static String nullSafeGet(Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
