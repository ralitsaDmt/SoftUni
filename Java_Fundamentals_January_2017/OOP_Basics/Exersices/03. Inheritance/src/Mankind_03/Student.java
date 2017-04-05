package Mankind_03;

public class Student extends Human{
    private String facultyNumber;

    public Student(String firstName, String lastName, String facltyNumber){
        super (firstName, lastName);

        this.setFacultyNumber(facltyNumber);
    }

    private void setFacultyNumber(String facultyNumber){
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Faculty number: " + this.facultyNumber;
    }
}
