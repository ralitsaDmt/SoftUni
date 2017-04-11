package Problem_07_EqualityLogic;

import java.util.Objects;

public class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        String output = String.format("%s %d", this.name, this.age);
        return output;
    }

    @Override
    public boolean equals(Object o) {
        Person otherPerson = (Person)o;

        return this.name.compareTo(otherPerson.getName()) == 0
                && this.age == otherPerson.getAge();
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        Person other = (Person)o;
        int nameComparator = this.name.compareTo(other.getName());
        int ageComparator = this.age - other.getAge();

        if (nameComparator == 0){
            return ageComparator;
        }

        return nameComparator;
    }
}
