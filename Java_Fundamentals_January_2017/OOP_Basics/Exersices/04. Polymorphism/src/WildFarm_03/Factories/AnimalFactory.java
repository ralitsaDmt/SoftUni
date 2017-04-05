package WildFarm_03.Factories;

import WildFarm_03.Animals.*;

public class AnimalFactory {

    public Animal getAnimal(String animalType, String animalName, double animalWeight, String region) {
        switch (animalType) {
            case "Mouse": return new Mouse(animalName, animalType, animalWeight, region);
            case "Tiger": return new Tiger(animalName, animalType, animalWeight, region);
            case "Zebra": return new Zebra(animalName, animalType, animalWeight, region);
            default: return null;
        }
    }

    public Animal getAnimal(String animalType, String animalName, double animalWeight, String region, String breed) {
        return new Cat(animalName, animalType, animalWeight, region, breed);
    }
}
