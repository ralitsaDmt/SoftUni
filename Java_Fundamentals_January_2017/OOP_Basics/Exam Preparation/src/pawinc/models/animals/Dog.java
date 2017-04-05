package pawinc.models.animals;

public class Dog extends Animal {

    private int amountOfCommands;

    private void setAmountOfCommands(int amountOfCommands) {
        this.amountOfCommands = amountOfCommands;
    }

    public Dog (String name, int age, String adoptionCenter, int amountOfCommands) {
        super(name, age, adoptionCenter);
        this.setAmountOfCommands(amountOfCommands);
    }
}
