package com.gmail.elbaglikov.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.gmail.elbaglikov.Constants.ARITHMETIC_MISTAKE;

public enum Operation {
    DIV ("(\\d+(\\.[0-9]+)?\\/\\-?\\d+(\\.[0-9]+)?)") {
        @Override
        double operate(String value) {
            String[] values = value.split("\\/");
            double res = Double.parseDouble(values[0])/Double.parseDouble(values[1]);
            if (Double.isInfinite(res)) {
                throw new ArithmeticException(ARITHMETIC_MISTAKE);
            }
            return res;
        }
    },
    MUL ("(\\d+(\\.[0-9]+)?\\*\\-?\\d+(\\.[0-9]+)?)") {
        @Override
        double operate(String value) {
            String[] values = value.split("\\*");
            return Double.parseDouble(values[0])*Double.parseDouble(values[1]);
        }
    },
    SUB ("(^\\-?\\d+(\\.[0-9]+)?\\-\\d+(\\.[0-9]+)?)") {
        @Override
        double operate(String value) {
            final String regex = "(\\-?\\d+(\\.[0-9]+)?)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            double res = 0;
            while (matcher.find()) {
                res+= Double.parseDouble(matcher.group(1));
            }
            return res;
        }
    },
    ADD ("(^\\-?\\d+(\\.[0-9]+)?\\+\\-?\\d+(\\.[0-9]+)?)") {
        @Override
        double operate(String value) {
            String[] values = value.split("\\+");
            return Double.parseDouble(values[0])+Double.parseDouble(values[1]);
        }
    };

    private String regex;

    Operation(String regex) {
        this.regex = regex;
    }

    abstract double operate(String value);

    public String solve(String expression) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String value = matcher.group(1);
            String res = String.valueOf(operate(value));
            return solve(expression.replace(value, res));
        }
        return expression;
    }
}
