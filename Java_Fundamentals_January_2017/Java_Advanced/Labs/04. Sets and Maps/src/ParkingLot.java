import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashSet<String> parkingLot = new HashSet<>();

        while (true){
            String[] input = scan.nextLine().split(", ");

            if (input[0].equals("END")) break;

            if(input[0].equals("IN")){
                parkingLot.add(input[1]);
            }
            else{
                parkingLot.remove(input[1]);
            }
        }

        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else{
            for (String carNumber :
                    parkingLot) {
                System.out.println(carNumber);
            }
        }
    }
}
