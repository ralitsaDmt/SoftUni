package WildFarm_03.Animals;

import WildFarm_03.Foods.Food;

public class Mouse extends Mammal {

    public Mouse(String name, String type, double weight, String region){
        super(name, type, weight, region);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();

        if (!foodType.equals("Vegetable")) {
            throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }

        super.eat(food);
    }
}
