package OpinionPoll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OpinionPoll {
    public static void main(String[] args) throws Exception {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Integer count = Integer.parseInt(in.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] info = in.readLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            Person person = new Person(name, age);

            people.add(person);
        }

        people = people.stream()
                .filter(p -> p.age > 30)
                .sorted(Comparator.comparing(p2 -> p2.name))
                .collect(Collectors.toList());

        for (Person person : people) {
            System.out.println(person.name + " - " + person.age);
        }
    }
}
