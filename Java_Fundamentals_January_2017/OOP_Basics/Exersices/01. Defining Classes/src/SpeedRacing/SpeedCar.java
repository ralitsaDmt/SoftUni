package SpeedRacing;

public class SpeedCar {

    private String model;
    private Double fuelAmount;
    private Double costPerKm;
    private Integer distanceTravelled;

    public SpeedCar(String model,
                    Double fuelAmount,
                    Double costPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costPerKm = costPerKm;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public Double getFuelAmount() {
        return fuelAmount;
    }

    public Integer getDistanceTravelled() {
        return distanceTravelled;
    }

    public void drive(Integer km) throws Exception {
        if ( km * this.costPerKm > this.fuelAmount){
            throw new Exception();
        }

        this.fuelAmount -= km * this.costPerKm;
        this.distanceTravelled += km;
    }
}
