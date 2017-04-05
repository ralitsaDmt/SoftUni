package CompanyHierarchy.Models;

import CompanyHierarchy.Interfaces.IEmployee;
import CompanyHierarchy.Enums.Department;

public class Employee extends Person implements IEmployee {
    private double salary;
    private Department department;

    public Employee (int id, String firstName, String lastName, Department department) {
        super(id, firstName, lastName);
        this.setDepartment(department);
    }

    private void setSalary (double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.salary = salary;
    }

    private void setDepartment (Department department) {
        this.department = department;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public Department getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", department=" + department +
                '}';
    }
}
