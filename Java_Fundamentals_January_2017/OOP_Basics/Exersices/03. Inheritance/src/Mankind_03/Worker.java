package Mankind_03;

public class Worker extends Human {

    private double salary;
    private double workingHours;
    //private String lastName;

    public Worker(String firstName, String lastName, double salary, double workingHours){
        super(firstName, lastName);

        this.setSalary(salary);
        this.setWorkingHours(workingHours);
    }

    @Override
    protected void setLastName(String lastName){
        if (lastName.length() < 4){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }

        super.setLastName(lastName);
    }

    public double getSalary(){
        return this.salary;
    }

    private void setSalary(double salary) {
        if (salary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.salary = salary;
    }

    private void setWorkingHours(double workingHours) {
        if (workingHours < 1 || workingHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.workingHours = workingHours;
    }

    private double getMoneyByHour(){
        double moneyByHour = this.getSalary() / 7 / this.workingHours;
        return moneyByHour;
    }

    @Override
    public String toString() {

        String workerOutput = String.format("Week Salary: %.2f\nHours per day: %.2f\nSalary per hour: %.2f", this.salary, this.workingHours, this.getMoneyByHour()).replaceAll(",", ".");
        return super.toString() + workerOutput;
    }
}
