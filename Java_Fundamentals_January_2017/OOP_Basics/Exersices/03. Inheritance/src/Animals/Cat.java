package Animals;

public class Cat extends Animal {
    public Cat (String name, int age, String gender) {
        super (name, age, gender);
    }

    @Override
    public String produceSound(){
        String message = "MiauMiau";
        return message;
    }
}
