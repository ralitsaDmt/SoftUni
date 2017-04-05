package WildFarm_03.Animals;

import WildFarm_03.Foods.Food;

public class Zebra extends Mammal {

    public Zebra(String name, String type, double weight, String region){
        super(name, type, weight, region);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();

        if (!foodType.equals("Vegetable")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }

        super.eat(food);
    }
}
