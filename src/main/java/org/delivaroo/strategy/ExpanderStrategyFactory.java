package org.delivaroo.strategy;

import java.util.Arrays;

public class ExpanderStrategyFactory {

    private static final String STAR = "*";
    private static final String FORWARD_SLASH = "/";

    private static final String HYPHEN = "-";
    public static ExpanderStrategy getExpanderStrategy(String value) {
        if (STAR.equals(value)) {
            return new StarExpander();
        }else if (value.contains(FORWARD_SLASH)) {
            return new FrequencyExpander();
        }else if (value.contains(HYPHEN)) {
            return new RangeExpander();
        }else {
            return new SpecificValExpander();
        }
    }

}
