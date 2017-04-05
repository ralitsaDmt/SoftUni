package pawinc.models.animals;

public class Cat extends Animal {

    private int intelligenceCoefficient;

    private void setIntelligenceCoefficient(int coefficient) {
        this.intelligenceCoefficient = coefficient;
    }

    public Cat (String name, int age, String adoptionCenter, int coefficient) {
        super(name, age, adoptionCenter);
        this.setIntelligenceCoefficient(coefficient);
    }
}
