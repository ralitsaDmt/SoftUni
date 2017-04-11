package Problem_08_MilitaryElite.models.Soldiers;

import Problem_08_MilitaryElite.contracts.Soldiers.ISoldier;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public abstract class Soldier implements ISoldier {

    private int id;
    private String firstName;
    private String lastName;

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected Soldier(int id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String toString() {
        String output = "Name: " +  this.firstName + " " + this.lastName + " " + "Id: " + this.id;
        return output;
    }
}
