package SpeedRacing;

import SpeedRacing.SpeedCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpeedRacer {

    private static Map<String, SpeedCar> cars;

    public static void main(String[] args) throws IOException {
        cars = new LinkedHashMap();

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Integer count = Integer.parseInt(in.readLine());

        for (int i = 0; i < count; i++) {
            String[] data = in.readLine().split("\\s+");

            String model = data[0];
            Double fuel = Double.parseDouble(data[1]);
            Double cost = Double.parseDouble(data[2]);

            SpeedCar car = new SpeedCar(model, fuel, cost);

            cars.put(model, car);
        }

        while (true){
            String[] command = in.readLine().split("\\s+");
            if ("End".equals(command[0])){
                break;
            }

            String model = command[1];
            Integer kilometers = Integer.parseInt(command[2]);

            SpeedCar car = cars.get(model);

            try{
                car.drive(kilometers);
            }
            catch (Exception e){
                System.out.println("Insufficient fuel for the drive");
            }

            cars.put(model, car);
        }

        for (SpeedCar speedCar : cars.values()) {
            System.out.println(speedCar.getModel() + " "
            + String.format("%.2f", speedCar.getFuelAmount()).replaceAll(",", ".") + " "
            + speedCar.getDistanceTravelled());
        }
    }
}
