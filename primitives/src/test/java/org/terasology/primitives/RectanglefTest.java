/*
 * The MIT License
 *
 * Copyright (c) 2020 JOML.
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

import org.joml.Vector2f;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the {@link Rectanglef} class.
 *
 * @author Michael Pollind
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