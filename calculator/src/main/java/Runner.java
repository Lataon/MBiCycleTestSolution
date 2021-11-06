
import com.gmail.elbaglikov.Resulter;

import java.io.*;

public class Runner {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Resulter resulter = new Resulter();
            String line = reader.readLine();
            resulter.write(line, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
