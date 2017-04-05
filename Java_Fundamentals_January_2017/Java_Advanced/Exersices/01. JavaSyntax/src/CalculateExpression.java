import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        double power = (a + b + c) / Math.sqrt(c);
        double innerExpression = (Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2));
        double firstExpression = Math.pow(innerExpression, power);

        power = a - b;
        innerExpression = Math.pow(a, 2) + Math.pow(b,2) - Math.pow(c, 3);
        double secondExpression = Math.pow(innerExpression, power);

        double averageNumber = (a + b + c) / 3;
        double averageResult = (firstExpression + secondExpression) / 2;

        double diff = Math.abs(averageNumber - averageResult);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",
                firstExpression, secondExpression, diff);
    }
}
