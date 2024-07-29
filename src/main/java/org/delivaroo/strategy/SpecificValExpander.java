package org.delivaroo.strategy;

import org.delivaroo.exception.InvalidCronExpressionException;

public class SpecificValExpander implements ExpanderStrategy {

    @Override
    public int[] expand(String value, int min, int max) {
        String[] vals = value.split(",");
        int[] valArray = new int[vals.length];

        try {
            for (int i = 0; i < vals.length; i++) {
                valArray[i] = Integer.parseInt(vals[i]);
            }
        }catch (NumberFormatException numberFormatException) {
            throw new InvalidCronExpressionException(numberFormatException.getMessage());
        }

        return valArray;
    }
}
