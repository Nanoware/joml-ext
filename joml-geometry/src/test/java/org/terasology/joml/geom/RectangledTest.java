// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangledTest {

    @Test
    public void testRectangleContainsPoints() {
        Rectangled rect = new Rectangled(0, 0, 3, 3);

        assertTrue(rect.isValid());
        assertFalse(rect.containsPoint(new Vector2d(0, 0)));
        assertTrue(rect.containsPoint(new Vector2d(1, 1)));
        assertFalse(rect.containsPoint(new Vector2d(-1, -1)));
        assertFalse(rect.containsPoint(new Vector2d(4, 4)));
    }

    @Test
    public void testRectangleIntersection() {
        Rectangled first = new Rectangled(0, 0, 3, 3);
        Rectangled second = new Rectangled(-1, -1, 2, 2);

        // is valid
        assertTrue(first.isValid());
        assertTrue(second.isValid());

        assertFalse(first.containsRectangle(second));
        assertFalse(second.containsRectangle(first));

        assertTrue(first.intersectsRectangle(second));
        assertTrue(second.intersectsRectangle(first));
        assertEquals(first.intersection(second, new Rectangled()), new Rectangled(0, 0, 2, 2));

    }

    @Test
    public void testRectangleContains() {
        Rectangled first = new Rectangled(-1, -1, 2, 2);
        Rectangled second = new Rectangled(0, 0, 1, 1);
        assertTrue(first.containsRectangle(second));
        assertFalse(second.containsRectangle(first));

        assertTrue(first.intersectsRectangle(second));
        assertTrue(second.intersectsRectangle(first));

        assertEquals(first.intersection(second, new Rectangled()), new Rectangled(0, 0, 1, 1));
    }

    @Test
    public void testZeroSizeRectangle() {
        Rectangled rect = new Rectangled(0, 0, 0, 0);
        assertFalse(rect.isValid());
    }

    @Test
    public void testRectangleFromPoint() {
        Rectangled rect = new Rectangled(1,1);
        assertFalse(rect.isValid());
        assertFalse(rect.containsPoint(1,1));
    }
}
