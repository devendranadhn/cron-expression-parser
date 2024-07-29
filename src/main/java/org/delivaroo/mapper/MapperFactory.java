package org.delivaroo.mapper;

import org.delivaroo.model.CronTimeUnit;

public class MapperFactory {

    public static Mapper getMapper(CronTimeUnit timeUnit) {
        return new SimpleMapper();
    }

}
