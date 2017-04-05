package WildFarm_03.Animals;

import WildFarm_03.Foods.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    private void setAnimalName(String name){
        this.animalName = name;
    }

    public String getAnimalName(){
        return this.animalName;
    }

    private void setAnimalType(String type){
        this.animalType = type;
    }

    public String getAnimalType(){
        return this.animalType;
    }

    private void setAnimalWeight(double weight){
        this.animalWeight = weight;
    }

    public double getAnimalWeight(){
        return this.animalWeight;
    }

    protected void setFoodEaten(int foodEaten){
        this.foodEaten = foodEaten;
    }

    public int getFoodEaten(){
        return this.foodEaten;
    }

    protected Animal (String name, String type, double weight){
        this.setAnimalName(name);
        this.setAnimalType(type);
        this.setAnimalWeight(weight);
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        int foodAfterEating = this.foodEaten + food.getQuantity();

        this.setFoodEaten(foodAfterEating);
    }


}
