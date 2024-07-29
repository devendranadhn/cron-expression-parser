package org.delivaroo.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyExpanderTest {

    @Test
    void expand() {

        ExpanderStrategy expander = new FrequencyExpander();
        int[] vals = expander.expand("*/15", 0, 59);
        int[] expected = new int[]{0, 15, 30, 45};
        Assertions.assertArrayEquals(vals, expected);

    }
}