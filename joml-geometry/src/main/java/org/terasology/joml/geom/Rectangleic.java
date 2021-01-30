// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Math;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;

public interface Rectangleic {
    int minX();

    int minY();

    int maxX();

    int maxY();

    /**
     * Return the length of the rectangle in the X dimension.
     *
     * @return length in the X dimension
     */
    int getSizeX();

    /**
     * Return the length of the rectangle in the Y dimension.
     *
     * @return length in the Y dimension
     */
    int getSizeY();

    /**
     * Return the size of this rectangle in the X and Y dimensions and store the result in <code>dest</code>.
     *
     * @param dest will hold the result
     * @return dest
     */
    Vector2i getSize(Vector2i dest);

    /**
     * Return the area of the rectangle
     *
     * @return area
     */
    int area();

    /**
     * Compute the union of <code>this</code> and the given point <code>(x, y, z)</code> and store the result in <code>dest</code>.
     *
     * @param x    the x coordinate of the point
     * @param y    the y coordinate of the point
     * @param dest will hold the result
     * @return dest
     */
    Rectanglei union(int x, int y, Rectanglei dest);

    /**
     * Compute the union of <code>this</code> and the given point <code>p</code> and store the result in <code>dest</code>.
     *
     * @param p
     *          the point
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei union(Vector2ic p, Rectanglei dest);

    /**
     * Compute the union of <code>this</code> and <code>other</code> and store the result in <code>dest</code>.
     *
     * @param other the other {@link Rectanglei}
     * @param dest  will hold the result
     * @return dest
     */
    Rectanglei union(Rectanglei other, Rectanglei dest);


    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    boolean intersectsRectangle(Rectangled other);

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    boolean intersectsRectangle(Rectanglef other);

    /**
     * Check if this and the given rectangle intersect.
     *
     * @param other the other rectangle
     * @return <code>true</code> iff both rectangles intersect; <code>false</code> otherwise
     */
    boolean intersectsRectangle(Rectanglei other);

    /**
     * Check whether <code>this</code> rectangle represents a valid rectangle.
     *
     * @return <code>true</code> iff this rectangle is valid; <code>false</code> otherwise
     */
    boolean isValid();

    /**
     * Compute the rectangle of intersection between <code>this</code> and the given rectangle and
     * store the result in <code>dest</code>.
     * <p>
     * If the two rectangles do not intersect, then the minimum coordinates of <code>dest</code>
     * will have a value of {@link Integer#MAX_VALUE} and the maximum coordinates will have a value of
     * {@link Integer#MIN_VALUE}.
     *
     * @param other
     *          the other rectangle
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei intersection(Rectangleic other, Rectanglei dest);

    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle
     *          the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    boolean containsRectangle(Rectangledc rectangle);


    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle
     *          the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    boolean containsRectangle(Rectanglefc rectangle);

    /**
     * Check if this rectangle contains the given <code>rectangle</code>.
     *
     * @param rectangle
     *          the rectangle to test
     * @return <code>true</code> iff this rectangle contains the rectangle; <code>false</code> otherwise
     */
    boolean containsRectangle(Rectangleic rectangle);

    /**
     * Check if this rectangle contains the given <code>point</code>.
     *
     * @param point
     *          the point to test
     * @return <code>true</code> iff this rectangle contains the point; <code>false</code> otherwise
     */
    boolean containsPoint(Vector2ic point);

    /**
     * Test whether the point <code>(x, y)</code> lies inside this BlockRegion.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     * @return <code>true</code> iff the given point lies inside this BlockRegion; <code>false</code> otherwise
     */
    boolean containsPoint(float x, float y);

    /**
     * Test whether the point <code>(x, y)</code> lies inside this BlockRegion.
     *
     * @param point
     *          the point to test
     * @return <code>true</code> iff the given point lies inside this BlockRegion; <code>false</code> otherwise
     */
    boolean containsPoint(Vector2fc point);

    /**
     * Check if this rectangle contains the given point <code>(x, y)</code>.
     *
     * @param x
     *          the x coordinate of the point to check
     * @param y
     *          the y coordinate of the point to check
     * @return <code>true</code> iff this rectangle contains the point; <code>false</code> otherwise
     */
    boolean containsPoint(int x, int y);

    /**
     * Translate <code>this</code> by the given vector <code>xy</code> and store the result in <code>dest</code>.
     *
     * @param xy
     *          the vector to translate by
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei translate(Vector2ic xy, Rectanglei dest);


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
    Rectanglei translate(int x, int y, Rectanglei dest);

    /**
     * Scale <code>this</code> about the origin and store the result in <code>dest</code>.
     *
     * @param sf
     *          the scaling factor in the x and y axis
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei scale(int sf, Rectanglei dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
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
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei scale(int sf, int ax, int ay, Rectanglei dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
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
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei scale(int sf, Vector2ic anchor, Rectanglei dest);

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
    Rectanglei scale(int sx, int sy, Rectanglei dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
     * <p>
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
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei scale(int sx, int sy, int ax, int ay, Rectanglei dest);

    /**
     * Scale <code>this</code> about an anchor and store the result in <code>dest</code>.
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
     * @param dest
     *          will hold the result
     * @return dest
     */
    Rectanglei scale(int sx, int sy, Vector2ic anchor, Rectanglei dest);

    /**
     * Computes the squared distance to a given point
     * @param point the point
     * @return the squared distance between point and this rectangle
     */
    default long distanceSquared(Vector2ic point) {
        return distanceSquared(point.x(), point.y());
    }

    /**
     * Computes the squared distance to a given point
     *
     * @param px the point x coordinate
     * @param py the point y coordinate
     * @return the squared distance between point and this rectangle
     * @see
     * <a href="https://codereview.stackexchange.com/questions/175566/compute-shortest-distance-between-point-and-a-rectangle">
     *         Compute Shortest Distance Between Point and a Rectangle</a>
     */
    default long distanceSquared(int px, int py) {
        //     center = min + width / 2 = min + (max - min) / 2
        // 2 * center = 2 * min + max - min = min + max
        int cx2 = minX() + maxX();
        int cy2 = minY() + maxY();

        //     dx = p - center - width / 2
        // 2 * dx = 2 * px - 2 * center - width
        //     dx = (2 * px - 2 * center - width) / 2
        long dx = Math.max(Math.abs(2 * px - cx2) - getSizeX(), 0) / 2;
        long dy = Math.max(Math.abs(2 * py - cy2) - getSizeY(), 0) / 2;
        return dx * dx + dy * dy;
    }

}
