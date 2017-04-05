import java.util.Scanner;

public class CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double base = scan.nextDouble();
        double height = scan.nextDouble();

        double area = CalculateArea(base, height);
        System.out.printf("Area = %.2f\n", area);
    }

    static double CalculateArea(double base, double height){
        return base * height / 2;
    }
}
