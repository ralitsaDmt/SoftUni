package Problem_03_SayHello;

public class European extends BasePerson {

    @Override
    public String sayHello() {
        return "Hello";
    }

    public European(String name){
        super(name);
    }
}
