package database;

import contracts.Boat;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;
import models.engines.BoatEngineImpl;

public class BoatSimulatorDatabase {

    Repository<Boat> boats;
    Repository<BoatEngineImpl> engines;

    public BoatSimulatorDatabase()
    {
        this.boats = new RepositoryImpl();
        this.engines = new RepositoryImpl();
    }

    public void addBoat(Boat boat) throws DuplicateModelException {
        this.boats.add(boat);
    }

    public void addEngine(BoatEngineImpl engine) throws DuplicateModelException {
        this.engines.add(engine);
    }

    public Boat getBoat(String model) throws NonExistantModelException {
        Boat boat = this.boats.getItem(model);
        return boat;
    }

    public BoatEngineImpl getEngine(String model) throws NonExistantModelException {
        BoatEngineImpl engine = this.engines.getItem(model);
        return engine;
    }
}
