package needForSpeed.models.cars;

public class ShowCar extends Car {

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {
        String starsLine = String.format("%d *", this.stars);

        String showCarOutput = super.toString() + starsLine;

        return showCarOutput;
    }

    @Override
    public void getTuned(int tuneIndex, String addOn) {
        this.stars += tuneIndex;

        long currentHorsePower = this.getHorsePower();
        long increasedHorsePower = currentHorsePower + tuneIndex;

        long currentSuspension = this.getSuspension();
        long increasedSuspension = currentSuspension + tuneIndex / 2;

        this.setHorsePower(increasedHorsePower);
        this.setSuspension(increasedSuspension);
    }
}
