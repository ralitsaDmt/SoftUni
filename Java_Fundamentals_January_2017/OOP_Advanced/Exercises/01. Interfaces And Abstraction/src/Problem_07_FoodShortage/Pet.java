package Problem_07_FoodShortage;

public class Pet implements Birthable {

    private String name;
    private String birthdate;

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    public Pet(String name, String birthdate){
        this.setName(name);
        this.setBirthdate(birthdate);
    }
}
