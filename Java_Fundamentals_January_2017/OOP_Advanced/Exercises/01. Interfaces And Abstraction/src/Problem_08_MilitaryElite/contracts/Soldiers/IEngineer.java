package Problem_08_MilitaryElite.contracts.Soldiers;

import Problem_08_MilitaryElite.models.Repair;

import java.util.List;

public interface IEngineer {

    List<Repair> getRepairs();

    void addRepair(Repair repair);
}
