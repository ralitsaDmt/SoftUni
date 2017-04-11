package Problem_08_PetClinic;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind){
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    private void setName(String name){
        this.name = name;
    }

    private void setAge(int age){
        this.age = age;
    }

    private void setKind(String kind){
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        String output = String.format("%s %s %s",
                this.name, this.age, this.kind);
        return output;
    }
}
