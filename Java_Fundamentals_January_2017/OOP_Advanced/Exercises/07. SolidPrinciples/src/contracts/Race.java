package contracts;

import exeptions.DuplicateModelException;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void AddParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> GetParticipants();
}
