package Core;

import Utility.Constants;
import contracts.BoatSimulatorController;
import controllers.BoatSimulatorControllerImpl;
import enumeration.EngineType;
import exeptions.*;

import java.util.List;

public class CommandHandlerImpl implements contracts.CommandHandler {
    public BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.controller = controller;
    }

    public String ExecuteCommand(String name, String... parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                String model = parameters[0];
                int horsePower = Integer.parseInt(parameters[1]);
                int displacement = Integer.parseInt(parameters[2]);
                EngineType engineType = EngineType.valueOf(parameters[3]);

                if (engineType.equals(EngineType.Jet) || engineType.equals(EngineType.Sterndrive)) {
                    return this.controller.createBoatEngine(model, horsePower, displacement, engineType);
                }
                throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);

            case "CreateRowBoat":
                return this.controller.createRowBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]));
            case "CreateSailBoat":
                return this.controller.createSailBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]));
            case "CreatePowerBoat":
                return this.controller.createPowerBoat(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        parameters[2],
                        parameters[3]);
            case "CreateYacht":
                return this.controller.createYacht(
                        parameters[0],
                        Integer.parseInt(parameters[1]),
                        parameters[2],
                        Integer.parseInt(parameters[3]));
            case "OpenRace":
                return this.controller.openRace(
                        Integer.parseInt(parameters[0]),
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]),
                        Boolean.parseBoolean(parameters[3]));
            case "SignUpBoat":
                return this.controller.signUpBoat(parameters[0]);
            case "StartRace":
                return this.controller.startRace();
            case "GetStatistic":
                return this.controller.getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
