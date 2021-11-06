package com.gmail.elbaglikov;

public class FibonacciProducer {

    public int getNextFibonacci (int n){
        if (n <= 1) {
            return n;
        }
        return getNextFibonacci(n -1) + getNextFibonacci(n-2);
    }
}
