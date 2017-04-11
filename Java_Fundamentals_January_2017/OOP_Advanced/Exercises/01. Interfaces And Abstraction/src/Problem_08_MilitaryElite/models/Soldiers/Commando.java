package Problem_08_MilitaryElite.models.Soldiers;

import Problem_08_MilitaryElite.contracts.Soldiers.ICommando;
import Problem_08_MilitaryElite.models.Mission;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {

    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedList<>();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public String toString() {

        String baseOutput = super.toString();

        String missionsInfo = this.getMissionsInfo();
        String commandoOuput = String.format("%s\nMissions:%s", baseOutput, missionsInfo);

        return commandoOuput;
    }

    private String getMissionsInfo(){
        StringBuilder missionsBuilder = new StringBuilder();
        missionsBuilder.append("\n");

        for (Mission mission : this.missions) {
            missionsBuilder.append("  ");
            missionsBuilder.append(mission.toString());
            missionsBuilder.append("\n");
        }

        if (missionsBuilder.length() > 0) {
            String trimmedBuilder = missionsBuilder.substring(0, missionsBuilder.length() - 1);

            return trimmedBuilder;
        }

        return missionsBuilder.toString();
    }
}
