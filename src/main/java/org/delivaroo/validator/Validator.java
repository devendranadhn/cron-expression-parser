package org.delivaroo.validator;

import org.delivaroo.exception.InvalidCronExpressionException;

public interface Validator {
    void validate() throws InvalidCronExpressionException;

}
