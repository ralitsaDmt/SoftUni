package WildFarm_03.Animals;

import WildFarm_03.Foods.Food;

public class Tiger extends Feline {

    private String livingRegion;

    @Override
    protected void setLivingRegion(String region) {
        super.setLivingRegion(region);
    }

    public Tiger(String name, String type, double weight, String region){
        super(name, type, weight, region);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();

        if (!foodType.equals("Meat")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }
}
