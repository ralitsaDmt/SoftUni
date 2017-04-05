import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Problem02_OldestFamilyMember {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int peopleCount = Integer.parseInt(reader.readLine());

        Family family = new Family();
        for (int i = 0; i < peopleCount; i++) {
            String[] personData = reader.readLine().split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name, age);

            family.addMember(person);
        }

        System.out.println(family.getOldestMember());
    }

}

class Person {
    private String name;
    private int age;

    private void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}

class Family {
    private List<Person> people;

    public Family() {
        this.people = new LinkedList<>();
    }

    public void addMember(Person member) {
        this.people.add(member);
    }

    public Person getOldestMember(){

        Person oldestPerson = people.stream()
                .max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .get();

        return oldestPerson;
    }
}


