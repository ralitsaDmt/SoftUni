package Demo;

public abstract class Person {

    private static final int DEFAULT_AGE = 0;
    private static final String DEFAULT_NAME = "PESHO";
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
        this.age = DEFAULT_AGE;
    }

    public Person() {
        this.name= DEFAULT_NAME;
        this.age = DEFAULT_AGE;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
