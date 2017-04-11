package Problem_07_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> list = new CustomList<>();

        while (true) {
            String line = reader.readLine();
            if ("END".equals(line)) {
                break;
            }

            String[] input = line.split("\\s+");

            String command = input[0];

            switch (command) {
                case "Add":
                    String elementToAdd = input[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(input[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementToCheck = input[1];
                    boolean containsElement = list.contains(elementToCheck);
                    System.out.println(containsElement);
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input[1]);
                    int secondIndex = Integer.parseInt(input[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elementToCompare = input[1];
                    long count = list.countGreaterThan(elementToCompare);
                    System.out.println(count);
                    break;
                case "Max":
                    String maxElement = list.getMax();
                    System.out.println(maxElement);
                    break;
                case "Min":
                    String minElement = list.getMin();
                    System.out.println(minElement);
                    break;
                case "Print":
                    for (String item : list) {
                        System.out.println(item);
                    }
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }
        }
    }
}
