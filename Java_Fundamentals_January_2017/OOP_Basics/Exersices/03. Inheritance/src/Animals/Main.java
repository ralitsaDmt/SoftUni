package Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new LinkedList<>();

        AnimalFactory animalFactory = new AnimalFactory();

        while (true) {
            String animalKind = reader.readLine();
            if (animalKind.equals("Beast!")) {
                break;
            }

            String[] animalData = reader.readLine().split("\\s+");

            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            try {
                Animal animal = animalFactory.getAnimal(animalKind, name, age, gender);
                animals.add(animal);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.produceSound());
        }
    }
}
