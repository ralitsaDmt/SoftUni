package Vehicles_02.Vehicles_01;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity){
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public void drive(double distanceInKilometers, boolean isDrivingWithPeople){

        if (isDrivingWithPeople) {
            this.increaseConsumption();
        }

        super.drive(distanceInKilometers);

        if (isDrivingWithPeople) {
            this.decreaseConsumtion();
        }
    }

    private void decreaseConsumtion() {
        double decreasedConsumption = this.getFuelConsumptionLitersPerKilometer() - 1.4;
        this.setFuelConsumptionLitersPerKilometer(decreasedConsumption);
    }

    private void increaseConsumption() {
        double increasedConsumtion = this.getFuelConsumptionLitersPerKilometer() + 1.4;
        this.setFuelConsumptionLitersPerKilometer(increasedConsumtion);
    }

    @Override
    public void refuel(double fuel) {
        if (this.getFuelQuantityInLiters() + fuel > this.getTankCapacity()) {
            String exceptionMessage = "Cannot fit fuel in tank";
            throw new IllegalArgumentException(exceptionMessage);
        }

        super.refuel(fuel);
    }

    @Override
    protected void setFuelQuantityInLiters(double fuelQuantityInLiters) {
        if (fuelQuantityInLiters < 0 || fuelQuantityInLiters > this.getTankCapacity()) {
            String exceptionMessage = "Cannot fit fuel in tank";
            throw new IllegalArgumentException(exceptionMessage);
        }

        super.setFuelQuantityInLiters(fuelQuantityInLiters);
    }
}
