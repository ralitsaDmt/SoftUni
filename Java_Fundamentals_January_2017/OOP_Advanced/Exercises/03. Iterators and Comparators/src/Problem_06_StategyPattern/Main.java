package Problem_06_StategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Set<Person> nameSet = new TreeSet<>(new NameComparator());
        Set<Person> ageSet = new TreeSet<>(new AgeComparator());

        int peopleCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            nameSet.add(person);
            ageSet.add(person);
        }

        for (Person person : nameSet) {
            System.out.println(person);
        }

        for (Person person : ageSet) {
            System.out.println(person);
        }
    }
}
