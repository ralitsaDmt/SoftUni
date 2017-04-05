package Animals;

public class Kitten extends Cat {
    private String gender;

    public Kitten (String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender){
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (!gender.equals("Female")) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    @Override
    public String produceSound(){
        String message = "Miau";
        return message;
    }
}
