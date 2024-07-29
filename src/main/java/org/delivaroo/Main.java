package org.delivaroo;

import org.delivaroo.exception.InvalidCronExpressionException;
import org.delivaroo.model.CronExpression;
import org.delivaroo.model.CronTimeUnit;
import org.delivaroo.validator.ExpressionValidator;
import org.delivaroo.validator.Validator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String[] arguments;
        //Twhen user input is given in single string encoded with double quotes.
        if (args.length == 1) {
            String command = args[0];
            arguments = command.split(" ");
        }else if (args.length - 1 != CronTimeUnit.values().length) {
            throw new InvalidCronExpressionException("invalid number of arguments provided");
        }else {
            //when user input is given space separated strings
            arguments = args;
        }



        String time_command = IntStream.range(0, arguments.length - 1)
                .mapToObj(i -> arguments[i])
                .collect(Collectors.joining(" "));

        try {
            Validator validator = new ExpressionValidator(time_command);

            validator.validate();

            CronExpression expression = CronExpression.Builder.getInstance()
                    .withMinutes(arguments[CronTimeUnit.MINUTES.getIndex()])
                    .withHours(arguments[CronTimeUnit.HOURS.getIndex()])
                    .withMonths(arguments[CronTimeUnit.MONTHS.getIndex()])
                    .withDaysPerMonths(arguments[CronTimeUnit.DAYS.getIndex()])
                    .withDaysPerWeek(arguments[CronTimeUnit.WEEK_DAY.getIndex()])
                    .withCommand(arguments[arguments.length - 1])
                    .build();

            expression.print();
        }catch (InvalidCronExpressionException exception) {
            System.err.println(exception);
        }


    }
}