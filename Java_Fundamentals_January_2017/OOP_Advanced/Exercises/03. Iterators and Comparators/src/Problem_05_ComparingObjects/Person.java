package Problem_05_ComparingObjects;

public class Person implements Comparable {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setTown(String town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Object other) {
        Person otherPerson = (Person)other;

        int nameComparator = this.name.compareTo(otherPerson.getName());
        int ageComparator = this.age - otherPerson.getAge();
        int townComparator = this.town.compareTo(otherPerson.getTown());

        if (nameComparator == 0) {
            if (ageComparator == 0) {
                return townComparator;
            }
            return ageComparator;
        }
        return nameComparator;
    }
}
