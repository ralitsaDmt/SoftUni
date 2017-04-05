package Animals;

public class Tomcat extends Cat{

    private String gender;

    public Tomcat (String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender){
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (!gender.equals("Male")) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    @Override
    public String produceSound(){
        String message = "Give me one million b***h";
        return message;
    }
}
