package CompanyHierarchy.Interfaces;

import java.util.Date;

public interface IProject {
    String getName();

    Date getStartDate();

    String getDetails();

    String getState();

    void closeProject();
}
