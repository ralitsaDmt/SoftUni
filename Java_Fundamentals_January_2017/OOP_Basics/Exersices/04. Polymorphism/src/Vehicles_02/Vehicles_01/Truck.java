package Vehicles_02.Vehicles_01;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity){
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }

    @Override
    protected void setFuelConsumptionLitersPerKilometer(double consumption) {
        super.setFuelConsumptionLitersPerKilometer(consumption + 1.6);
    }
}
