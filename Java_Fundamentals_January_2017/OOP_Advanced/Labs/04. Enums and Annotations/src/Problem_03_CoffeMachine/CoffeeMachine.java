package Problem_03_CoffeMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeMachine implements CoffeMachineInterface {

    private List<Coffee> coffeesSold;
    private int sum;

    public CoffeeMachine(){
        this.coffeesSold = new ArrayList<>();
    }

    @Override
    public void buyCoffee(String size, String type) {

        CoffeeSize coffeeSize = Enum.valueOf(CoffeeSize.class, size);

        int price = coffeeSize.getPrice();

        if (price <= this.sum) {
            CoffeeType coffeeType = Enum.valueOf(CoffeeType.class, type);
            Coffee coffee = new Coffee(coffeeSize, coffeeType);

            this.coffeesSold.add(coffee);
            this.sum = 0;
        }
    }

    @Override
    public void insertCoin(String coin) {
        Coin coinType = Enum.valueOf(Coin.class, coin);
        int coinValue = coinType.getValue();

        sum += coinValue;
    }

    @Override
    public Iterable<Coffee> coffeesSold() {
        return Collections.unmodifiableList(this.coffeesSold);
    }
}
