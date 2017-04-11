package controllers;

import Utility.Constants;
import contracts.Boat;
import contracts.BoatSimulatorController;
import contracts.Race;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;
import models.RaceImpl;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;
import models.engines.BoatEngineImpl;
import models.engines.JetBoatEngine;
import models.engines.SterndriveBoatEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {
    private Map<Double, Boat> map;
    private BoatSimulatorDatabase database;
    private Race currentRace;

    public BoatSimulatorControllerImpl() {
        this.map = new HashMap<>();
        this.database = new BoatSimulatorDatabase();
    }

    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngineImpl engine;
        switch (engineType) {
            case Jet:
                engine = new JetBoatEngine(model, horsepower, displacement);
                break;
            case Sterndrive:
                engine = new SterndriveBoatEngine(model, horsepower, displacement);
                break;
            default:
                throw new NotImplementedException();
        }

        this.database.addEngine(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, 1);
        this.database.addBoat(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.addBoat(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngineImpl firstEngine = this.database.getEngine(firstEngineModel);
        BoatEngineImpl secondEngine = this.database.getEngine(secondEngineModel);


        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.addBoat(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngineImpl engine = this.database.getEngine(engineModel);
        Boat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.addBoat(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %sm/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoat(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.AddParticipant(boat);
        return String.format("Boat with model %s has signed up for the current RaceImpl.", model);
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.GetParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANT_MESSAGE);
        }


        for (int i = 0; i < 3; i++) {
            findFastest(participants);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Double, Boat> doubleMotorBoatEntry : map.entrySet()) {
            result.append(String.format("First place: %s Model: %s Time: %s",
                    doubleMotorBoatEntry.getValue().getClass().getSimpleName().toString(),
                    doubleMotorBoatEntry.getValue().getModel(),
                    isFinished(doubleMotorBoatEntry.getKey())));
        }

        this.currentRace = null;

        return result.toString();
    }

    private String isFinished(Double key) {
        if (key == Double.NEGATIVE_INFINITY) {
            return "Did not finish!";
        }
        return String.format("%f.2 sec", key);
    }

    public String getStatistic() {
        //TODO Bonus Task Implement me
        throw new NotImplementedException();
    }

    private void findFastest(List<Boat> participants) {
        Double bestTime = 0.0;
        Boat winner = null;
        for (Boat participant : participants) {
            int oceanCurrentSpeed = this.currentRace.getOceanCurrentSpeed();
            Double speed = participant.calculateRaceSpeed(oceanCurrentSpeed, );
            Double time = this.currentRace.getDistance() / speed;
            if (time < bestTime) {
                bestTime = time;
                winner = participant;
            }
        }

        map.put(bestTime, winner);
        participants.remove(winner);
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
