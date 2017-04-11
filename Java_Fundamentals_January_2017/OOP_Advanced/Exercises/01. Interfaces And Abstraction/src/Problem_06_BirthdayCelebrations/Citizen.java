package Problem_06_BirthdayCelebrations;

import Problem_01_Person.*;

public class Citizen implements Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    public Citizen(String name, int age, String id, String birthdate){
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
    }
}
