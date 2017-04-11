package models.boats;

import Utility.Validator;
import models.engines.BoatEngineImpl;

public class Yacht extends BoatImpl {

    private static final String CARGO_WEIGHT = "Cargo Weight";

    private BoatEngineImpl engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngineImpl engine, int cargoWeight) {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, CARGO_WEIGHT);
        this.cargoWeight = cargoWeight;
    }

    //Boat Engine Output - (Boat Weight + Cargo Weight) + (Race Ocean Current Speed / 2);
    @Override
    public double calculateRaceSpeed(int oceanCurrentSpeed, int windSpeed) {
        double speed = this.engine.getOutput() - (super.getWeight() + this.cargoWeight) + (oceanCurrentSpeed / 2);
        return speed;
    }
}
