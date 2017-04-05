import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += scan.nextDouble();
        }

        System.out.printf("%.2f", sum / 3);
    }
}
