package org.terasology.joml.test;

public class MathAssertConstants {
    /**
     * Precision for methods that do many operations calculating with a magnitude around zero, giving less accuracy.
     */
    public static final float MANY_OPS_AROUND_ZERO_PRECISION_FLOAT = 1.0E-03f;
    /**
     * Precision for methods that do basic operations calculating with a magnitude around zero.
     */
    public static final float STANDARD_AROUND_ZERO_PRECISION_FLOAT = 1.0E-18f;

    /**
     * Precision for methods that do many operations calculating with values with a magnitude around zero, giving less accuracy.
     */
    public static final double MANY_OPS_AROUND_ZERO_PRECISION_DOUBLE = 1.0E-05;
    /**
     * Precision for methods that do basic operations calculating with a magnitude around zero.
     */
    public static final double STANDARD_AROUND_ZERO_PRECISION_DOUBLE = 1.0E-21;
}
