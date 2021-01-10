// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Math;
import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Represents a 2D axis-aligned rectangle.
 */
public class Rectanglei implements Externalizable, Rectangleic {

    /**
     * The x coordinate of the minimum corner.
     */
    public int minX;
    /**
     * The y coordinate of the minimum corner.
     */
    public int minY;
    /**
     * The x coordinate of the maximum corner.
     */
    public int maxX;
    /**
     * The y coordinate of the maximum corner.
     */
    public int maxY;

    /**
     * Create a new {@link Rectanglei} with a minimum and maximum corner of <code>(0, 0)</code>.
     */
    public Rectanglei() {
    }

    /**
     * Create a new {@link Rectanglei} as a copy of the given <code>source</code>.
     *
     * @param source
     *          the {@link Rectanglei} to copy from
     */
    public Rectanglei(Rectanglei source) {
        this.minX = source.minX;
        this.minY = source.minY;
        this.maxX = source.maxX;
        this.maxY = source.maxY;
    }

    /**
     * Create a new {@link Rectanglei} with the given <code>min</code> and <code>max</code> corner coordinates.
     *
     * @param min
     *          the minimum coordinates
     * @param max
     *          the maximum coordinates
     */
    public Rectanglei(Vector2ic min, Vector2ic max) {
        this.minX = min.x();
        this.minY = min.y();
        this.maxX = max.x();
        this.maxY = max.y();
    }

