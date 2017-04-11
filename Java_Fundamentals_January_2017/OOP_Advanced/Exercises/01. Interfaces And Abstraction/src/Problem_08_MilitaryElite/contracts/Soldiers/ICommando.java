package Problem_08_MilitaryElite.contracts.Soldiers;

import Problem_08_MilitaryElite.models.Mission;

import java.util.List;

public interface ICommando {

    List<Mission> getMissions();

    void addMission(Mission mission);
}
