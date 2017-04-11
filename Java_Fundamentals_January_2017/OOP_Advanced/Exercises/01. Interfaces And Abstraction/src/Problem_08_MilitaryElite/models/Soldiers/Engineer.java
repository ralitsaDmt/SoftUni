package Problem_08_MilitaryElite.models.Soldiers;

import Problem_08_MilitaryElite.contracts.Soldiers.IEngineer;
import Problem_08_MilitaryElite.models.Repair;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedList<>();
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        String baseOutput = super.toString();
        String repairsInfo = this.getRepairsInfo();
        String engineerOutput = String.format("%s\nRepairs:%s",
                baseOutput, repairsInfo);
        return engineerOutput;
    }

    private String getRepairsInfo(){
        StringBuilder repairsBuilder = new StringBuilder();
        repairsBuilder.append("\n");

        for (Repair repair : this.repairs) {
            repairsBuilder.append("  ");
            repairsBuilder.append(repair.toString());
            repairsBuilder.append("\n");
        }

        if (repairsBuilder.length() > 0){
            int startSubstring = 0;
            int endSubstring = repairsBuilder.length() - 1;
            String trimmedBuilder = repairsBuilder.substring(startSubstring, endSubstring);

            return trimmedBuilder;
        }
        return repairsBuilder.toString();
    }
}
