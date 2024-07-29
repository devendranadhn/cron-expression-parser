package org.delivaroo.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecificValExpanderTest {

    @Test
    void expand() {
        SpecificValExpander expander = new SpecificValExpander();
        int[] vals = expander.expand("1,5", 0, 59);
        int[] result = new int[]{1,5};
        Assertions.assertArrayEquals(vals, result);
    }
}