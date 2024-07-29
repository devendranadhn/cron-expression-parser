package org.delivaroo.mapper;

import java.util.function.IntFunction;

public class SimpleMapper implements Mapper {

    @Override
    public IntFunction<String> getMappingFunction() {
        return String::valueOf;
    }
}
