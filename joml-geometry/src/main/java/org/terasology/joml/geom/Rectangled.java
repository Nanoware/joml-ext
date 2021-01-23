// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Math;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector2d;
import org.joml.Vector2dc;
import org.joml.Vector2fc;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Represents a 2D axis-aligned rectangle.
 */
public class Rectangled implements Externalizable, Rectangledc {

    /**
     * The x coordinate of the minimum corner.
     */
    public double minX;
    /**
     * The y coordinate of the minimum corner.
     */
    public double minY;
    /**
     * The x coordinate of the maximum corner.
     */
    public double maxX;
    /**
     * The y coordinate of the maximum corner.
     */
    public double maxY;

    /**
     * Create a new {@link Rectangled} with a minimum and maximum corner of <code>(0, 0)</code>.
     */
    public Rectangled() {
    }

    /**
     * Create a new {@link Rectangled} as a copy of the given <code>source</code>.
     *
     * @param source
     *          the {@link Rectangled} to copy from
     */
    public Rectangled(Rectangled source) {
        this.minX = source.minX;
        this.minY = source.minY;
        this.maxX = source.maxX;
        this.maxY = source.maxY;
    }

    /**
     * Create a new {@link Rectangled} with the given <code>min</code> and <code>max</code> corner coordinates.
     *
     * @param min
     *          the minimum coordinates
     * @param max
     *          the maximum coordinates
     */
    public Rectangled(Vector2dc min, Vector2dc max) {
        this.minX = min.x();
        this.minY = min.y();
        this.maxX = max.x();
        this.maxY = max.y();
    }

