import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sideA = scan.nextDouble();
        double sideB = scan.nextDouble();

        double area = (double)sideA * sideB;
        System.out.printf("%.2f", area);
    }
}
