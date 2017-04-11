package Problem_08_MilitaryElite.models.Soldiers;

import Problem_08_MilitaryElite.contracts.Soldiers.ISpecialisedSodier;
import Problem_08_MilitaryElite.enums.Corps;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSodier {

    private String corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps){
        String airforcesCorps = Corps.Airforces.toString();
        String marinesCorps = Corps.Marines.toString();

        if (!airforcesCorps.equals(corps)
                && !marinesCorps.equals(corps)) {
            throw new IllegalArgumentException("Invalid input");
        }

        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        String corps = this.getCorps();

        String baseOutput = super.toString();
        String corpsLine = String.format("Corps: %s",corps);
        String specialSoldierOutput = String.format("%s\n%s", baseOutput, corpsLine);

        return specialSoldierOutput;
    }
}
