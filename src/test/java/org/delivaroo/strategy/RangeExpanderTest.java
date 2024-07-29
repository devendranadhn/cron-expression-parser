package org.delivaroo.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeExpanderTest {

    @Test
    void expand() {
        RangeExpander expander = new RangeExpander();
        int[] vals = expander.expand("1-5", 0, 50);
        int[] result = new int[]{1,2,3,4,5};
        Assertions.assertArrayEquals(vals, result);
    }
}