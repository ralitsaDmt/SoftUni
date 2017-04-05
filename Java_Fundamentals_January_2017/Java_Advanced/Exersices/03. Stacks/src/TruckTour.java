import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Deque<Station> circle = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            int petrol = Integer.parseInt(tokens[0]);
            int distance = Integer.parseInt(tokens[1]);

            Station pump = new Station(petrol, distance);

            circle.offer(pump);
        }

        int position = 0;
        boolean isFound = false;

        while (true){
            Station startStation = circle.poll();
            circle.offer(startStation);

            long totalAmount = startStation.amountOfPetrol;
            totalAmount -= startStation.distance;

            int currentStationsCount = 1;

            while (totalAmount >= 0){
                Station currentStation = circle.poll();

                if (currentStation == startStation){
                    isFound = true;
                    break;
                }

                circle.offer(currentStation);

                totalAmount += currentStation.amountOfPetrol;
                totalAmount -= currentStation.distance;

                currentStationsCount++;
            }

            if(isFound){
                break;
            }

            position += currentStationsCount;

        }

        System.out.println(position);
    }
}

class Station {
    public int amountOfPetrol;
    public int distance;

    public Station(int petrol, int distance){
        this.amountOfPetrol = petrol;
        this.distance = distance;
    }
}
