// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests of {@link Rectangled} scaling functions.
 */
public class RectangleScaleTest {
    @Test
    public static void testNonUniformAnchoredScalingNoDestination() {
        Rectangled testA = new Rectangled(-1, -1, +1, +1);
        Rectanglef testB = new Rectanglef(-1, -1, +1, +1);
        Rectanglei testC = new Rectanglei(-1, -1, +1, +1);

        assertEquals(new Rectangled(-1, -1, +3, +5), testA.scale(2, 3, -1, -1));
        assertEquals(new Rectanglef(-1, -1, +3, +5), testB.scale(2, 3, -1, -1));
        assertEquals(new Rectanglei(-1, -1, +3, +5), testC.scale(2, 3, -1, -1));
    }

    @Test
    public static void testNonUniformAnchoredScalingWithDestination() {
        Rectangled testASubject = new Rectangled(-1, -1, +1, +1);
        Rectangled testATarget = new Rectangled(0, 0, 0, 0);

        Rectanglef testBSubject = new Rectanglef(-1, -1, +1, +1);
        Rectanglef testBTarget = new Rectanglef(0, 0, 0, 0);

        Rectanglei testCSubject = new Rectanglei(-1, -1, +1, +1);
        Rectanglei testCTarget = new Rectanglei(0, 0, 0, 0);

        assertEquals(new Rectangled(-1, -1, +3, +5), testASubject.scale(2, 3, -1, -1, testATarget));
        assertEquals(new Rectanglef(-1, -1, +3, +5), testBSubject.scale(2, 3, -1, -1, testBTarget));
        assertEquals(new Rectanglei(-1, -1, +3, +5), testCSubject.scale(2, 3, -1, -1, testCTarget));
    }
}
