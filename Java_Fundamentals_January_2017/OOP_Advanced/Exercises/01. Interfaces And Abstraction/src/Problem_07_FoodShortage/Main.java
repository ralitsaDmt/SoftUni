package Problem_07_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(reader.readLine());
        Map<String, Buyer> buyers = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String input = reader.readLine();
            String[] data = input.split("\\s+");

            if (data.length == 4) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                String birthdate = data[3];

                Citizen citizen = new Citizen(name, age, id, birthdate);
                buyers.put(name, citizen);
            } else {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String group = data[2];

                Rebel rebel = new Rebel(name, age, group);
                buyers.put(name, rebel);
            }
        }

        while (true) {
            String name = reader.readLine();
            if ("End".equals(name)) {
                break;
            }

            if (buyers.containsKey(name)) {
                buyers.get(name).buyFood();
            }
        }

        int totalAmountOfFood = calculateTotalAmountOfFood(buyers);
        System.out.println(totalAmountOfFood);
    }

    private static int calculateTotalAmountOfFood(Map<String, Buyer> buyers) {
        int totalAmountOfFood = 0;

        for (Buyer buyer : buyers.values()) {
            totalAmountOfFood = totalAmountOfFood + buyer.getFood();
        }

        return totalAmountOfFood;
    }
}
