import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int distance = scan.nextInt();
        String time = scan.next();

        double cost = 0;

        if (distance < 20){
            switch (time){
                case "day": cost = 0.70 + distance * 0.79; break;
                case "night": cost = 0.70 + distance * 0.90; break;
            }
        }
        else if (distance >= 20 && distance < 100){
            cost = distance * 0.09;
        }
        else{
            cost = distance * 0.06;
        }

        System.out.printf("%.2f", cost);
    }
}
