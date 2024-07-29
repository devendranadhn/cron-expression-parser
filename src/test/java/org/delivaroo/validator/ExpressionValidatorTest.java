package org.delivaroo.validator;

import org.delivaroo.exception.InvalidCronExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionValidatorTest {

    @Test
    void validateNormalExpression() {
        ExpressionValidator validator = new ExpressionValidator("*/15 1-5 * 1,5 1");
        assertDoesNotThrow(validator::validate);
    }

    @Test
    void validateWrongExpression() {
        ExpressionValidator validator = new ExpressionValidator("$/15 1-5 * 1,5 1");
        assertThrows(InvalidCronExpressionException.class, validator::validate);
    }
}