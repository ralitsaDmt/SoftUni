package CompanyHierarchy.Models;

import CompanyHierarchy.Interfaces.IProject;

import java.util.Date;

public class Project implements IProject {
    private final String STATE_OPEN = "open";
    private final String STATE_CLOSE = "close";

    private String name;
    private Date startDate;
    private String details;
    private String state;

    public Project (String name, Date startDate, String details) {
        this.setName(name);
        this.setStartDate(startDate);
        this.setDetails(details);
        this.state = this.STATE_OPEN;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (name.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private void setStartDate (Date startDate) {
        this.startDate = startDate;
    }

    private void setDetails (String details) {
        if (details.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (details.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.details = details;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Date getStartDate() {
        return this.startDate;
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void closeProject() {
        this.state = this.STATE_CLOSE;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", details='" + details + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
