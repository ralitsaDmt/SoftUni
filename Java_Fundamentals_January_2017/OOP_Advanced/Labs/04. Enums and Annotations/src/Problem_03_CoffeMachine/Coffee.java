package Problem_03_CoffeMachine;

public class Coffee {

    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(CoffeeSize size, CoffeeType type){

        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        String output = String.format("%s %s",
                this.size, this.type);
        return output;
    }
}
