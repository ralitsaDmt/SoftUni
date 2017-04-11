package Problem_07_FoodShortage;

public class Rebel implements Buyer {

    private String name;
    private int age;
    private String group;
    private int food;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food = this.food + 5;
    }
}
