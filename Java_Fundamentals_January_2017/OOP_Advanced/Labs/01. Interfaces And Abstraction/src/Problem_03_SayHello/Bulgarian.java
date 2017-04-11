package Problem_03_SayHello;

public class Bulgarian extends BasePerson {

    @Override
    public String sayHello() {
        return "Здравей";
    }

    public Bulgarian(String name) {
        super(name);
    }
}
