package org.terasology.joml.test;

import org.joml.Matrix3fc;
import org.joml.Matrix4fc;

import java.util.function.Supplier;

import static org.terasology.joml.test.AssertionUtils.failNotEqual;
import static org.terasology.joml.test.AssertionUtils.isValid;

public class MatrixAssert {
    private MatrixAssert() {
    }

    public static void assertEquals(Matrix4fc expected, Matrix4fc actual, float epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Matrix4fc expected, Matrix4fc actual, float epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Matrix4fc expected, Matrix4fc actual, float epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Matrix3fc expected, Matrix3fc actual, float epsilon) {
        if (isValid(expected, actual) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual);
        }
    }

    public static void assertEquals(Matrix3fc expected, Matrix3fc actual, float epsilon, String message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }

    public static void assertEquals(Matrix3fc expected, Matrix3fc actual, float epsilon, Supplier<String> message) {
        if (isValid(expected, actual, message) && !expected.equals(actual, epsilon)) {
            failNotEqual(expected, actual, message);
        }
    }
}