    /**
     * Create a new {@link Rectanglei} with the given minimum and maximum corner coordinates.
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
    public Rectanglei(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public int minX() {
        return this.minX;
    }

    @Override
    public int minY() {
        return this.minY;
    }

    @Override
    public int maxX() {
        return this.maxX;
    }

    @Override
    public int maxY() {
        return this.maxY;
    }

    /**
     * Set this {@link Rectanglei} to be a clone of <code>source</code>.
     *
     * @param source
     *            the {@link Rectanglei} to copy from
     * @return this
     */
    public Rectanglei set(Rectanglei source){
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
    public Rectanglei setMin(int minX, int minY) {
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
    public Rectanglei setMin(Vector2ic min) {
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
    public Rectanglei setMax(int maxX, int maxY) {
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
    public Rectanglei setMax(Vector2ic max) {
        this.maxX = max.x();
        this.maxY = max.y();
        return this;
    }

    /**
     * Return the length of the rectangle in the X dimension.
     *
     * @return length in the X dimension
     * @deprecated use {@link #getSizeX()}
     */
    public int lengthX() {
        return maxX - minX;
    }

    @Override
    public int getSizeX() {
        return maxX - minX;
    }

    @Override
    public int getSizeY() {
        return maxY - minY;
    }

    @Override
    public Vector2i getSize(Vector2i dest) {
        return dest.set(getSizeX(), getSizeY());
    }

    /**
     * Return the length of the rectangle in the Y dimension.
     *
     * @return length in the Y dimension
     * @deprecated use {@link #getSizeY()}
     */
    public int lengthY() {
        return maxY - minY;
    }

    public int area() {
        return getSizeX() * getSizeY();
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
    public Rectanglei union(int x, int y) {
        return union(x,y, this);
    }


    /**
     * Set <code>this</code> to the union of <code>this</code> and the given point <code>p</code>.
     *
     * @param p
     *          the point
     * @return this
     */
    public Rectanglei union(Vector2ic p) {
        return union(p.x(), p.y(), this);
    }

    @Override
    public Rectanglei union(int x, int y, Rectanglei dest) {
        dest.minX = this.minX < x ? this.minX : x;
        dest.minY = this.minY < y ? this.minY : y;
        dest.maxX = this.maxX > x ? this.maxX : x;
        dest.maxY = this.maxY > y ? this.maxY : y;
        return dest;
    }

    @Override
    public Rectanglei union(Vector2ic p, Rectanglei dest) {
        return union(p.x(), p.y(), dest);
    }

    /**
     * Set <code>this</code> to the union of <code>this</code> and <code>other</code>.
     *
     * @param other
     *          the other {@link Rectanglei}
     * @return this
     */
    public Rectanglei union(Rectanglei other) {
        return this.union(other, this);
    }

    @Override
    public Rectanglei union(Rectanglei other, Rectanglei dest) {
        dest.minX = this.minX < other.minX ? this.minX : other.minX;
        dest.minY = this.minY < other.minY ? this.minY : other.minY;
        dest.maxX = this.maxX > other.maxX ? this.maxX : other.maxX;
        dest.maxY = this.maxY > other.maxY ? this.maxY : other.maxY;
        return dest;
    }

    @Override
    public boolean intersectsRectangle(Rectangled other) {
        return minX <= other.maxX && maxX >= other.minX &&
               maxY >= other.minY && minY <= other.maxY;
    }

    @Override
    public boolean intersectsRectangle(Rectanglef other) {
        return minX <= other.maxX && maxX >= other.minX &&
               maxY >= other.minY && minY <= other.maxY;
    }

    @Override
    public boolean intersectsRectangle(Rectanglei other) {
        return minX <= other.maxX && maxX >= other.minX &&
               maxY >= other.minY && minY <= other.maxY;
    }

    private Rectanglei validate() {
        if (!isValid()) {
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            maxY = Integer.MIN_VALUE;
        }
        return this;
    }

    @Override
    public boolean isValid() {
        return minX < maxX && minY < maxY;
    }

    /**
     * Compute the rectangle of intersection between <code>this</code> and the given rectangle.
     * <p>
     * If the two rectangles do not intersect, then the minimum coordinates of <code>this</code>
     * will have a value of {@link Integer#MAX_VALUE} and the maximum coordinates will have a value of
     * {@link Integer#MIN_VALUE}.
     *
     * @param other
     *          the other rectangle
     * @return this
     */
    public Rectanglei intersection(Rectanglei other) {
        return intersection(other, this);
    }

    @Override
    public Rectanglei intersection(Rectangleic other, Rectanglei dest) {
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
     * @deprecated Use {@link #getSize(Vector2i)}
     */
    public Vector2i lengths(Vector2i dest) {
        return dest.set(lengthX(), lengthY());
    }


    @Override
    public boolean containsRectangle(Rectangledc rectangle) {
        return rectangle.minX() >= minX && rectangle.maxX() <= maxX &&
               rectangle.minY() >= minY && rectangle.maxY() <= maxY;
    }

    @Override
    public boolean containsRectangle(Rectanglefc rectangle) {
        return rectangle.minX() >= minX && rectangle.maxX() <= maxX &&
               rectangle.minY() >= minY && rectangle.maxY() <= maxY;
    }


    @Override
    public boolean containsRectangle(Rectangleic rectangle) {
        return rectangle.minX() >= minX && rectangle.maxX() <= maxX &&
               rectangle.minY() >= minY && rectangle.maxY() <= maxY;
    }

    @Override
    public boolean containsPoint(Vector2ic point) {
        return containsPoint(point.x(), point.y());
    }


    @Override
    public boolean containsPoint(float x, float y) {
        return x >= this.minX && y >= this.minY && x <= this.maxX && y <= this.maxY;
    }

    @Override
    public boolean containsPoint(Vector2fc point) {
        return containsPoint(point.x(), point.y());
    }


    @Override
    public boolean containsPoint(int x, int y) {
        return x >= minX && y >= minY && x <= maxX && y <= maxY;
    }

    /**
     * Translate <code>this</code> by the given vector <code>xy</code>.
     *
     * @param xy
     *          the vector to translate by
     * @return this
     */
    public Rectanglei translate(Vector2ic xy) {
        return translate(xy.x(), xy.y(), this);
    }


    @Override
    public Rectanglei translate(Vector2ic xy, Rectanglei dest) {
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
    public Rectanglei translate(int x, int y) {
        return translate(x, y, this);
    }

    @Override
    public Rectanglei translate(int x, int y, Rectanglei dest) {
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
    public Rectanglei scale(int sf) {
        return scale(sf, sf);
    }


    @Override
    public Rectanglei scale(int sf, Rectanglei dest) {
        return scale(sf, sf, dest);
    }

    /**
     * Scale <code>this</code> about an anchor.
     * <p>
     * This is effectively equivalent to <br>
     * <pre>
     *     translate(-ax, -ay);
     *     scale(sf);
     *     translate(ax, ay);
     * </pre>
     *
     * @param sf
     *          the scaling factor in the x and y axis
     * @param ax
     *          the x coordinate of the anchor
     * @param ay
     *          the y coordinate of the anchor
     * @return this
     */
    public Rectanglei scale(int sf, int ax, int ay) {
        return scale(sf, sf, ax, ay);
    }


    @Override
    public Rectanglei scale(int sf, int ax, int ay, Rectanglei dest) {
        return scale(sf, sf, ax, ay, dest);
    }

    /**
     * Scale <code>this</code> about an anchor.
     * <p>
     * This is effectively equivalent to <br>
     * <pre>
     *     translate(anchor.negate());
     *     scale(sf);
     *     translate(anchor.negate());
     * </pre>
     *
     * @param sf
     *          the scaling factor in the x and y axis
     * @param anchor
     *          the location of the anchor
     * @return this
     */
    public Rectanglei scale(int sf, Vector2ic anchor) {
        return scale(sf, anchor.x(), anchor.y());
    }


    @Override
    public Rectanglei scale(int sf, Vector2ic anchor, Rectanglei dest) {
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
    public Rectanglei scale(int sx, int sy) {
        return scale(sx, sy, 0, 0);
    }


    @Override
    public Rectanglei scale(int sx, int sy, Rectanglei dest) {
        return scale(sx, sy, 0, 0, dest);
    }

    /**
     * Scale <code>this</code> about an anchor.
     * This is equivalent to <br>
     * <pre>
     *     translate(-ax, -ay);
     *     scale(sx, sy);
     *     translate(ax, ay);
     * </pre>
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
    public Rectanglei scale(int sx, int sy, int ax, int ay) {
        minX = (minX - ax) * sx + ax;
        minY = (minY - ay) * sy + ay;
        maxX = (maxX - ax) * sx + ax;
        maxY = (maxY - ay) * sy + ay;
        return this;
    }

    /**
     * Scale <code>this</code> about an anchor.
     * <p>
     * This is equivalent to <br>
     * <pre>
     *     translate(anchor.negate());
     *     scale(sx, sy);
     *     translate(anchor.negate());
     * </pre>
     *
     * @param sx
     *          the scaling factor on the x axis
     * @param sy
     *          the scaling factor on the y axis
     * @param anchor
     *          the location of the anchor
     * @return this
     */
    public Rectanglei scale(int sx, int sy, Vector2ic anchor) {
        return scale(sx, sy, anchor.x(), anchor.y());
    }


    @Override
    public Rectanglei scale(int sx, int sy, int ax, int ay, Rectanglei dest) {
        dest.minX = (minX - ax) * sx + ax;
        dest.minY = (minY - ay) * sy + ay;
        dest.maxX = (maxX - ax) * sx + ax;
        dest.maxY = (maxY - ay) * sy + ay;
        return dest;
    }

    @Override
    public Rectanglei scale(int sx, int sy, Vector2ic anchor, Rectanglei dest) {
        return scale(sx, sy, anchor.x(), anchor.y(), dest);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maxX;
        result = prime * result + maxY;
        result = prime * result + minX;
        result = prime * result + minY;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectanglei other = (Rectanglei) obj;
        if (maxX != other.maxX)
            return false;
        if (maxY != other.maxY)
            return false;
        if (minX != other.minX)
            return false;
        if (minY != other.minY)
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
        return "(" + formatter.format(minX) + " " + formatter.format(minY) + ") < "
             + "(" + formatter.format(maxX) + " " + formatter.format(maxY) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(minX);
        out.writeInt(minY);
        out.writeInt(maxX);
        out.writeInt(maxY);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        minX = in.readInt();
        minY = in.readInt();
        maxX = in.readInt();
        maxY = in.readInt();
    }

}
