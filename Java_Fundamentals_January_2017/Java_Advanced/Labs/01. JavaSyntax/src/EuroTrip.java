import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double quantity = scan.nextDouble();

        BigDecimal rate = new BigDecimal("4210500000000");
        BigDecimal priceInLeva = new BigDecimal(quantity * 1.20);

        BigDecimal priceInMarks = priceInLeva.multiply(rate);

        System.out.printf("%.2f marks", priceInMarks);

    }
}
