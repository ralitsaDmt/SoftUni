package Vehicles_02.Vehicles_01;

public abstract class Vehicle {

    private double fuelQuantityInLiters;
    private double fuelConsumptionLitersPerKilometer;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity){
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantityInLiters(fuelQuantity);
        this.setFuelConsumptionLitersPerKilometer(fuelConsumption);
    }

    public double getFuelQuantityInLiters(){
        return this.fuelQuantityInLiters;
    }

    protected void setFuelQuantityInLiters(double fuelQuantityInLiters) {

        if (fuelQuantityInLiters < 0) {
            String exceptionMessage = "Fuel must be a positive number.";
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.fuelQuantityInLiters = fuelQuantityInLiters;
    }

    protected double getTankCapacity(){
        return this.tankCapacity;
    }

    protected void setTankCapacity (double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelConsumptionLitersPerKilometer() {
        return fuelConsumptionLitersPerKilometer;
    }

    protected void setFuelConsumptionLitersPerKilometer(double consumption){
        this.fuelConsumptionLitersPerKilometer = consumption;
    }

    public void drive(double distanceInKilometers){

        if (distanceInKilometers * this.fuelConsumptionLitersPerKilometer > this.fuelQuantityInLiters) {
            String vehicleName = this.getClass().getSimpleName();
            String exceptionMessage = String.format("%s needs refueling", vehicleName);
            throw new IllegalStateException(exceptionMessage);
        }

        this.fuelQuantityInLiters -= this.fuelConsumptionLitersPerKilometer * distanceInKilometers;
    }



    public void refuel(double fuel){
        this.fuelQuantityInLiters += fuel;
    }

    @Override
    public String toString() {
        String vehicleName = this.getClass().getSimpleName();
        String fuelQuantity = String.format("%.2f", this.getFuelQuantityInLiters());
        String formattedFuelQuantity = fuelQuantity.replace(",", ".");

        return String.format("%s: %s", vehicleName, formattedFuelQuantity);
    }


}
