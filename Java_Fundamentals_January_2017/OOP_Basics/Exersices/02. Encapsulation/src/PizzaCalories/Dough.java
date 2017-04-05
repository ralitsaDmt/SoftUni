package PizzaCalories;

import java.util.ArrayList;

public class Dough {

    private final Integer BASE = 2;

    private String type;
    private String bakingTechnique;
    private Double weight;
    private double typeModifier;
    private double bakingModifier;

    public Dough(String type, String bakingTechnique, double weight){
        this.setType(type.toLowerCase());
        this.setBakingTechnique(bakingTechnique.toLowerCase());
        this.setWeight(weight);

        this.calcTypeModifier();
        this.calcBakingModifire();
    }

    private void setType(String type){
        if (!type.equals("white") && !type.equals("wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.type = type;
    }

    private void setBakingTechnique(String bakingTechnique){
        if (!bakingTechnique.equals("crispy")
                && !bakingTechnique.equals("chewy")
                && !bakingTechnique.equals("homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight){
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public double getCaloriesPerGram(){
        double caloriesPerGram = BASE * this.weight * this.typeModifier * this.bakingModifier;
        return caloriesPerGram;
    }

    private void calcBakingModifire() {
        switch (this.bakingTechnique){
            case "crispy": this.bakingModifier = 0.9; return;
            case "chewy": this.bakingModifier = 1.1; return;
            case "homemade": this.bakingModifier = 1.0;
        }
    }

    private void calcTypeModifier() {
        switch (this.type){
            case "white": this.typeModifier = 1.5; return;
            case "wholegrain": this.typeModifier = 1.0;
        }
    }


}
