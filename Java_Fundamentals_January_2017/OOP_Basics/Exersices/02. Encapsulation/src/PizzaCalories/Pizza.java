package PizzaCalories;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Pizza {
    private String name;
    private Dough dough;
    private int numberOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    private void setNumberOfToppings(int numberOfToppings){
        if (numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name){
        if (name.isEmpty() || name.trim().length() == 0
                || name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough){
        this.dough = dough;
    }

    public int getNumberOfTOppings(){
        return this.toppings.size();
    }

    public double getTotalCalories(){
        double totalCalories = this.dough.getCaloriesPerGram();

        for (Topping topping : toppings) {
            totalCalories += topping.getCalories();
        }

        return totalCalories;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }
}
