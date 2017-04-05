import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x1 = scan.nextDouble();
        double y1 = scan.nextDouble();
        double x2 = scan.nextDouble();
        double y2 = scan.nextDouble();
        double x3 = scan.nextDouble();
        double y3 = scan.nextDouble();

        double sideA = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
        double sideB = Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
        double sideC = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));

        double area = 0;

        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA){
            double hp = (sideA + sideB + sideC) / 2;
            area = Math.sqrt(hp * (hp - sideA) * (hp - sideB) * (hp - sideC));
        }

        System.out.println((int)Math.round(area));
    }
}