    /**
     * Create a new {@link Rectangled} with the given minimum and maximum corner coordinates.
     *
     * @param minX
     *          the x coordinate of the minimum corner
     * @param minY
     *          the y coordinate of the minimum corner
     * @param maxX
     *          the x coordinate of the maximum corner
     * @param maxY
     *          the y coordinate of the maximum corner
     */
    public Rectangled(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public double minX() {
        return this.minX;
    }

    @Override
    public double minY() {
        return this.minY;
    }

    @Override
    public double maxX() {
        return this.maxX;
    }

    @Override
    public double maxY() {
        return this.maxY;
    }

    @Override
    public double getSizeX() {
        return this.maxX - this.minX;
    }

    @Override
    public double getSizeY() {
        return this.maxY - this.minY;
    }

    @Override
    public Vector2d getSize(Vector2d dest) {
        return dest.set(this.maxX - this.minX, this.maxY - this.minY);
    }

    @Override
    public Rectangled setSize(double dx, double dy, Rectangled dest) {
        dest.maxX = dest.minX + dx;
        dest.maxY = dest.minY + dy;
        return dest;
    }

    public Rectangled setSize(double dx, double dy) {
        return setSize(dx,dy, this);
    }

    @Override
    public Rectangled setSize(Vector2fc size, Rectangled dest) {
        return setSize(size.x(), size.y(), dest);
    }

    public Rectangled setSize(Vector2fc size) {
        return setSize(size, this);
    }

    @Override
    public Rectangled setSize(Vector2dc size, Rectangled dest) {
        return setSize(size.x(), size.y(), dest);
    }

    public Rectangled setSize(Vector2dc size) {
        return setSize(size.x(), size.y(), this);
    }

    /**
     * Set this {@link Rectangled} to be a clone of <code>source</code>.
     *
     * @param source
     *            the {@link Rectangled} to copy from
     * @return this
     */
    public Rectangled set(Rectangled source){
        this.minX = source.minX;
        this.minY = source.minY;
        this.maxX = source.maxX;
        this.maxY = source.maxY;
        return this;
    }

    /**
     * Set the minimum corner coordinates.
     *
     * @param minX
     *          the x coordinate of the minimum corner
     * @param minY
     *          the y coordinate of the minimum corner
     * @return this
     */
    public Rectangled setMin(double minX, double minY) {
        this.minX = minX;
        this.minY = minY;
        return this;
    }

    /**
     * Set the minimum corner coordinates.
     *
     * @param min
     *          the minimum coordinates
     * @return this
     */
    public Rectangled setMin(Vector2dc min) {
        this.minX = min.x();
        this.minY = min.y();
        return this;
    }


    /**
     * Set the maximum corner coordinates.
     *
     * @param maxX
     *              the x coordinate of the maximum corner
     * @param maxY
     *              the y coordinate of the maximum corner
     * @return this
     */
    public Rectangled setMax(double maxX, double maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        return this;
    }

    /**
     * Set the maximum corner coordinates.
     *
     * @param max
     *          the maximum coordinates
     * @return this
     */
    public Rectangled setMax(Vector2dc max) {
        this.maxX = max.x();
        this.maxY = max.y();
        return this;
    }

    /**
     * Return the length of the rectangle in the X dimension.
     *
     * @return length in the X dimension
     */
    public double lengthX() {
        return maxX - minX;
    }

    /**
     * Return the length of the rectangle in the Y dimension.
     *
     * @return length in the Y dimension
     */
    public double lengthY() {
        return maxY - minY;
    }

    /**
     * Return the area of the rectangle
     *
     * @return area
     */
    public double area() {
        return lengthX() * lengthY();
    }

    private Rectangled validate() {
        if (!isValid()) {
            minX = Double.NaN;
            minY = Double.NaN;
            maxX = Double.NaN;
            maxY = Double.NaN;
        }
        return this;
    }

    /**
     * Check whether <code>this</code> rectangle represents a valid rectangle.
     *
     * @return <code>true</code> iff this rectangle is valid; <code>false</code> otherwise
     */
    public boolean isValid() {
        return minX < maxX && minY < maxY;
    }

    @Override
    public Rectangled intersection(Rectangledc other, Rectangled dest) {
        dest.minX = Math.max(minX, other.minX());
        dest.minY = Math.max(minY, other.minY());
        dest.maxX = Math.min(maxX, other.maxX());
        dest.maxY = Math.min(maxY, other.maxY());
        return dest.validate();
    }

    /**
     * Compute the rectangle of intersection between <code>this</code> and the given rectangle.
     * <p>
     * If the two rectangles do not intersect, then {@link Double#NaN} is stored in each component
     * of <code>dest</code>.
     *
     * @param other
     *          the other rectangle
     * @return this
     */
    public Rectangled intersection(Rectangledc other) {
        return intersection(other, this);
    }

    @Override
    public Rectangled intersection(Rectanglefc other, Rectangled dest) {
        dest.minX = Math.max(minX, other.minX());
        dest.minY = Math.max(minY, other.minY());
        dest.maxX = Math.min(maxX, other.maxX());
        dest.maxY = Math.min(maxY, other.maxY());
        return dest.validate();
    }

    /**
     * Compute the rectangle of intersection between <code>this</code> and the given rectangle and
     * store the result in <code>dest</code>.
     * <p>
     * If the two rectangles do not intersect, then {@link Double#NaN} is stored in each component
     * of <code>dest</code>.
     *
     * @param other
     *          the other rectangle
     * @param dest
     *          will hold the result
     * @return dest
     */
    @Override
    public Rectangled intersection(Rectangleic other, Rectangled dest) {
        dest.minX = Math.max(minX, other.minX());
        dest.minY = Math.max(minY, other.minY());
        dest.maxX = Math.min(maxX, other.maxX());
        dest.maxY = Math.min(maxY, other.maxY());
        return dest.validate();
    }

    /**
     * Return the length of this rectangle in the X and Y dimensions and store the result in <code>dest</code>.
     *
     * @param dest
     *          will hold the result
     * @return dest
     * @deprecated Use {@link #getSize(Vector2d)}
     */
    public Vector2d lengths(Vector2d dest) {
        return dest.set(lengthX(), lengthY());
    }

    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle
     *          the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    @Override
    public boolean containsRectangle(Rectangledc rectangle) {
        return rectangle.minX() >= minX && rectangle.maxX() <= maxX &&
               rectangle.minY() >= minY && rectangle.maxY() <= maxY;
    }

    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle
     *          the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    @Override
    public boolean containsRectangle(Rectanglefc rectangle) {
        return rectangle.minX() >= minX && rectangle.maxX() <= maxX &&
               rectangle.minY() >= minY && rectangle.maxY() <= maxY;
    }



    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle
     *          the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    @Override
    public boolean containsRectangle(Rectangleic rectangle) {
        return rectangle.minX() >= minX && rectangle.maxX() <= maxX &&
               rectangle.minY() >= minY && rectangle.maxY() <= maxY;
    }

    /**
     * Set <code>this</code> to the union of <code>this</code> and the given point <code>p</code>.
     *
     * @param x
     *          the x coordinate of the point
     * @param y
     *          the y coordinate of the point
     * @return this
     */
    public Rectangled union(double x, double y) {
        return union(x, y, this);
    }

    /**
     * Set <code>this</code> to the union of <code>this</code> and the given point <code>p</code>.
     *
     * @param p
     *          the point
     * @return this
     */
    public Rectangled union(Vector2dc p) {
        return union(p.x(), p.y(), this);
    }


    @Override
    public Rectangled union(double x, double y, Rectangled dest) {
        dest.minX = this.minX < x ? this.minX : x;
        dest.minY = this.minY < y ? this.minY : y;
        dest.maxX = this.maxX > x ? this.maxX : x;
        dest.maxY = this.maxY > y ? this.maxY : y;
        return dest;
    }


    @Override
    public Rectangled union(Vector2dc p, Rectangled dest) {
        return union(p.x(), p.y(), dest);
    }

    /**
     * Set <code>this</code> to the union of <code>this</code> and <code>other</code>.
     *
     * @param other
     *          the other {@link Rectanglef}
     * @return this
     */
    public Rectangled union(Rectangledc other) {
        return this.union(other, this);
    }

    /**
     * Compute the union of <code>this</code> and <code>other</code> and store the result in <code>dest</code>.
     *
     * @param other
     *          the other {@link Rectangled}
     * @param dest
     *          will hold the result
     * @return dest
     */
    @Override
    public Rectangled union(Rectangledc other, Rectangled dest) {
        dest.minX = this.minX < other.minX() ? this.minX : other.minX();
        dest.minY = this.minY < other.minY() ? this.minY : other.minY();
        dest.maxX = this.maxX > other.maxX() ? this.maxX : other.maxX();
        dest.maxY = this.maxY > other.maxY() ? this.maxY : other.maxY();
        return dest;
    }

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other
     *          the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    @Override
    public boolean intersectsRectangle(Rectangledc other) {
        return minX < other.maxX() && maxX > other.minX() &&
               maxY > other.minY() && minY < other.maxY();
    }

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other
     *          the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    @Override
    public boolean intersectsRectangle(Rectanglefc other) {
        return minX < other.maxX() && maxX > other.minX() &&
               maxY > other.minY() && minY < other.maxY();
    }

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other
     *          the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    @Override
    public boolean intersectsRectangle(Rectanglei other) {
        return minX < other.maxX && maxX > other.minX &&
               maxY > other.minY && minY < other.maxY;
    }

    @Override
    public boolean containsPoint(Vector2dc point) {
        return containsPoint(point.x(), point.y());
    }

    @Override
    public boolean containsPoint(double x, double y) {
        return x > minX && y > minY && x < maxX && y < maxY;
    }

    /**
     * Translate <code>this</code> by the given vector <code>xy</code>.
     *
     * @param xy
     *          the vector to translate by
     * @return this
     */
    public Rectangled translate(Vector2dc xy) {
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
    @Override
    public Rectangled translate(Vector2dc xy, Rectangled dest) {
        return translate(xy.x(), xy.y(), dest);
    }

    /**
     * Translate <code>this</code> by the given vector <code>xy</code>.
     *
     * @param xy
     *          the vector to translate by
     * @return this
     */
    public Rectangled translate(Vector2fc xy) {
        return translate(xy.x(), xy.y(), this);
    }

    @Override
    public Rectangled translate(Vector2fc xy, Rectangled dest) {
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
    public Rectangled translate(double x, double y) {
        return translate(x, y, this);
    }

    @Override
    public Rectangled translate(double x, double y, Rectangled dest) {
        dest.minX = minX + x;
        dest.minY = minY + y;
        dest.maxX = maxX + x;
        dest.maxY = maxY + y;
        return dest;
    }

    /**
     * Scale <code>this</code> about the origin.
     *
     * @param sf
     *          the scaling factor in the x and y axis.
     * @return this
     */
    public Rectangled scale(double sf) {
        return scale(sf, sf);
    }

    @Override
    public Rectangled scale(double sf, Rectangled dest) {
        return scale(sf, sf, dest);
    }

    /**
     * Scale <code>this</code> about an anchor.
     * <p>
     * This is equivalent to <code>translate(-ax, -ay).scale(sf).translate(ax, ay)</code>
     *
     * @param sf
     *          the scaling factor in the x and y axis
     * @param ax
     *          the x coordinate of the anchor
     * @param ay
     *          the y coordinate of the anchor
     * @return this
     */
    public Rectangled scale(double sf, double ax, double ay) {
        return scale(sf, sf, ax, ay);
    }

    @Override
    public Rectangled scale(double sf, double ax, double ay, Rectangled dest) {
        return scale(sf, sf, ax, ay, dest);
    }

    /**
     * Scale <code>this</code> about an anchor.
     * <p>
     * This is equivalent to <code>translate(anchor.negate()).scale(sf).translate(anchor.negate())</code>
     *
     * @param sf
     *          the scaling factor in the x and y axis
     * @param anchor
     *          the location of the anchor
     * @return this
     */
    public Rectangled scale(double sf, Vector2dc anchor) {
        return scale(sf, anchor.x(), anchor.y());
    }

    @Override
    public Rectangled scale(double sf, Vector2dc anchor, Rectangled dest) {
        return scale(sf, anchor.x(), anchor.y(), dest);
    }

    /**
     * Scale <code>this</code> about the origin.
     *
     * @param sx
     *          the scaling factor on the x axis
     * @param sy
     *          the scaling factor on the y axis
     * @return this
     */
    public Rectangled scale(double sx, double sy) {
        return scale(sx, sy, 0d, 0d);
    }

    /**
     * Scale <code>this</code> about the origin and store the result in <code>dest</code>.
     *
     * @param sx
     *          the scaling factor on the x axis
     * @param sy
     *          the scaling factor on the y axis
     * @param dest
     *          will hold the result
     * @return dest
     */
    @Override
    public Rectangled scale(double sx, double sy, Rectangled dest) {
        return scale(sx, sy, 0d, 0d, dest);
    }

    /**
     * Scale <code>this</code> about an anchor.
     * <p>
     * This is equivalent to <code>translate(-ax, -ay).scale(sx, sy).translate(ax, ay)</code>
     *
     * @param sx
     *          the scaling factor on the x axis
     * @param sy
     *          the scaling factor on the y axis
     * @param ax
     *          the x coordinate of the anchor
     * @param ay
     *          the y coordinate of the anchor
     * @return this
     */
    public Rectangled scale(double sx, double sy, double ax, double ay) {
        minX = (minX - ax) * sx + ax;
        minY = (minY - ay) * sy + ay;
        maxX = (maxX - ax) * sx + ax;
        maxY = (maxY - ay) * sy + ay;
        return this;
    }

    /**
     * Scale <code>this</code> about an anchor.
     * <p>
     * This is equivalent to <code>translate(anchor.negate()).scale(sx, sy).translate(anchor.negate())</code>
     *
     * @param sx
     *          the scaling factor on the x axis
     * @param sy
     *          the scaling factor on the y axis
     * @param anchor
     *          the location of the anchor
     * @return this
     */
    public Rectangled scale(double sx, double sy, Vector2dc anchor) {
        return scale(sx, sy, anchor.x(), anchor.y());
    }

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
     * <p>
     * This is equivalent to <code>translate(-ax, -ay, dest).scale(sx, sy).translate(ax, ay)</code>
     *
     * @param sx
     *          the scaling factor on the x axis
     * @param sy
     *          the scaling factor on the y axis
     * @param ax
     *          the x coordinate of the anchor
     * @param ay
     *          the y coordinate of the anchor
     * @param dest
     *          will hold the result
     * @return dest
     */
    @Override
    public Rectangled scale(double sx, double sy, double ax, double ay, Rectangled dest) {
        dest.minX = (minX - ax) * sx + ax;
        dest.minY = (minY - ay) * sy + ay;
        dest.maxX = (maxX - ax) * sx + ax;
        dest.maxY = (maxY - ay) * sy + ay;
        return dest;
    }

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
     * <p>
     * This is equivalent to <code>translate(anchor.negate(), dest).scale(sx, sy).translate(anchor.negate())</code>
     *
     * @param sx
     *          the scaling factor on the x axis
     * @param sy
     *          the scaling factor on the y axis
     * @param anchor
     *          the location of the anchor
     * @param dest
     *          will hold the result
     * @return dest
     */
    @Override
    public Rectangled scale(double sx, double sy, Vector2dc anchor, Rectangled dest) {
        return scale(sx, sy, anchor.x(), anchor.y(), dest);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(maxX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(minX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(minY);
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
        Rectangled other = (Rectangled) obj;
        if (Double.doubleToLongBits(maxX) != Double.doubleToLongBits(other.maxX))
            return false;
        if (Double.doubleToLongBits(maxY) != Double.doubleToLongBits(other.maxY))
            return false;
        if (Double.doubleToLongBits(minX) != Double.doubleToLongBits(other.minX))
            return false;
        if (Double.doubleToLongBits(minY) != Double.doubleToLongBits(other.minY))
            return false;
        return true;
    }

    /**
     * Return a string representation of this rectangle.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<code>0.000E0;-</code>".
     *
     * @return the string representation
     */
    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    /**
     * Return a string representation of this rectangle by formatting the vector components with the given {@link NumberFormat}.
     *
     * @param formatter
     *          the {@link NumberFormat} used to format the vector components with
     * @return the string representation
     */
    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(minX, formatter) + " " + Runtime.format(minY, formatter) + ") < "
             + "(" + Runtime.format(maxX, formatter) + " " + Runtime.format(maxY, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(minX);
        out.writeDouble(minY);
        out.writeDouble(maxX);
        out.writeDouble(maxY);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        minX = in.readDouble();
        minY = in.readDouble();
        maxX = in.readDouble();
        maxY = in.readDouble();
    }

}
