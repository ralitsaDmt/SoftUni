package CompanyHierarchy.Models;

import CompanyHierarchy.Enums.Department;
import CompanyHierarchy.Interfaces.IRegularEmployee;

public class RegularEmployee extends Employee implements IRegularEmployee {

    public RegularEmployee (int id, String firstName, String lastName, Department department) {
        super (id, firstName, lastName, department);
    }

    @Override
    public String toString() {
        return "RegularEmployee{}";
    }
}
