package org.delivaroo.model;

public class CronField {

    String value;

    CronTimeUnit timeUnit;

    public CronField(String value, CronTimeUnit timeUnit) {
        this.value = value;
        this.timeUnit = timeUnit;
    }

    public String getValue() {
        return value;
    }
}
