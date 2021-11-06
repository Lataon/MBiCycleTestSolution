package com.gmail.elbaglikov.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {

    @Test
    public void solveDIV() {
        Operation operation = Operation.DIV;
        String expression = "-1/2/2+5";
        String actual = operation.solve(expression);
        String expected = "-0.25+5";
        assertEquals(expected,actual);
    }

    @Test
    public void solveMUL() {
        Operation operation = Operation.MUL;
        String expression = "-1*2*3*2/2";
        String actual = operation.solve(expression);
        String expected = "-12.0/2";
        assertEquals(expected,actual);
    }

    @Test
    public void solveSUB() {
        Operation operation = Operation.SUB;
        String expression = "-1-2-3*2";
        String actual = operation.solve(expression);
        String expected = "-6.0*2";
        assertEquals(expected,actual);
    }

    @Test
    public void solveADD() {
        Operation operation = Operation.ADD;
        String expression = "1+2+2+3-5/6";
        String actual = operation.solve(expression);
        String expected = "8.0-5/6";
        assertEquals(expected,actual);
    }
}