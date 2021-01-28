// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Vector3f;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AABBfTest {
    @Test
    public void testZeroSizeContains() {
        assertFalse(new AABBf(new Vector3f(0, 0, 0)).containsPoint(0, 0, 0));
        assertFalse(new AABBf(new Vector3f(.5f, .5f, .5f)).containsPoint(.5f, .5f, .5f));
    }
}
