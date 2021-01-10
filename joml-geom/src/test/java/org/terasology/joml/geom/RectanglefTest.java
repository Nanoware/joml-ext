// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Vector2f;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the {@link Rectanglef} class.
 */
public class RectanglefTest {
    @Test
    public void testRectangleContainsPoints() {
        Rectanglef rect = new Rectanglef(0, 0, 3, 3);

        assertTrue(rect.isValid());
        assertFalse(rect.containsPoint(new Vector2f(0, 0)));
        assertTrue(rect.containsPoint(new Vector2f(1, 1)));
        assertFalse(rect.containsPoint(new Vector2f(-1, -1)));
        assertFalse(rect.containsPoint(new Vector2f(4, 4)));
    }

    @Test
    public void testRectangleIntersection() {
        Rectanglef first = new Rectanglef(0, 0, 3, 3);
        Rectanglef second = new Rectanglef(-1, -1, 2, 2);

        // is valid
        assertTrue(first.isValid());
        assertTrue(second.isValid());

        assertFalse(first.containsRectangle(second));
        assertFalse(second.containsRectangle(first));

        assertTrue(first.intersectsRectangle(second));
        assertTrue(second.intersectsRectangle(first));
        assertEquals(first.intersection(second, new Rectanglef()), new Rectanglef(0, 0, 2, 2));

    }

    @Test
    public void testRectangleContains() {
        Rectanglef first = new Rectanglef(-1, -1, 2, 2);
        Rectanglef second = new Rectanglef(0, 0, 1, 1);
        assertTrue(first.containsRectangle(second));
        assertFalse(second.containsRectangle(first));

        assertTrue(first.intersectsRectangle(second));
        assertTrue(second.intersectsRectangle(first));

        assertEquals(first.intersection(second, new Rectanglef()), new Rectanglef(0, 0, 1, 1));
    }

    @Test
    public void testZeroSizeRectangle() {
        Rectanglef rect = new Rectanglef(0, 0, 0, 0);
        assertFalse(rect.isValid());
    }
}
