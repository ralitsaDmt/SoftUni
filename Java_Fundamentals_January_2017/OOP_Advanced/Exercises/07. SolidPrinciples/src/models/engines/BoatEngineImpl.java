package models.engines;

import Utility.Constants;
import Utility.Validator;
import contracts.BoatEngine;
import contracts.Modelable;

public abstract class BoatEngineImpl implements BoatEngine {

    private static final String HORSEPOWER = "Horsepower";
    private static final String DISPLACEMENT = "Displacement";

    private String model;
    private int horsepower;
    private int displacement;

    protected BoatEngineImpl(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, HORSEPOWER);
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, DISPLACEMENT);
        this.displacement = displacement;
    }

    @Override
    public String getModel(){
        return this.model;
    }

    protected int getHorsepower(){
        return this.horsepower;
    }

    protected int getDisplacement(){
        return this.displacement;
    }
}
