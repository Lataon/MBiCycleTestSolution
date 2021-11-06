
import com.gmail.elbaglikov.Printer;
import com.gmail.elbaglikov.model.ExpressionCalculator;
import org.apache.log4j.Logger;

import java.io.*;

import static org.apache.log4j.Logger.getLogger;

public class Runner {
    private static final Logger LOGGER = getLogger(Runner.class);
    public static void main(String[] args) {
        Printer printer = new Printer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            printer.print(String.valueOf(ExpressionCalculator.calculate(line)));
        } catch (IOException | IllegalArgumentException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
