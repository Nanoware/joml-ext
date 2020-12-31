package org.terasology.primitives;

import org.joml.Vector2dc;
import org.joml.Vector2fc;

public interface Circlefc {

    float x();
    float y();
    float r();

    /**
     * Translate <code>this</code> by the given vector <code>xy</code> and store the result in <code>dest</code>.
     *
     * @param xy   the vector to translate by
     * @param dest will hold the result
     * @return dest
     */
    Circlef translate(Vector2fc xy, Circlef dest);

    /**
     * Translate <code>this</code> by the vector <code>(x, y)</code> and store the result in <code>dest</code>.
     *
     * @param x    the x coordinate to translate by
     * @param y    the y coordinate to translate by
     * @param dest will hold the result
     * @return dest
     */
    Circlef translate(float x, float y, Circlef dest);

    boolean containsPoint(double x, double y);

    boolean containsPoint(float x, float y);

    boolean containsPoint(Vector2dc point);

//    boolean intersectsRectangle(Rectangledc other);
//
//    boolean intersectsRectangle(Rectanglefc other);
//
//    boolean intersectsRectangle(Rectangleic other);

    boolean intersectsCircle(Circlefc other);

    boolean intersectsCircle(Circledc other);
}
