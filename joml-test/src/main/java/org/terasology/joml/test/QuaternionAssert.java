package org.terasology.joml.test;

import org.joml.Quaterniondc;
import org.joml.Quaternionfc;

import java.util.function.Supplier;

import static org.terasology.joml.test.AssertionUtils.failNotEqual;
import static org.terasology.joml.test.AssertionUtils.isValid;

public class QuaternionAssert {
    private QuaternionAssert() {
    }

    public static void assertEquals(Quaternionfc expected, Quaternionfc actual, float epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Quaternionfc expected, Quaternionfc actual, float epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Quaternionfc expected, Quaternionfc actual, float epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Quaterniondc expected, Quaterniondc actual, float epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Quaterniondc expected, Quaterniondc actual, float epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Quaterniondc expected, Quaterniondc actual, float epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }
}
