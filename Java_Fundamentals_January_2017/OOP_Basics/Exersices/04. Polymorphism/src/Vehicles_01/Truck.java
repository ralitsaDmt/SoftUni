package Vehicles_01;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption){
        super(fuelQuantity, fuelConsumption);
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
