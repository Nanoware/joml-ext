// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AABBiTest  {
    @Test
    public void testAABBiEdgeIntersection() {
        AABBi center = new AABBi(0, 0, 0, 1, 1,1);
        AABBi right = new AABBi(1, 0,0, 2, 1,1);
        AABBi left = new AABBi(-1, 0, 0, 0, 1,1);
        AABBi front = new AABBi(0, 1, 0, 1, 2,1);
        AABBi back = new AABBi(0, -1, 0, 1, 0,1);
        AABBi top = new AABBi(0, 0, 1, 1, 1,2);
        AABBi bottom = new AABBi(0, 0, -1, 1, 1,0);


        assertTrue(center.isValid());
        assertTrue(right.isValid());
        assertTrue(left.isValid());
        assertTrue(top.isValid());
        assertTrue(bottom.isValid());
        assertTrue(front.isValid());
        assertTrue(back.isValid());

        // check contains
        assertFalse(center.containsAABB(right));
        assertFalse(center.containsAABB(left));
        assertFalse(center.containsAABB(front));
        assertFalse(center.containsAABB(back));
        assertFalse(center.containsAABB(top));

        // test intersection
        assertTrue(center.intersectsAABB(right));
        assertTrue(center.intersectsAABB(left));
        assertTrue(center.intersectsAABB(front));
        assertTrue(center.intersectsAABB(back));
        assertTrue(center.intersectsAABB(top));

        assertTrue(right.intersectsAABB(center));
        assertTrue(left.intersectsAABB(center));
        assertTrue(front.intersectsAABB(center));
        assertTrue(back.intersectsAABB(center));
        assertTrue(top.intersectsAABB(center));
    }


    public void testAABBiCornerIntersection() {
        AABBi center = new AABBi(0, 0, 0, 1, 1,1);

        AABBi frontLeft = new AABBi(-1, 1,-1, 0, 2,0);
        AABBi frontRight = new AABBi(1, 1,-1, 2, 2,0);
        AABBi backLeft = new AABBi(-1, -1,-1, 0, 0,0);
        AABBi backRight = new AABBi(1, -1,-1, 2, 0,0);

        AABBi topFrontLeft = new AABBi(-1, 1,1, 0, 2,2);
        AABBi topFrontRight = new AABBi(1, 1,1, 2, 2,2);
        AABBi topBackLeft = new AABBi(-1, -1,1, 0, 0,2);
        AABBi topBackRight = new AABBi(1, -1,1, 2, 0,2);

        assertTrue(center.isValid());

        // bottom corners
        assertTrue(frontLeft.isValid());
        assertTrue(frontRight.isValid());
        assertTrue(backLeft.isValid());
        assertTrue(backRight.isValid());

        // top corners
        assertTrue(topFrontLeft.isValid());
        assertTrue(topFrontRight.isValid());
        assertTrue(topBackLeft.isValid());
        assertTrue(topBackRight.isValid());

        // test contains
        // top corners intersection
        assertFalse(topFrontLeft.containsAABB(center));
        assertFalse(topFrontRight.containsAABB(center));
        assertFalse(topBackLeft.containsAABB(center));
        assertFalse(topBackRight.containsAABB(center));

        // bottom corners intersection
        assertFalse(frontLeft.containsAABB(center));
        assertFalse(frontRight.containsAABB(center));
        assertFalse(backLeft.containsAABB(center));
        assertFalse(backRight.containsAABB(center));

        // test intersection
        // top corners intersection
        assertTrue(topFrontLeft.intersectsAABB(center));
        assertTrue(topFrontRight.intersectsAABB(center));
        assertTrue(topBackLeft.intersectsAABB(center));
        assertTrue(topBackRight.intersectsAABB(center));

        // bottom corners intersection
        assertTrue(frontLeft.intersectsAABB(center));
        assertTrue(frontRight.intersectsAABB(center));
        assertTrue(backLeft.intersectsAABB(center));
        assertTrue(backRight.intersectsAABB(center));

    }
}
