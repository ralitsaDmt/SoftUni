package Problem_04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String inputLine = reader.readLine();
        String[] inputData = inputLine.split(", ");

        Integer[] numbers = new Integer [inputData.length];
        for (int i = 0; i < inputData.length; i++) {
            numbers[i] = Integer.parseInt(inputData[i].trim());
        }

        String endCommand = reader.readLine();

        Lake<Integer> lake = new Lake<>(numbers);

        StringBuilder builder = new StringBuilder();
        for (Integer rock : lake) {
            builder.append(rock).append(", ");
        }

        String output = builder.substring(0, builder.length() - 2);

        System.out.println(output);
    }
}
