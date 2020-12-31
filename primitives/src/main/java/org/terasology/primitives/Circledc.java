package org.terasology.primitives;

import org.joml.Vector2dc;
import org.joml.Vector2fc;

public interface Circledc{
    double x();
    double y();
    double r();

    Circled translate(double x, double y, Circled dest);

    Circled translate(Vector2fc xy, Circled dest);

    Circled translate(Vector2dc xy, Circled dest);

    boolean containsPoint(Vector2dc point);

    boolean intersectsRectangle(Rectangledc other);
//
//    boolean intersectsRectangle(Rectanglefc other);
//
//    boolean intersectsRectangle(Rectangleic other);

    boolean intersectsCircle(Circlefc other);

    boolean intersectsCircle(Circledc other);

}
