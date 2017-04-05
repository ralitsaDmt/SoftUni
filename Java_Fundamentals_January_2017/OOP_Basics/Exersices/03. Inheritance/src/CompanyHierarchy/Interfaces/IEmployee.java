package CompanyHierarchy.Interfaces;

import CompanyHierarchy.Enums.Department;

public interface IEmployee extends IPerson {
    double getSalary();

    Department getDepartment();
}
