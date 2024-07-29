package org.delivaroo.model;

import org.delivaroo.mapper.MapperFactory;
import org.delivaroo.strategy.*;

import java.util.Arrays;

public enum CronTimeUnit {

    MINUTES(0,59, 0, "minutes"),
    HOURS(0, 23, 1, "hours"),
    DAYS(1,30, 2, "day of month"),
    MONTHS(1,12, 3, "month"),
    WEEK_DAY(1, 7, 4, "day of week");

    int min; int max; int index; String header;

    private CronTimeUnit(int min, int max, int index, String header) {
        this.min = min;
        this.max = max;
        this.index = index;
        this.header = header;
    }

    public String[] output(String value) {
        ExpanderStrategy expanderStrategy = ExpanderStrategyFactory.getExpanderStrategy(value);
        return Arrays.stream(expanderStrategy.expand(value, getMin(), getMax()))
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);
    }

    public int getMax() {
        return max;
    }

    public int getMin(){
        return min;
    }

    public int getIndex(){
        return index;
    }

    public String getHeader() {
        return this.header;
    }

}
