// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Vector3d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AABBdTest {
    @Test
    public void testZeroSizeContains() {
        assertFalse(new AABBd(new Vector3d(0, 0, 0)).containsPoint(0, 0, 0));
        assertFalse(new AABBd(new Vector3d(.5, .5, .5)).containsPoint(.5, .5, .5));
    }
}
