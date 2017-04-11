package Problem_05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if ("END".equals(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            people.add(person);
        }

        int equalPeople = 0;
        int unequalPeople = 0;
        int collectionSize = people.size();

        int personToCompareIndex = Integer.parseInt(reader.readLine()) - 1;

        if (personToCompareIndex < collectionSize - 1) {
            Person personToCompare = people.get(personToCompareIndex);

            for (Person person : people) {
                if (personToCompare.compareTo(person) == 0) {
                    equalPeople++;
                } else {
                    unequalPeople++;
                }
            }
        }

        String output = "";

        if (equalPeople == 0) {
            output = "No matches";
        } else {
            output = String.format("%d %d %d", equalPeople, unequalPeople, collectionSize);
        }

        System.out.println(output);
    }
}
