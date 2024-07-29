package org.delivaroo.mapper;

import java.util.function.IntFunction;

public interface Mapper {

    IntFunction<String> getMappingFunction();

}
