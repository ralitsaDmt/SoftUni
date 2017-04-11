package Problem_01_Person;

public class Citizen implements Person, Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public void setId(String id) {
        this.id = id;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }


    public Citizen(String name, int age, String id, String birthdate){
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
    }
}
