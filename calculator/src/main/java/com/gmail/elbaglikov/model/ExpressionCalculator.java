package com.gmail.elbaglikov.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.gmail.elbaglikov.Constants.WRONG_PARENTHESES_NUMBER;
import static com.gmail.elbaglikov.Constants.WRONG_SYMBOLS;

public class ExpressionCalculator {
    public static double calculate(String expression) {
        expression = expression.replaceAll(" ", "");
        if (!expression.matches("[\\d\\.\\-\\+\\/\\*\\(\\)]+")) {
            throw new IllegalArgumentException(WRONG_SYMBOLS);
        }
        expression = solveExpression(expression);
        if (expression.matches(".*[\\(\\)]+.*")) {

            throw new IllegalArgumentException(WRONG_PARENTHESES_NUMBER);
        }
        return Double.parseDouble(expression);
    }

    private static String solveExpression(String expression) {
        expression = splitParentheses(expression.replaceAll(" ", ""));
        expression = useRuleMinusOnMinus(expression);
        for (Operation op : Operation.values()) {
            expression = op.solve(expression);
        }
        return expression;
    }

    private static String splitParentheses(String expression) {
        String regex = "\\(([\\d\\.\\-\\+\\/\\*]+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            String scope = matcher.group(1);
            String solvedScope = solveExpression(scope);
            expression = splitParentheses(expression.replace("(" + scope + ")", solvedScope));
        }

        return expression;
    }

    private static String useRuleMinusOnMinus(String value) {
        return value.replaceAll("--", "\\+");
    }
}
