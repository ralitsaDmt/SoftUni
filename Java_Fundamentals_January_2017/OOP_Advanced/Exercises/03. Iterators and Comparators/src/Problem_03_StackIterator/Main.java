package Problem_03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        CustomStack<Integer> stack = new CustomStackImpl<>();

        while (!"END".equals(line)) {

            if (line.contains(" ")){
                String command = line.substring(0, line.indexOf(" "));
                line = line.substring(line.indexOf(" ")).trim();
                String[] elements = line.split(", ");
                for (String element : elements) {
                    int intElement = Integer.parseInt(element.trim());
                    stack.push(intElement);
                }
            } else {
                try{
                    stack.pop();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex.getMessage());
                }

            }

            line = reader.readLine();
        }

        for (Integer item : stack) {
            System.out.println(item);
        }

        for (Integer item : stack) {
            System.out.println(item);
        }
    }
}
