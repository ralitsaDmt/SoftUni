package Problem_03_CoffeMachine;

public enum CoffeeSize {

    SMALL(50, 50),
    NORMAL(100, 75),
    DOUBLE(200, 100);

    private int dosage;
    private int price;

    CoffeeSize(int dosage, int price) {
        this.dosage = dosage;
        this.price = price;
    }

    public int getDosage() {
        return dosage;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String lower = this.name().substring(1).toLowerCase();
        String upcase = this.name().charAt(0) + lower;

        return upcase;
    }
}
