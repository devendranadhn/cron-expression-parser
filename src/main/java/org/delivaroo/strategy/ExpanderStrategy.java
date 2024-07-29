package org.delivaroo.strategy;

public interface ExpanderStrategy {

    /**
     * This is expected to be implemented for all the types of the fields in the cron expression which expands in it's
     * strategy
     * @param value - takes the expression Eg: \*\/15
     * @param min - takes the min possible value for expanding the expression
     * @param max - takes the max possible value for expanding the expression
     * @return - returns the array of integers after expanding the expression
     */
    public int[] expand(String value, int min, int max);

}
