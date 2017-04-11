package Problem_01_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int numberOfValues = Integer.parseInt(reader.readLine());

        List<Box<Double>> elements = new ArrayList<>();

        for (int i = 0; i < numberOfValues; i++) {
            Double value = Double.parseDouble(reader.readLine());
            Box<Double> box = new Box<>(value);

            elements.add(box);
        }

        Double valueToCompare = Double.parseDouble(reader.readLine());
        Box<Double> boxToCompare = new Box<>(valueToCompare);

        long count = countGreaterValues(elements, boxToCompare);
        System.out.println(count);

//        for (int i = 0; i < numberOfValues; i++) {
//            int value = Integer.parseInt(reader.readLine());
//            Box<Integer> box = new Box<>(value);
//
//            elements.add(box);
//        }
//
//        String[] indexes = reader.readLine().split("\\s+");
//        int firstIndex = Integer.parseInt(indexes[0]);
//        int secondIndex = Integer.parseInt(indexes[1]);
//
//        swapElements(elements, firstIndex, secondIndex);
//
//        for (Box element : elements) {
//            System.out.println(element);
//        }

    }

    private static <T extends Comparable<T>> long countGreaterValues(List<T> elements, T valueToCompare){

        long count = elements.stream()
                .filter(e -> e.compareTo(valueToCompare) > 0)
                .count();

//        int greaterValuesCount = 0;
//
//        for (T element : elements) {
//            if (element.compareTo(valueToCompare) > 0){
//                greaterValuesCount++;
//            }
//        }

        return count;
    }

    private static <T> void  swapElements(List<T> elements, int firstIndex, int secondIndex) {
        T temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }
}
