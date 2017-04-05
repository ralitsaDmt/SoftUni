package Vehicles_02.Vehicles_01;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity){
        super(fuelQuantity, fuelConsumption, tankCapacity);
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
        if (fuelQuantityInLiters > this.getTankCapacity()) {
            String exceptionMessage = "Cannot fit fuel in tank";
            throw new IllegalArgumentException(exceptionMessage);
        }

        super.setFuelQuantityInLiters(fuelQuantityInLiters);
    }

    @Override
    protected void setFuelConsumptionLitersPerKilometer(double consumption) {
        super.setFuelConsumptionLitersPerKilometer(consumption + 0.9);
    }
}
