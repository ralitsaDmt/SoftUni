package models.boats;

import Utility.Validator;

public class RowBoat extends BoatImpl {

    private static final String OARS = "Oars";
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, OARS);
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(int oceanCurrentSpeed, int windSpeed) {
        double speed = (this.oars * 100) - super.getWeight() + oceanCurrentSpeed;
        return speed;
    }
}
