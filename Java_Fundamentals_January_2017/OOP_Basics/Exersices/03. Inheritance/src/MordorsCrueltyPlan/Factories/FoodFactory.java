package MordorsCrueltyPlan.Factories;

import MordorsCrueltyPlan.Foods.*;

public class FoodFactory {

    public Food getFood(String foodName) {
        switch (foodName.toLowerCase()) {
            case "cram": return new Cram();
            case "lembas": return new Lembas();
            case "apple": return new Apple();
            case "Melon": return new Melon();
            case "honeycake": return new HoneyCake();
            case "mushrooms": return new Mushrooms();
            default: return new OtherFood();
        }
    }

}
