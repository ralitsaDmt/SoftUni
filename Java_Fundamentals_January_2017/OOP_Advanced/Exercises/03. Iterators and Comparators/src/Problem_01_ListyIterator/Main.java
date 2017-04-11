package Problem_01_ListyIterator;

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

        ListyIterator listyIterator = new ListyIterator(createInput);

        while (true) {
            String command = reader.readLine();
            if ("END".equals(command)) {
                break;
            }

            switch (command) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "PrintAll":

            }
        }
    }
}
