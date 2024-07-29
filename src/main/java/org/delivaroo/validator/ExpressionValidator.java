package org.delivaroo.validator;

import org.delivaroo.exception.InvalidCronExpressionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator implements Validator {
    private String expression;

    private String regex = "[^0-9\\*\\/,\\- ]";
    private Pattern pattern = Pattern.compile(regex);

    public ExpressionValidator(String expression) {
        this.expression = expression;
    }

    /**
     * This expression validates the basic things like -- other than digits / * - ,  no other special characters are
     * allowed in the time part of the expression
     * @throws InvalidCronExpressionException
     */
    @Override
    public void validate() throws InvalidCronExpressionException {
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            throw new InvalidCronExpressionException("Invalid token found in the expression. Only / - , * [0-9] are allowed");
        }
    }
}
