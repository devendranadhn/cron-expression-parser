package org.delivaroo.exception;

public class InvalidCronExpressionException extends RuntimeException {

    String message;

    public InvalidCronExpressionException(String message) {
        super(message);
        this.message = message;
    }

}
