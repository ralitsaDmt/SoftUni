package Problem_03_SayHello;

public abstract class BasePerson implements Person {

    private String name;

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return null;
    }

    protected BasePerson (String name) {
        this.setName(name);
    }
}
