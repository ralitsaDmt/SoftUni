package WildFarm_03.Factories;

import WildFarm_03.Foods.Food;
import WildFarm_03.Foods.Meat;
import WildFarm_03.Foods.Vegetable;

public class FoodFactory {

    public Food getFood(String foodType, int quantity) {
        switch (foodType) {
            case "Vegetable": return new Vegetable(quantity);
            case "Meat": return new Meat(quantity);
            default: return null;
        }
    }
}
