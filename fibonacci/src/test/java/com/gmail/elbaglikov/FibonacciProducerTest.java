package com.gmail.elbaglikov;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciProducerTest {
    private FibonacciProducer producer = new FibonacciProducer();

    @Test
    public void getNextFibonacci() {
        final int COUNT = 10;
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21 ,34};
        int[] actual = new int [COUNT];
        for (int i = 0; i<COUNT; i++) {
            actual[i] = producer.getNextFibonacci(i);
        }
        assertArrayEquals(expected,actual);
    }
}