package Problem_02_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] createInput = reader.readLine().split("\\s+");

        createInput = Arrays.copyOfRange(createInput, 1, createInput.length);

       // Collection listyIterator = new Collection(createInput);

        while (true) {
            String command = reader.readLine();
            if ("END".equals(command)) {
                break;
            }


        }
    }
}
