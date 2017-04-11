package Problem_03_CoffeMachine;

public enum CoffeeType {
    ESPRESSO,
    LATTE,
    IRISH;

    @Override
    public String toString() {
        String lower = this.name().substring(1).toLowerCase();
        String upcase = this.name().charAt(0) + lower;

        return upcase;
    }
}
