
import com.gmail.elbaglikov.Printer;
import com.gmail.elbaglikov.model.ExpressionCalculator;

import java.io.*;

public class Runner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            printer.print(String.valueOf(ExpressionCalculator.calculate(line)));
        } catch (IOException | IllegalArgumentException e) {
            printer.print(e.getMessage());
        }
    }
}
