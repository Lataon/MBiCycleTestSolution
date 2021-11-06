import com.gmail.elbaglikov.FibonacciProducer;
import com.gmail.elbaglikov.Printer;

public class Runner {
    public static void main(String[] args) {
        final String NOT_VALID_ARGUMENT_MESSAGE = "Not valid argument";
        Printer printer = new Printer();
        FibonacciProducer producer = new FibonacciProducer();
        try {
            final int COUNT_OF_FIBONACCIES = Integer.parseInt(args[0]);
            for (int i = 0; i < COUNT_OF_FIBONACCIES; i++) {
                printer.print(producer.getNextFibonacci(i));
            }
        } catch (NumberFormatException e) {
            printer.print(NOT_VALID_ARGUMENT_MESSAGE);
        }
    }

}
