package Problem_03_CoffeMachine;

public interface CoffeMachineInterface {

    void buyCoffee(String size, String type);

    void insertCoin(String coin);

    Iterable<Coffee> coffeesSold();
}
