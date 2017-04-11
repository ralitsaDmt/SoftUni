package Problem_03_CoffeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine machine = new CoffeeMachine();

        while (true) {
            String input = reader.readLine();
            if (input.equals("END")){
                break;
            }

            String[] data = input.split("\\s+");

            if (data.length == 1) {
                String coin = data[0];
                machine.insertCoin(coin);
            } else {
                String size = data[0].toUpperCase();
                String type = data[1].toUpperCase();
                machine.buyCoffee(size, type);
            }
        }
    }

}
