package Problem_08_MilitaryElite.models;

import Problem_08_MilitaryElite.contracts.IRepair;

public class Repair implements IRepair {

    private String name;
    private int hoursWorked;

    private void setName(String name) {
        this.name = name;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Repair(String name, int hoursWorked) {
        this.setName(name);
        this.setHoursWorked(hoursWorked);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int gethoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {

        String partName = this.getName();
        int hoursWorked = this.gethoursWorked();

        String ouput = String.format("Part Name: %s Hours Worked: %s", partName, hoursWorked);

        return ouput;
    }
}
