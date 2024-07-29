package org.delivaroo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CronTimeUnitTest {

    @Test
    void outputMins() {
        String[] result = CronTimeUnit.MINUTES.output("*/15");
        String[] expected = new String[]{"0","15","30","45"};
        Assertions.assertArrayEquals(result, expected);
    }

    @Test
    void outputHours() {
        String[] result = CronTimeUnit.HOURS.output("1-8");
        String[] expected = new String[]{"1","2","3","4","5","6","7","8"};
        Assertions.assertArrayEquals(result, expected);
    }

    @Test
    void outputMonths() {
        String[] result = CronTimeUnit.MONTHS.output("1,8");
        String[] expected = new String[]{"1","8"};
        Assertions.assertArrayEquals(result, expected);
    }

    @Test
    void outputWeeks() {
        String[] result = CronTimeUnit.WEEK_DAY.output("1,5");
        String[] expected = new String[]{"1","5"};
        Assertions.assertArrayEquals(result, expected);
    }

    @Test
    void outputDays() {
        String[] result = CronTimeUnit.DAYS.output("1,25");
        String[] expected = new String[]{"1","25"};
        Assertions.assertArrayEquals(result, expected);
    }
}