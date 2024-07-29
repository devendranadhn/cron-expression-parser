package org.delivaroo.exception;

public class InvalidRangeException extends InvalidCronExpressionException {

    public InvalidRangeException(String message) {
        super(message);
    }

}
