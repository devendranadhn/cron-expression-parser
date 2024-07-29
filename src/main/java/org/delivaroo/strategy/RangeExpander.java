package org.delivaroo.strategy;

import org.delivaroo.exception.InvalidCronExpressionException;
import org.delivaroo.exception.InvalidRangeException;

import java.util.ArrayList;
import java.util.List;

public class RangeExpander implements ExpanderStrategy {

    @Override
    public int[] expand(String value, int min, int max) {
        String[] range = value.split("-");
        int low, high = 0;
        try {
            low = Integer.parseInt(range[0].trim());
            high = Integer.parseInt(range[1].trim());
        }catch (NumberFormatException numberFormatException) {
            throw new InvalidCronExpressionException(numberFormatException.getMessage());
        }

        if (low > high) {
            throw new InvalidRangeException("invalid range in the expression : " + value);
        }

        if (low > max || high > max) {
            throw new InvalidRangeException("range cannot exceed the max values");
        }

        if (low < min || high < min) {
            throw new InvalidRangeException("range cannot go below the min value");
        }

        int curr = low;
        List<Integer> result = new ArrayList<>();
        while (curr <= high) {
            result.add(curr);
            curr++;
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
