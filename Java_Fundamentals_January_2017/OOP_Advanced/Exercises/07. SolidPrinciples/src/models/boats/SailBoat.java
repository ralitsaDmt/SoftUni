package models.boats;

import Utility.Constants;

public class SailBoat extends BoatImpl {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }


    //(Race Wind Speed * (Boat Sail Efficiency / 100)) – Boat’s Weight + (Race Ocean Current Speed / 2)
    @Override
    public double calculateRaceSpeed(int oceanCurrentSpeed, int windSpeed) {
        int speed = (windSpeed * (this.sailEfficiency / 100) - super.getWeight() + (oceanCurrentSpeed / 2));
        return speed;
    }
}
