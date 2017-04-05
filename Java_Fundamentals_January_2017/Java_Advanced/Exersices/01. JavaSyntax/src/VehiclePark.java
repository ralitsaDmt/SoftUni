import java.util.ArrayList;
import java.util.Scanner;

public class VehiclePark {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        ArrayList<String> park = new ArrayList<>();

        if (!input[0].equals("")){
            for (String in :
                    input) {
                park.add(in);
            }
        }

        int soldVehicles = 0;
        long price;

        String line = scan.nextLine();
        while (!line.equals("End of customers!")){
            String[] order = line.toLowerCase().split(" ");

            char vehicle = order[0].charAt(0);
            int seatsCount = Integer.parseInt(order[2]);
            boolean sold = false;

            for (int i = 0; i < park.size(); i++) {
                char vehicleAvailable = park.get(i).charAt(0);
                int seatsAvailable = Integer.parseInt(park.get(i).substring(1));

                if (vehicle == vehicleAvailable && seatsCount == seatsAvailable){
                    price = seatsCount * vehicle;
                    System.out.printf("Yes, sold for %d$\n", price);
                    park.remove(i);
                    soldVehicles++;
                    sold = true;
                    break;
                }

            }

            if (!sold){
                System.out.println("No");
            }
            line = scan.nextLine();
        }

        System.out.print("Vehicles left: ");

        if (park.size() > 0){
            for (int i = 0; i < park.size() - 1; i++) {
                System.out.printf("%s, ", park.get(i));
            }
            System.out.println(park.get(park.size() - 1));
        }
        else{
            System.out.println();
        }

        System.out.printf("Vehicles sold: %d", soldVehicles);
    }
}
