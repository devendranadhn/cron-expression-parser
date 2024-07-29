package org.delivaroo.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarExpanderTest {

    @Test
    void expand() {
        StarExpander expander = new StarExpander();
        int[] vals = expander.expand("*", 1, 12);
        int[] result = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        Assertions.assertArrayEquals(vals, result);
    }
}