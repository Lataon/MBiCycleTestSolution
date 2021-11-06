package com.gmail.elbaglikov.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCalculatorTest {

    @Test
    public void calculateExpression() {
        double expected = 69.9d;
        double actual = ExpressionCalculator.calculate("-3 + 45.7 - (12 + 5.6 * -7)");
        assertEquals(expected, actual, 0.000);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateWrongStartSymbol() {
        ExpressionCalculator.calculate("--3 + 45.7 - (12 + 5.6 * -7)");
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateWrongParenthesses() {
        ExpressionCalculator.calculate("(-3 + 45.7 - (12 + 5.6 * -7)");
    }
}