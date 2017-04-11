package Problem_08_MilitaryElite.models.Soldiers;

import Problem_08_MilitaryElite.contracts.Soldiers.ISpy;

public class Spy extends Soldier implements ISpy {

    private int codeNumber;

    private void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    public Spy(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {

        int codeNumber = this.getCodeNumber();
        String baseOutput = super.toString();
        String spyOutput = String.format("%s\nCode Number: %s", baseOutput, codeNumber);

        return spyOutput;
    }
}
