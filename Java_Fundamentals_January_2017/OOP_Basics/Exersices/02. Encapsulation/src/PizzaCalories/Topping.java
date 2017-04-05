package PizzaCalories;

public class Topping {
    private final Integer BASE = 2;

    private String type;
    private double weight;
    private double modifier;

    public Topping(String type, double weight){
        this.setType(type);
        this.setWeight(weight);
        this.setModifier();
    }

    private void setType(String type){
        if (!type.toLowerCase().equals("meat")
                && !type.toLowerCase().equals("veggies")
                && !type.toLowerCase().equals("cheese")
                && !type.toLowerCase().equals("sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }

        this.type = type;
    }

    private void setWeight(double weight){
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.type));
        }

        this.weight = weight;
    }

    private void setModifier(){
        switch (this.type.toLowerCase()){
            case "meat": this.modifier = 1.2; return;
            case "veggies": this.modifier = 0.8; return;
            case "cheese": this.modifier = 1.1; return;
            case "sauce": this.modifier = 0.9;
        }
    }

    public double getCalories(){
        double caloriesPerGram = BASE * this.weight * this.modifier;
        return caloriesPerGram;
    }
}
