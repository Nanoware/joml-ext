package org.terasology.primitives;

public interface Planedc {
    double a();
    double b();
    double c();
    double d();

    /**
     * Normalize this plane and store the result in <code>dest</code>.
     *
     * @param dest
     *          will hold the result
     * @return dest
     */
    Planed normalize(Planed dest);

    /**
     * Test whether <code>this</code> and <code>other</code> intersect.
     *
     * @param other
     *          the other {@link Shape3D}
     * @return <code>true</code> iff both {@link Shape3D}s intersect; <code>false</code> otherwise
     */
    boolean intersectsAABB(AABBdc other);

    /**
     * Test whether <code>this</code> and <code>other</code> intersect.
     *
     * @param other
     *          the other {@link Shape3D}
     * @return <code>true</code> iff both {@link Shape3D}s intersect; <code>false</code> otherwise
     */
    boolean intersectsAABB(AABBfc other);

    /**
     * Test whether this {@link Shape3D} intersects the given sphere with equation
     * <code>(x - centerX)^2 + (y - centerY)^2 + (z - centerZ)^2 - radiusSquared = 0</code>.
     * <p>
     * Reference: <a href="http://stackoverflow.com/questions/4578967/cube-sphere-intersection-test#answer-4579069">http://stackoverflow.com</a>
     *
     * @param centerX
     *          the x coordinate of the center of the sphere
     * @param centerY
     *          the y coordinate of the center of the sphere
     * @param centerZ
     *          the z coordinate of the center of the sphere
     * @param radiusSquared
     *          the radius of the sphere
     * @return <code>true</code> iff this {@link Shape3D} and the sphere intersect; <code>false</code> otherwise
     */
    boolean intersectsSphere(double centerX, double centerY, double centerZ, double radius) ;

    /**
     * Test whether this {@link Shape3D} intersects the given sphere with equation
     * <code>(x - centerX)^2 + (y - centerY)^2 + (z - centerZ)^2 - radiusSquared = 0</code>.
     * <p>
     * Reference: <a href="http://stackoverflow.com/questions/4578967/cube-sphere-intersection-test#answer-4579069">http://stackoverflow.com</a>
     *
     * @param centerX
     *          the x coordinate of the center of the sphere
     * @param centerY
     *          the y coordinate of the center of the sphere
     * @param centerZ
     *          the z coordinate of the center of the sphere
     * @param radius
     *          the radius of the sphere
     * @return <code>true</code> iff this {@link Shape3D} and the sphere intersect; <code>false</code> otherwise
     */
    boolean intersectsSphere(float centerX, float centerY, float centerZ, float radius) ;


    /**
     * Test whether this {@link Shape3D} intersects the given sphere.
     * <p>
     * Reference: <a href="http://stackoverflow.com/questions/4578967/cube-sphere-intersection-test#answer-4579069">http://stackoverflow.com</a>
     *
     * @param sphere
     *          the sphere
     * @return <code>true</code> iff this {@link Shape3D} and the sphere intersect; <code>false</code> otherwise
     */
    boolean intersectsSphere(Spherefc sphere);


    /**
     * Test whether this {@link Shape3D} intersects the given sphere.
     * <p>
     * Reference: <a href="http://stackoverflow.com/questions/4578967/cube-sphere-intersection-test#answer-4579069">http://stackoverflow.com</a>
     *
     * @param sphere
     *          the sphere
     * @return <code>true</code> iff this {@link Shape3D} and the sphere intersect; <code>false</code> otherwise
     */
    boolean intersectsSphere(Spheredc sphere);

    /**
     * Test whether the given ray with the origin <code>(originX, originY, originZ)</code> and direction <code>(dirX, dirY, dirZ)</code>
     * intersects this {@link Shape3D}.
     * <p>
     * This method returns <code>true</code> for a ray whose origin lies inside this {@link Shape3D}.
     * <p>
     * Reference: <a href="https://dl.acm.org/citation.cfm?id=1198748">An Efficient and Robust Ray–Box Intersection</a>
     *
     * @param originX
     *          the x coordinate of the ray's origin
     * @param originY
     *          the y coordinate of the ray's origin
     * @param originZ
     *          the z coordinate of the ray's origin
     * @param dirX
     *          the x coordinate of the ray's direction
     * @param dirY
     *          the y coordinate of the ray's direction
     * @param dirZ
     *          the z coordinate of the ray's direction
     * @return <code>true</code> if this {@link Shape3D} and the ray intersect; <code>false</code> otherwise
     */
    double intersectsRay(float originX, float originY, float originZ, float dirX, float dirY, float dirZ) ;


    /**
     * Test whether the given ray with the origin <code>(originX, originY, originZ)</code> and direction <code>(dirX, dirY, dirZ)</code>
     * intersects this {@link Shape3D}.
     * <p>
     * This method returns <code>true</code> for a ray whose origin lies inside this {@link Shape3D}.
     * <p>
     * Reference: <a href="https://dl.acm.org/citation.cfm?id=1198748">An Efficient and Robust Ray–Box Intersection</a>
     *
     * @param originX
     *          the x coordinate of the ray's origin
     * @param originY
     *          the y coordinate of the ray's origin
     * @param originZ
     *          the z coordinate of the ray's origin
     * @param dirX
     *          the x coordinate of the ray's direction
     * @param dirY
     *          the y coordinate of the ray's direction
     * @param dirZ
     *          the z coordinate of the ray's direction
     * @return <code>true</code> if this {@link Shape3D} and the ray intersect; <code>false</code> otherwise
     */
    double intersectsRay(double originX, double originY, double originZ, double dirX, double dirY, double dirZ) ;

    /**
     * Test whether the given ray intersects this {@link Shape3D}.
     * <p>
     * This method returns <code>true</code> for a ray whose origin lies inside this {@link Shape3D}.
     * <p>
     * Reference: <a href="https://dl.acm.org/citation.cfm?id=1198748">An Efficient and Robust Ray–Box Intersection</a>
     *
     * @param ray
     *          the ray
     * @return <code>true</code> if this {@link Shape3D} and the ray intersect; <code>false</code> otherwise
     */
    double intersectsRay(Rayd ray);

    /**
     * Test whether the given ray intersects this {@link Shape3D}.
     * <p>
     * This method returns <code>true</code> for a ray whose origin lies inside this {@link Shape3D}.
     * <p>
     * Reference: <a href="https://dl.acm.org/citation.cfm?id=1198748">An Efficient and Robust Ray–Box Intersection</a>
     *
     * @param ray
     *          the ray
     * @return <code>true</code> if this {@link Shape3D} and the ray intersect; <code>false</code> otherwise
     */
    double intersectsRay(Rayf ray);




}
