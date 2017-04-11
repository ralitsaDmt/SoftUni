package models.boats;

import models.engines.BoatEngineImpl;

import java.util.Arrays;
import java.util.List;

public class PowerBoat extends BoatImpl {

    private List<BoatEngineImpl> engines;

    public PowerBoat(String model, int weight, BoatEngineImpl... engines) {
        super(model, weight);
        this.engines = Arrays.asList(engines);
    }

    //(Engine 1 Output + Engine 2 Output) - Boat’s Weight + (Race Ocean Current Speed / 5);
    @Override
    public double calculateRaceSpeed(int oceanCurrentSpeed, int windSpeed) {
        int enginesOutput = this.calculateEnginesOutput();
        double speed = enginesOutput - super.getWeight() + (oceanCurrentSpeed / 5);
        return speed;
    }

    private int calculateEnginesOutput(){
        int output = 0;
        for (BoatEngineImpl engine : engines) {
            output += engine.getOutput();
        }
        return output;
    }
}
