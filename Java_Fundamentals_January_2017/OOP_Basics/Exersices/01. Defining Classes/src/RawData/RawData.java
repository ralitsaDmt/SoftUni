package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RawData {

    static List<Car> cars;

    public static void main(String[] args) throws IOException {
        cars = new LinkedList<>();

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
        Integer lines = Integer.parseInt(in.readLine());

        for (int i = 0; i < lines; i++) {
            String[] data = in.readLine().split("\\s+");

            String model = data[0];

            Integer engineSpeed = Integer.parseInt(data[1]);
            Integer enginePower = Integer.parseInt(data[2]);

            Integer cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            Double firstTyrePressure = Double.parseDouble(data[5]);
            Integer firstTireAge = Integer.parseInt(data[6]);
            Double secondTyrePressure = Double.parseDouble(data[7]);
            Integer secondTireAge = Integer.parseInt(data[8]);Double thirdTyrePressure = Double.parseDouble(data[9]);
            Integer thirdTireAge = Integer.parseInt(data[10]);Double fourthTyrePressure = Double.parseDouble(data[11]);
            Integer fourthTireAge = Integer.parseInt(data[12]);

            Tire firstTyre = new Tire(firstTyrePressure, firstTireAge);
            Tire secondTire = new Tire(secondTyrePressure, secondTireAge);
            Tire thirdTire = new Tire(thirdTyrePressure, thirdTireAge);
            Tire fourthTire = new Tire(fourthTyrePressure, fourthTireAge);

            Tire[] tires = { firstTyre, secondTire, thirdTire, fourthTire};

            Engine engine = new Engine(engineSpeed, enginePower);

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(model, engine, cargo, tires);

            cars.add(car);
        }

        String command = in.readLine();

        if (command.equals("fragile")){
            cars = cars.stream()
                    .filter(c -> c.getCargo().getType().equals(command)
                    && Arrays.stream(c.getTires()).anyMatch(t -> t.getPressure() < 1))
                    .collect(Collectors.toList());
        }
        else {
            cars = cars.stream()
                    .filter(c -> c.getCargo().getType().equals(command)
                            && c.getEngine().getPower() > 250)
                    .collect(Collectors.toList());
        }

        cars.forEach(c -> System.out.println(c.getModel()));
    }
}
