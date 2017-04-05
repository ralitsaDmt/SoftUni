package CompanyHierarchy.Models;

import CompanyHierarchy.Enums.Department;
import CompanyHierarchy.Interfaces.IDeveloper;

import java.util.HashSet;

public class Developer extends RegularEmployee implements IDeveloper {
    private HashSet<Project> projects;

    public Developer (int id, String firstName, String lastName) {
        super (id, firstName, lastName, Department.Production);

        projects = new HashSet<>();
    }

    @Override
    public HashSet<Project> getProjects() {
        return this.projects;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "projects=" + projects +
                '}';
    }
}
