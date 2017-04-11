package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.Boat;
import contracts.Modelable;

public abstract class BoatImpl implements Boat {

    private static final String WEIGHT = "Weight";

    private String model;
    private int weight;

    protected BoatImpl(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, WEIGHT);
        this.weight = weight;
    }

    @Override
    public int getWeight(){
        return this.weight;
    }

    @Override
    public String getModel(){
        return this.model;
    }
}
