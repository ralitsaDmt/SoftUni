package Vehicles_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] carData = in.readLine().split("\\s+");
        String[] truckData = in.readLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carData[1]);
        double carFuelConsuption = Double.parseDouble(carData[2]);

        double truckFuelQuantity = Double.parseDouble(truckData[1]);
        double truckFuelConsumption = Double.parseDouble(truckData[2]);

        Car car = new Car(carFuelQuantity, carFuelConsuption);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int numberOfCommands = Integer.parseInt(in.readLine());

        for (int i = 0; i < numberOfCommands; i++) {

            String[] command = in.readLine().split("\\s+");

            String commandName = command[0].toLowerCase();
            String vehicleName = command[1].toLowerCase();

            if (commandName.equals("drive")) {
                double distance = Double.parseDouble(command[2]);

                if (vehicleName.equals("car")) {
                    driveVehicle(car, distance);
                } else {
                    driveVehicle(truck, distance);
                }
            } else if (commandName.equals("refuel")) {
                double fuelQuantity = Double.parseDouble(command[2]);

                if (vehicleName.equals("car")) {
                    refuelVehicle(car, fuelQuantity);
                } else {
                    refuelVehicle(truck, fuelQuantity);
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static void refuelVehicle(Vehicle vehicle, double fuelQuantity) {
        vehicle.refuel(fuelQuantity);
    }

    private static void driveVehicle(Vehicle vehicle, double distance) {
        try {
            vehicle.drive(distance);

            String vehicleName = vehicle.getClass().getSimpleName();
            String formattedDistance = formatQuantity(distance);
            System.out.printf("%s travelled %s km\n", vehicleName, formattedDistance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String formatQuantity(double quantity) {
        if ((long)quantity == quantity) {
            return String.valueOf((long)quantity);
        }

        return String.valueOf(quantity);
    }
}
