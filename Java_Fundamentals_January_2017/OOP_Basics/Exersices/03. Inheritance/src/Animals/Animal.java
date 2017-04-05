package Animals;

import com.sun.deploy.util.StringUtils;
import com.sun.javaws.exceptions.InvalidArgumentException;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    Animal(String name, int age, String gender){
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name){
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private void setAge(int age){
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    protected void setGender(String gender){
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    public String produceSound(){
        String message = "Not implemented!";
        return message;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + this.name + " " + this.age + " " + this.gender;
    }
}
