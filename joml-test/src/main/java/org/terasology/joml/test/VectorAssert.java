package org.terasology.joml.test;

import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

import java.util.function.Supplier;

import static org.terasology.joml.test.AssertionUtils.failNotEqual;
import static org.terasology.joml.test.AssertionUtils.isValid;

public class VectorAssert {
    private VectorAssert() {
    }

    public static void assertEquals(Vector3fc expected, Vector3fc actual, float epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Vector3fc expected, Vector3fc actual, float epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Vector3fc expected, Vector3fc actual, float epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Vector3dc expected, Vector3dc actual, double epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Vector3dc expected, Vector3dc actual, double epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Vector3dc expected, Vector3dc actual, double epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Vector2fc expected, Vector2fc actual, float epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Vector2fc expected, Vector2fc actual, float epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Vector2fc expected, Vector2fc actual, float epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Vector2dc expected, Vector2dc actual, double epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Vector2dc expected, Vector2dc actual, double epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Vector2dc expected, Vector2dc actual, double epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }
}
