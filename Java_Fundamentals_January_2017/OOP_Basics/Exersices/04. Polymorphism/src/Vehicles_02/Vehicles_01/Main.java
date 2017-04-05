package Vehicles_02.Vehicles_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] carData = in.readLine().split("\\s+");
        String[] truckData = in.readLine().split("\\s+");
        String[] busData = in.readLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carData[1]);
        double carFuelConsumption = Double.parseDouble(carData[2]);
        double carTankCapacity = Double.parseDouble(carData[3]);

        double truckFuelQuantity = Double.parseDouble(truckData[1]);
        double truckFuelConsumption = Double.parseDouble(truckData[2]);
        double truckTankCapacity = Double.parseDouble(truckData[3]);

        double busFuelQuantity = Double.parseDouble(busData[1]);
        double busFuelConsumption = Double.parseDouble(busData[2]);
        double busTankCapacity = Double.parseDouble(busData[3]);

        Car car = null;
        Truck truck = null;
        Bus bus = null;

        try {
            car = new Car(carFuelQuantity, carFuelConsumption, carTankCapacity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckTankCapacity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            bus = new Bus(busFuelQuantity, busFuelConsumption, busTankCapacity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int numberOfCommands = Integer.parseInt(in.readLine());

        for (int i = 0; i < numberOfCommands; i++) {

            String[] command = in.readLine().split("\\s+");

            String commandName = command[0].toLowerCase();
            String vehicleName = command[1].toLowerCase();
            double parameter = Double.parseDouble(command[2]);

            if (commandName.equals("drive")) {
                double distance = parameter;

                if (vehicleName.equals("car")) {
                    driveVehicle(car, distance);
                } else if (vehicleName.equals("truck")){
                    driveVehicle(truck, distance);
                } else if (vehicleName.equals("bus")) {
                    driveBus(bus, distance);
                }
            } else if (commandName.equals("driveempty")) {
                double distance = parameter;
                driveVehicle(bus, distance);
            } else if (commandName.equals("refuel")) {
                double fuelQuantity = parameter;

                if (vehicleName.equals("car")) {
                    refuelVehicle(car, fuelQuantity);
                } else if (vehicleName.equals("truck")) {
                    refuelVehicle(truck, fuelQuantity);
                } else {
                    refuelVehicle(bus, fuelQuantity);
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void driveBus(Bus bus, double distance) {
        try {
            bus.drive(distance, true);

            String formattedDistance = formatQuantity(distance);
            System.out.printf("Bus travelled %s km\n", formattedDistance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void refuelVehicle(Vehicle vehicle, double fuelQuantity) {
        try {
            vehicle.refuel(fuelQuantity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
