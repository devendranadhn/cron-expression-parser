package org.delivaroo.strategy;

import org.delivaroo.exception.InvalidCronExpressionException;

import java.util.ArrayList;
import java.util.List;

public class FrequencyExpander implements ExpanderStrategy {

    @Override
    public int[] expand(String value, int min, int max) {
        int interval = 0;
        try {
            interval = Integer.parseInt(value.replace("*/", "").trim());
        }catch (NumberFormatException numberFormatException) {
            throw new InvalidCronExpressionException(numberFormatException.getMessage());
        }

        int curr = 0;
        List<Integer> list = new ArrayList<>();
        while (curr < max) {
            list.add(curr);
            curr = curr + interval;
        }
        return list.stream().mapToInt(i->i).toArray();
    }

}
