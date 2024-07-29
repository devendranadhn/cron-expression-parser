package org.delivaroo.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CronExpression {

    private CronField minutes;

    private CronField hours;

    private CronField month_days;

    private CronField months;

    private CronField week_days;

    private String command;

    Map<CronTimeUnit, CronField> map = new HashMap<>();

    public static class Builder {
        private CronField minutes;

        private CronField hours;

        private CronField month_days;

        private CronField months;

        private CronField week_days;

        private String command;

        public Builder withMinutes(String value) {
            this.minutes = new CronField(value, CronTimeUnit.MINUTES);
            return this;
        }

        public Builder withMonths(String value) {
            this.months = new CronField(value, CronTimeUnit.MONTHS);
            return this;
        }

        public Builder withDaysPerMonths(String value) {
            this.month_days = new CronField(value, CronTimeUnit.DAYS);
            return this;
        }

        public Builder withDaysPerWeek(String value) {
            this.week_days = new CronField(value, CronTimeUnit.WEEK_DAY);
            return this;
        }

        public Builder withHours(String value) {
            this.hours = new CronField(value, CronTimeUnit.HOURS);
            return this;
        }

        public CronExpression build() {
            return new CronExpression(this);
        }

        public static Builder getInstance() {
            return new CronExpression.Builder();
        }

        public Builder withCommand(String command) {
            this.command = command;
            return this;
        }

    }

    private CronExpression(Builder builder) {
        this.hours = builder.hours;
        this.minutes = builder.minutes;
        this.month_days = builder.month_days;
        this.week_days = builder.week_days;
        this.months = builder.months;
        this.command = builder.command;
        map.put(CronTimeUnit.MINUTES, this.minutes);
        map.put(CronTimeUnit.DAYS, this.month_days);
        map.put(CronTimeUnit.HOURS, this.hours);
        map.put(CronTimeUnit.MONTHS, this.months);
        map.put(CronTimeUnit.WEEK_DAY, this.week_days);
    }

    /**
     * Improve this to map b/w integers using a mapper - so that it can be extensible
     */
    public void print() {
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.printf("%-14s %s%n", entry.getKey().getHeader(), String.join(" ", entry.getKey().output(entry.getValue().getValue())));
        });
        System.out.printf("%-14s %s%n%n", "command", command);
    }



}
