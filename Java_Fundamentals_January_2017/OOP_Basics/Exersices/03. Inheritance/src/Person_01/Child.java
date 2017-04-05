package Person_01;

public class Child extends Person {

    private String name;
    private int age;

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public void setAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive!");
        }

        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }

        super.setAge(age);
    }
}
