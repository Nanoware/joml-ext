/*
 * The MIT License
 *
 * Copyright (c) 2017-2020 JOML
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.terasology.primitives;

import org.joml.Options;
import org.joml.Vector2d;
import org.joml.Vector2f;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Runtime;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Represents a 3D sphere.
 *
 * @author Kai Burjack
 */
public class Sphered implements Externalizable, Spheredc {

    /**
     * The x coordinate of the sphere's center.
     */
    public double x;
    /**
     * The y coordinate of the sphere's center.
     */
    public double y;
    /**
     * The z coordinate of the sphere's center.
     */
    public double z;
    /**
     * The sphere's radius.
     */
    public double r;

    /**
     * Create a new {@link Sphered} with center position <code>(0, 0, 0)</code> and radius = <code>0</code>.
     */
    public Sphered() {
    }

    /**
     * Create a new {@link Sphered} as a copy of the given <code>source</code>.
     *
     * @param source
     *          the {@link Sphered} to copy from
     */
    public Sphered(Sphered source) {
        this.x = source.x;
        this.y = source.y;
        this.z = source.z;
        this.r = source.r;
    }

    /**
     * Create a new {@link Sphered} with center position <code>c</code> and radius <code>r</code>.
     *
     * @param c
     *          the center position of the sphere
     * @param r
     *          the radius of the sphere
     */
    public Sphered(Vector3fc c, double r) {
        this.x = c.x();
        this.y = c.y();
        this.z = c.z();
        this.r = r;
    }

    /**
     * Create a new {@link Sphered} with center position <code>c</code> and radius <code>r</code>.
     *
     * @param c
     *          the center position of the sphere
     * @param r
     *          the radius of the sphere
     */
    public Sphered(Vector3dc c, double r) {
        this.x = c.x();
        this.y = c.y();
        this.z = c.z();
        this.r = r;
    }

