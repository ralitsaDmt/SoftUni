package contracts;

import exeptions.*;

import java.util.List;

public interface CommandHandler {
    String ExecuteCommand(String name, String... parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
