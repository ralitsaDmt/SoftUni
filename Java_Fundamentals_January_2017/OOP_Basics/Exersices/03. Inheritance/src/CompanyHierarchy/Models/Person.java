package CompanyHierarchy.Models;

import CompanyHierarchy.Interfaces.IPerson;

public class Person implements IPerson {
    private int id;
    private String firstName;
    private String lastName;

    protected Person(Integer id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.id = id;
    }

    private void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (firstName.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
}
