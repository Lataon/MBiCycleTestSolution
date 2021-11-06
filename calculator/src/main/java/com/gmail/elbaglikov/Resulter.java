package com.gmail.elbaglikov;

import com.gmail.elbaglikov.model.ExpressionCalculator;

import java.io.IOException;
import java.io.Writer;

public class Resulter {
    public void write(String line, Writer writer) throws IOException {
        writer.write(String.valueOf(ExpressionCalculator.calculate(line)));
        writer.flush();
    }
}
