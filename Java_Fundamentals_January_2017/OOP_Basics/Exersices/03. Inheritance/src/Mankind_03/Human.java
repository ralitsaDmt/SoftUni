package Mankind_03;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName){
        char firstLetter = firstName.charAt(0);

        if (!Character.isUpperCase(firstLetter)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }

        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = firstName;
    }

    protected void setLastName(String lastName){
        char firstLetter = lastName.charAt(0);

        if (!Character.isUpperCase(firstLetter)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }

        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + this.firstName + "\n"
                + "Last Name: " + this.lastName + "\n";
    }
}
