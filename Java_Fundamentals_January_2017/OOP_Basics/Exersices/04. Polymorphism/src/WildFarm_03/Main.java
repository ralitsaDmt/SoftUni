package WildFarm_03;

import WildFarm_03.Animals.Animal;
import WildFarm_03.Factories.AnimalFactory;
import WildFarm_03.Factories.FoodFactory;
import WildFarm_03.Foods.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        AnimalFactory animalFactory = new AnimalFactory();
        FoodFactory foodFactory = new FoodFactory();

        while (true) {
            String animalInputLine = reader.readLine();
            if ("End".equals(animalInputLine)) {
                break;
            }

            String[] animalData = animalInputLine.split("\\s+");
            Animal animal = createAnimal(animalData, animalFactory);

            String foodInputLine = reader.readLine();
            if ("End".equals(foodInputLine)) {
                break;
            }

            String[] foodData = foodInputLine.split("\\s+");
            Food food = createFood(foodData, foodFactory);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(animal);
        }
    }

    private static Food createFood(String[] foodData, FoodFactory foodFactory) {
        String foodType = foodData[0];
        int foodQuantity = Integer.parseInt(foodData[1]);

        Food food = foodFactory.getFood(foodType, foodQuantity);

        return food;
    }

    private static Animal createAnimal(String[] animalData, AnimalFactory animalFactory) {

        String type = animalData[0];
        String name = animalData[1];
        double weight = Double.parseDouble(animalData[2]);
        String region = animalData[3];
        String breed = null;

        if (animalData.length == 5) {
            breed = animalData[4];

            Animal animal = animalFactory.getAnimal(type, name, weight, region, breed);
            return animal;
        }

        Animal animal = animalFactory.getAnimal(type, name, weight, region);
        return animal;
    }


}
