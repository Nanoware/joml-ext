// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector2dc;
import org.joml.Vector2fc;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Represents a 2D circle using double-precision floating-point numbers.
 */
public class Circled implements Externalizable {

    /**
     * The x coordiante of the circle's center.
     */
    public double x;

    /**
     * The y coordiante of the circle's center.
     */
    public double y;

    /**
     * The radius of the circle.
     */
    public double r;

    /**
     * Create a new {@link Circled} with center position <code>(0, 0, 0)</code> and radius <code>0</code>.
     */
    public Circled() {
    }

    /**
     * Create a new {@link Circled} as a copy of the given <code>source</code>.
     *
     * @param source
     *          the {@link Circled} to copy from
     */
    public Circled(Circled source) {
        this.x = source.x;
        this.y = source.y;
        this.r = source.r;
    }

    /**
     * Create a new {@link Circled} with center position <code>(x, y)</code> and radius <code>r</code>.
     *
     * @param x
     *          the x coordinate of the circle's center
     * @param y
     *          the y coordinate of the circle's center
     * @param r
     *          the radius of the circle
     */
    public Circled(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    /**
     * Translate <code>this</code> by the given vector <code>xy</code>.
     *
     * @param xy
     *          the vector to translate by
     * @return this
     */
    public Circled translate(Vector2dc xy) {
        return translate(xy.x(), xy.y(), this);
    }

    /**
     * Translate <code>this</code> by the given vector <code>xy</code> and store the result in <code>dest</code>.
     *
     * @param xy
     *          the vector to translate by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Circled translate(Vector2dc xy, Circled dest) {
        return translate(xy.x(), xy.y(), dest);
    }

    /**
     * Translate <code>this</code> by the given vector <code>xy</code>.
     *
     * @param xy
     *          the vector to translate by
     * @return this
     */
    public Circled translate(Vector2fc xy) {
        return translate(xy.x(), xy.y(), this);
    }

    /**
     * Translate <code>this</code> by the given vector <code>xy</code> and store the result in <code>dest</code>.
     *
     * @param xy
     *          the vector to translate by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Circled translate(Vector2fc xy, Circled dest) {
        return translate(xy.x(), xy.y(), dest);
    }

    /**
     * Translate <code>this</code> by the vector <code>(x, y)</code>.
     *
     * @param x
     *          the x coordinate to translate by
     * @param y
     *          the y coordinate to translate by
     * @return this
     */
    public Circled translate(double x, double y) {
        return translate(x, y, this);
    }

    /**
     * Translate <code>this</code> by the vector <code>(x, y)</code> and store the result in <code>dest</code>.
     *
     * @param x
     *          the x coordinate to translate by
     * @param y
     *          the y coordinate to translate by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Circled translate(double x, double y, Circled dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        return dest;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(r);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Circled other = (Circled) obj;
        if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
            return false;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        return true;
    }

    /**
     * Return a string representation of this circle.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<code>0.000E0;-</code>".
     *
     * @return the string representation
     */
    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    /**
     * Return a string representation of this circle by formatting the vector components with the given {@link NumberFormat}.
     *
     * @param formatter
     *          the {@link NumberFormat} used to format the components with
     * @return the string representation
     */
    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(x, formatter) + " " + Runtime.format(y, formatter) + " " + Runtime.format(r, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(r);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readDouble();
        y = in.readDouble();
        r = in.readDouble();
    }

}
