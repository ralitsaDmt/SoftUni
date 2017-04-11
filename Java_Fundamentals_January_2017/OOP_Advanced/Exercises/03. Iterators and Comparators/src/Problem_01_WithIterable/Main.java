package Problem_01_WithIterable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        ListyIteratorImpl<String> list = null;

        while (!"END".equals(line)) {
            String[] input = line.split("\\s+");

            String command = input[0];

            switch (command) {
                case "Create":
                    String[] elements = Arrays.stream(input).skip(1).toArray(String[]::new);
                    list = new ListyIteratorImpl<>(elements);
                    break;
                case "Move":
                    System.out.println(list.move());
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
                case "Print":
                    try{
                        list.print();
                    } catch (UnsupportedOperationException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "PrintAll":
                    list.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }
            line = reader.readLine();
        }
    }
}
