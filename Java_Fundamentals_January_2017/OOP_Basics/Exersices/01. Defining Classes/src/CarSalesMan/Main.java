package CarSalesMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Map<String, Engine> engines;
    private static List<Car> cars;


    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Integer enginesCount = Integer.parseInt(in.readLine());
        engines = new HashMap<>();

        for (int i = 0; i < enginesCount; i++) {
            String[] data = in.readLine().split("\\s+");

            String model = data[0];

            if (data.length == 2){
                engines.put(model, new Engine(model, data[1]));
            }
            else if (data.length == 3){

                try{
                    Integer num = Integer.parseInt(data[2]);
                    engines.put(model, new Engine(model, data[1], data[2], "n/a"));
                }
                catch (Exception e){
                    engines.put(model, new Engine(model, data[1], "n/a", data[2]));
                }
            }
            else if (data.length == 4){
                engines.put(model, new Engine(model, data[1], data[2], data[3]));
            }
        }

        Integer carsCount= Integer.parseInt(in.readLine());
        cars = new LinkedList<>();

        for (int i = 0; i < carsCount; i++) {
            String[] data = in.readLine().split("\\s+");

            String model = data[0];
            Engine engine = engines.get(data[1]);

            if(data.length == 2){
                cars.add(new Car(model, engine));
            }
            else if (data.length == 3){

                try{
                    Integer num = Integer.parseInt(data[2]);
                    cars.add(new Car(model, engine, data[2], "n/a"));
                }
                catch (Exception e){
                    cars.add(new Car(model, engine, "n/a", data[2]));
                }

            }
            else if (data.length == 4){
                cars.add(new Car(model, engine, data[2], data[3]));
            }
        }

        for (Car car : cars) {
            System.out.println(car);
        }

    }
}
