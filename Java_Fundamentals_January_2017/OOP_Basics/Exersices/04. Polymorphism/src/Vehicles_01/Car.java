package Vehicles_01;

public class Car extends Vehicle{

    public Car(double fuelQuantity, double fuelConsumption){
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumptionLitersPerKilometer(double consumption) {
        super.setFuelConsumptionLitersPerKilometer(consumption + 0.9);
    }
}
