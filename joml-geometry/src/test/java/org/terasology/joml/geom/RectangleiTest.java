// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Vector2i;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the {@link Rectanglei} class.
 */
public class RectangleiTest {
    @Test
    public void testRectangleContainsPoints() {
        Rectanglei rect = new Rectanglei(0, 0, 3, 3);

        assertTrue(rect.isValid());
        assertTrue(rect.containsPoint(new Vector2i(0, 0)));
        assertTrue(rect.containsPoint(new Vector2i(1, 1)));
        assertFalse(rect.containsPoint(new Vector2i(-1, -1)));
        assertFalse(rect.containsPoint(new Vector2i(4, 4)));
    }
    @Test
    public void testRectangleIntersection() {
        Rectanglei first = new Rectanglei(0, 0, 3, 3);
        Rectanglei second = new Rectanglei(-1, -1, 2, 2);

        // is valid
        assertTrue(first.isValid());
        assertTrue(second.isValid());

        assertFalse(first.containsRectangle(second));
        assertFalse(second.containsRectangle(first));

        assertTrue(first.intersectsRectangle(second));
        assertTrue(second.intersectsRectangle(first));
        assertEquals(first.intersection(second, new Rectanglei()), new Rectanglei(0, 0, 2, 2));

    }
    @Test
    public void testRectangleiEdgeIntersection() {
        Rectanglei center = new Rectanglei(0, 0, 1, 1);
        Rectanglei right = new Rectanglei(1, 0, 2, 1);
        Rectanglei left = new Rectanglei(-1, 0, 0, 1);
        Rectanglei top = new Rectanglei(0, 1, 1, 2);
        Rectanglei bottom = new Rectanglei(0, -1, 1, 0);

        assertTrue(center.isValid());
        assertTrue(right.isValid());
        assertTrue(left.isValid());
        assertTrue(top.isValid());
        assertTrue(bottom.isValid());

        assertFalse(center.containsRectangle(right));
        assertFalse(center.containsRectangle(left));
        assertFalse(center.containsRectangle(top));
        assertFalse(center.containsRectangle(bottom));

        assertTrue(center.intersectsRectangle(right));
        assertTrue(center.intersectsRectangle(left));
        assertTrue(center.intersectsRectangle(top));
        assertTrue(center.intersectsRectangle(bottom));

        assertTrue(right.intersectsRectangle(center));
        assertTrue(left.intersectsRectangle(center));
        assertTrue(top.intersectsRectangle(center));
        assertTrue(bottom.intersectsRectangle(center));
    }
    @Test
    public void testRectangleiContainsPoint() {
        Rectanglei center = new Rectanglei(0, 0, 3, 3);

        assertTrue(center.isValid());

        assertTrue(center.containsPoint(0, 0));
        assertTrue(center.containsPoint(1, 0));
        assertTrue(center.containsPoint(0, 1));
        assertTrue(center.containsPoint(1, 1));
    }
    @Test
    public void testRectangleContains() {
        Rectanglei first = new Rectanglei(-1, -1, 2, 2);
        Rectanglei second = new Rectanglei(0, 0, 1, 1);
        assertTrue(first.containsRectangle(second));
        assertFalse(second.containsRectangle(first));

        assertTrue(first.intersectsRectangle(second));
        assertTrue(second.intersectsRectangle(first));

        assertEquals(first.intersection(second, new Rectanglei()), new Rectanglei(0, 0, 1, 1));
    }
    @Test
    public void testZeroSizeRectangle() {
        Rectanglei rect = new Rectanglei(0, 0, 0, 0);
        assertFalse(rect.isValid());
    }
}
