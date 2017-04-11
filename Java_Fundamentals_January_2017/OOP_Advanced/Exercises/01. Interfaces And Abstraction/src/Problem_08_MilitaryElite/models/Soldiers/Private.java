package Problem_08_MilitaryElite.models.Soldiers;

import Problem_08_MilitaryElite.contracts.Soldiers.IPrivate;

public class Private extends Soldier implements IPrivate {

    private double salary;

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    @Override
    public String toString() {

        String baseOutput = super.toString();
        String salary = String.format("%.2f", this.getSalary()).replace(",", ".");

        String output = String.format("%s Salary: %s", baseOutput, salary);

        return output;
    }
}
