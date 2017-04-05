package WildFarm_03.Animals;

import WildFarm_03.Foods.Food;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Cat extends Feline {

    private String breed;

    private void setBreed(String breed) {
        this.breed = breed;
    }

    public Cat(String name, String type, double weight, String region, String breed){
        super(name, type, weight, region);
        this.setBreed(breed);
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        String formattedWeight = formatWeight(this.getAnimalWeight());

        formattedWeight = formattedWeight.replace(",", ".");

        String message = String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                this.breed,
                formattedWeight,
                this.getLivingRegion(),
                this.getFoodEaten());
        return message;
    }
}
