package models;

import Utility.Constants;
import Utility.Validator;
import contracts.Boat;
import contracts.Race;
import exeptions.DuplicateModelException;

import java.util.*;

public class RaceImpl implements Race {

    private static final String DISTANCE = "Distance";

    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Map<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new HashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, DISTANCE);
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    private void setOceanCurrentSpeed(int oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    public Map<String, Boat> getRegisteredBoats() {
        return this.registeredBoats;
    }

    public void AddParticipant(Boat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<Boat> GetParticipants() {
        return new ArrayList<Boat>(this.registeredBoats.values());
    }
}