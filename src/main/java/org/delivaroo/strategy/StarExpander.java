package org.delivaroo.strategy;

import java.util.ArrayList;
import java.util.List;

public class StarExpander implements ExpanderStrategy {

    @Override
    public int[] expand(String value, int min, int max) {
        int curr = min;
        List<Integer> result = new ArrayList<>();
        while(curr <= max) {
          result.add(curr);
          curr++;
        }
       return result.stream().mapToInt(i->i).toArray();
    }

}

