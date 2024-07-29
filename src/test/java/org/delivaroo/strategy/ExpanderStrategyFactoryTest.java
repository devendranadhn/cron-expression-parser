package org.delivaroo.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpanderStrategyFactoryTest {

    @Test
    void getFreqExpanderStrategy() {
       ExpanderStrategy strategy = ExpanderStrategyFactory.getExpanderStrategy("/*15");
        Assertions.assertTrue(strategy instanceof FrequencyExpander);
    }

    @Test
    void getRangeExpanderStrategy() {
        ExpanderStrategy strategy = ExpanderStrategyFactory.getExpanderStrategy("1-5");
        Assertions.assertTrue(strategy instanceof RangeExpander);
    }

    @Test
    void getSpecificExpanderStrategy() {
        ExpanderStrategy strategy = ExpanderStrategyFactory.getExpanderStrategy("1,5");
        Assertions.assertTrue(strategy instanceof SpecificValExpander);
    }

    @Test
    void getStarExpanderStrategy() {
        ExpanderStrategy strategy = ExpanderStrategyFactory.getExpanderStrategy("*");
        Assertions.assertTrue(strategy instanceof StarExpander);
    }
}