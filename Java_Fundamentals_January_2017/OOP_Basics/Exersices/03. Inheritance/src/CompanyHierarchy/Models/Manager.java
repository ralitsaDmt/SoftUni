package CompanyHierarchy.Models;

import CompanyHierarchy.Enums.Department;
import CompanyHierarchy.Interfaces.IManager;

import java.util.HashSet;

public class Manager extends Employee implements IManager {
    private HashSet<Employee> employees;

    public Manager (int id, String firstName, String lastName, Department department) {
        super (id, firstName, lastName, department);

        this.employees = new HashSet<>();
    }

    @Override
    public HashSet<Employee> getEmployees() {
        return this.employees;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employees=" + employees +
                '}';
    }
}
