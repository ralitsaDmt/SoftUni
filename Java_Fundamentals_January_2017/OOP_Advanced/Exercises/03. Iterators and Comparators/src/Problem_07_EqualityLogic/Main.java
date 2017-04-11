package Problem_07_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Set<Person> treePeople = new TreeSet<>();
        Set<Person> hashPeople = new HashSet<>();

        int peopleCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            treePeople.add(person);
            hashPeople.add(person);
        }

        int treeSize = treePeople.size();
        int hashSize = hashPeople.size();

        System.out.println(treeSize);
        System.out.println(hashSize);

    }
}
