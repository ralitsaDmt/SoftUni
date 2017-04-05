package MordorsCrueltyPlan.Factories;

import MordorsCrueltyPlan.Foods.Food;
import MordorsCrueltyPlan.Moods.*;

import java.util.List;

public class MoodFactory {

    private List<Food> foods;
    private int happinessPoints;

    public MoodFactory(List<Food> foods){
        setFoods(foods);
        setHappinessPoints();
    }

    private void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public int getHappinessPoints(){
        return this.happinessPoints;
    }

    private void setHappinessPoints(){
        int totalPoints = 0;
        for (Food food : this.foods) {
            totalPoints = totalPoints + food.getHappinessPoints();
        }

        this.happinessPoints = totalPoints;
    }

    public Mood getMood() {
        if (this.happinessPoints < -5) {
            return new Angry();
        } else if (this.happinessPoints >= -5 && this.happinessPoints < 0) {
            return new Sad();
        } else if (this.happinessPoints >= 0 && this.happinessPoints <= 15) {
            return new Happy();
        } else {
            return new JavaScript();
        }
    }
}
