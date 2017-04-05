package MordorsCrueltyPlan;

import MordorsCrueltyPlan.Factories.FoodFactory;
import MordorsCrueltyPlan.Factories.MoodFactory;
import MordorsCrueltyPlan.Foods.Food;
import MordorsCrueltyPlan.Moods.Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] foodNames = in.readLine().split("\\s+");

        List<Food> foods = new ArrayList<>();

        FoodFactory foodFactory = new FoodFactory();

        for (String foodName : foodNames) {
            Food currentFood = foodFactory.getFood(foodName);
            foods.add(currentFood);
        }

        MoodFactory moodFactory = new MoodFactory(foods);

        int happinessPoints = moodFactory.getHappinessPoints();
        Mood mood = moodFactory.getMood();

        System.out.println(happinessPoints);
        System.out.println(mood);
    }
}
