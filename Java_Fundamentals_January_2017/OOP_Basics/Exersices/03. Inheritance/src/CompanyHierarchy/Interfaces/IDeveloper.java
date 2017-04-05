package CompanyHierarchy.Interfaces;

import CompanyHierarchy.Models.Project;

import java.util.HashSet;

public interface IDeveloper extends IRegularEmployee {
     HashSet<Project> getProjects();
}
