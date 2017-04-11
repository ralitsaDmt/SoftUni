package Problem_08_MilitaryElite.models.Soldiers;

import Problem_08_MilitaryElite.contracts.Soldiers.ILeutenantGenral;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGenral{

    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedList<>();
    }

    public void addPrivate(Private privateSoldier) {
        this.privates.add(privateSoldier);
    }

    @Override
    public List<Private> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public String toString() {
        String baseOutput = super.toString();
        String privatesInfo = this.getPrivatesInfo();

        String leutenantGeneralOutput = String.format("%s\nPrivates:%s", baseOutput, privatesInfo);

        return leutenantGeneralOutput;
    }

    private String getPrivatesInfo() {
        StringBuilder privatesBuilder = new StringBuilder();
        privatesBuilder.append("\n");

        for (Private aPrivate : this.privates) {
            privatesBuilder.append("  ");
            privatesBuilder.append(aPrivate.toString());
            privatesBuilder.append("\n");
        }

        if (privatesBuilder.length() > 0) {
            String trimmedPrivateBuilder = privatesBuilder.substring(0, privatesBuilder.length() - 1);

            return trimmedPrivateBuilder;
        }
        return privatesBuilder.toString();
    }
}
