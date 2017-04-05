package CompanyHierarchy.Interfaces;

import CompanyHierarchy.Models.Employee;

import java.util.HashSet;

public interface IManager extends IRegularEmployee {
    HashSet<Employee> getEmployees();
}
