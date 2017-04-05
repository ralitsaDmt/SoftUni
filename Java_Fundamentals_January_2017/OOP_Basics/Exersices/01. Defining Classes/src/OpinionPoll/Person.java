package OpinionPoll;

public class Person {
    public String name;
    public int age;

    public Person (){
        this ("No name", 1);
    }

    public Person (int age) {
        this ("No name", age);
    }

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }
}


