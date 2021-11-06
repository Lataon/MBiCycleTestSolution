package com.gmail.elbaglikov;

public class Printer {

    public void print(int fib) {
        print(String.valueOf(fib));
    }

    public void print(String message) {
        System.out.println(message);
    }
}