    /**
     * Create a new {@link Sphered} with center position <code>(x, y, z)</code> and radius <code>r</code>.
     *
     * @param x
     *          the x coordinate of the sphere's center
     * @param y
     *          the y coordinate of the sphere's center
     * @param z
     *          the z coordinate of the sphere's center
     * @param r
     *          the radius of the sphere
     */
    public Sphered(double x, double y, double z, double r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public double r() {
        return this.r;
    }

    /**
     * Translate <code>this</code> by the given vector <code>xyz</code>.
     *
     * @param xyz
     *          the vector to translate by
     * @return this
     */
    public Sphered translate(Vector3dc xyz) {
        return translate(xyz.x(), xyz.y(), xyz.z(), this);
    }


    public Sphered translate(Vector3dc xyz, Sphered dest) {
        return translate(xyz.x(), xyz.y(), xyz.z(), dest);
    }

    /**
     * Translate <code>this</code> by the given vector <code>xyz</code>.
     *
     * @param xyz
     *          the vector to translate by
     * @return this
     */
    public Sphered translate(Vector3fc xyz) {
        return translate(xyz.x(), xyz.y(), xyz.z(), this);
    }


    public Sphered translate(Vector3fc xyz, Sphered dest) {
        return translate(xyz.x(), xyz.y(), xyz.z(), dest);
    }

    /**
     * Translate <code>this</code> by the vector <code>(x, y, z)</code>.
     *
     * @param x
     *          the x coordinate to translate by
     * @param y
     *          the y coordinate to translate by
     * @param z
     *          the z coordinate to translate by
     * @return this
     */
    public Sphered translate(double x, double y, double z) {
        return translate(x, y, z, this);
    }

    public Sphered translate(double x, double y, double z, Sphered dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        dest.z = this.z + z;
        return dest;
    }

    public boolean containsPoint(double x, double y, double z) {
        double dx = this.x - x;
        double dy = this.y - y;
        double dz = this.z - z;
        double d = dx * dx + dy * dy + dz * dz;
        return r * r <= d;
    }

    public boolean containsPoint(float x, float y, float z) {
        double dx = this.x - x;
        double dy = this.y - y;
        double dz = this.z - z;
        double d = dx * dx + dy * dy + dz * dz;
        return r * r <= d;
    }

    public boolean containsPoint(Vector3dc point) {
        double dx = this.x - point.x();
        double dy = this.y - point.y();
        double dz = this.z - point.z();
        double d = dx * dx + dy * dy + dz * dz;
        return r * r <= d;
    }

    public boolean containsPoint(Vector3fc point) {
        double dx = this.x - point.x();
        double dy = this.y - point.y();
        double dz = this.z - point.z();
        double d = dx * dx + dy * dy + dz * dz;
        return r * r <= d;
    }

    public boolean intersectsPlane(double a, double b, double c, double d) {
        return Intersectiond.testPlaneSphere(a, b, c, d, x, y, z, r);
    }

    public boolean intersectsPlane(float a, float b, float c, float d) {
        return Intersectiond.testPlaneSphere(a, b, c, d, x, y, z, r);
    }

    public boolean intersectsPlane(Planefc plane) {
        return Intersectionf.testPlaneSphere(plane.a(), plane.b(), plane.c(), plane.d(), (float) x, (float)y, (float)z, (float)r);
    }

    public boolean intersectsPlane(Planedc plane) {
        return Intersectiond.testPlaneSphere(plane.a(), plane.b(), plane.c(), plane.d(), x, y, z, r);
    }

    public boolean intersectsAABB(AABBdc other) {
        return Intersectiond.testAabSphere(other.minX(), other.minY(), other.minZ(), other.maxX(), other.maxY(), other.maxZ(), x, y, z, r * r);
    }

    public boolean intersectsAABB(AABBfc other) {
        return Intersectiond.testAabSphere(other.minX(), other.minY(), other.minZ(), other.maxX(), other.maxY(), other.maxZ(), x, y, z, r * r);
    }

    public boolean intersectsSphere(double centerX, double centerY, double centerZ, double radiusSquared) {
        return Intersectiond.testSphereSphere(x, y, z, r * r, centerX, centerY, centerZ, radiusSquared);
    }

    public boolean intersectsSphere(float centerX, float centerY, float centerZ, float radiusSquared) {
        return Intersectiond.testSphereSphere(x, y, z, r * r, centerX, centerY, centerZ, radiusSquared);
    }

    public boolean intersectsSphere(Spherefc sphere) {
        return Intersectiond.testSphereSphere(x, y, z, r * r, sphere.x(), sphere.y(), sphere.z(), sphere.r() * sphere.r());
    }

    public boolean intersectsSphere(Spheredc sphere) {
        return Intersectiond.testSphereSphere(x, y, z, r * r, sphere.x(), sphere.y(), sphere.z(), sphere.r() * sphere.r());
    }

    public boolean intersectsRay(float originX, float originY, float originZ, float dirX, float dirY, float dirZ) {
        return Intersectiond.testRaySphere(originX, originY, originZ, dirX, dirY, dirZ, x, y, z, r * r);
    }

    public boolean intersectsRay(double originX, double originY, double originZ, double dirX, double dirY, double dirZ) {
        return Intersectiond.testRaySphere(originX, originY, originZ, dirX, dirY, dirZ, x, y, z, r * r);
    }

    public boolean intersectsRay(double originX, double originY, double originZ, double dirX, double dirY, double dirZ, Vector2d result) {
        return Intersectiond.intersectRaySphere(originX, originY, originZ, dirX, dirY, dirZ, x, y, z, r * r, result);
    }

    public boolean intersectsRay(float originX, float originY, float originZ, float dirX, float dirY, float dirZ, Vector2f result) {
        return Intersectionf.intersectRaySphere(originX, originY, originZ, dirX, dirY, dirZ, (float) x, (float) y, (float) z, (float) (r * r), result);
    }

    public boolean intersectsRay(Rayd ray) {
        return Intersectiond.testRaySphere(ray.oX, ray.oY, ray.oZ, ray.dX, ray.dY, ray.dZ, x, y, z, r * r);
    }

    public boolean intersectsRay(Rayf ray) {
        return Intersectionf.testRaySphere(ray.oX, ray.oY, ray.oZ, ray.dX, ray.dY, ray.dZ, (float)x, (float)y, (float)z, (float)(r * r));
    }

    public boolean intersectsRay(Rayf ray, Vector2f result) {
        return Intersectionf.intersectRaySphere(ray.oX, ray.oY, ray.oZ, ray.dX, ray.dY, ray.dZ, (float) x, (float) y, (float) z, (float) (r * r), result);
    }

    public boolean intersectsRay(Rayd ray, Vector2d result) {
        return Intersectiond.intersectRaySphere(ray.oX, ray.oY, ray.oZ, ray.dX, ray.dY, ray.dZ, x, y, z, r * r, result);
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
        temp = Double.doubleToLongBits(z);
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
        Sphered other = (Sphered) obj;
        if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
            return false;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
            return false;
        return true;
    }

    /**
     * Return a string representation of this sphere.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<code>0.000E0;-</code>".
     *
     * @return the string representation
     */
    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    /**
     * Return a string representation of this sphere by formatting the components with the given {@link NumberFormat}.
     *
     * @param formatter
     *          the {@link NumberFormat} used to format the components with
     * @return the string representation
     */
    public String toString(NumberFormat formatter) {
        return "[" + Runtime.format(x, formatter) + " " + org.joml.Runtime.format(y, formatter) + " " + org.joml.Runtime.format(z, formatter) + " " + org.joml.Runtime.format(r, formatter) + "]";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(z);
        out.writeDouble(r);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readDouble();
        y = in.readDouble();
        z = in.readDouble();
        r = in.readDouble();
    }
}
