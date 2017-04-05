import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbersNM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = scan.nextInt();
        int end = scan.nextInt();

        BigInteger product = new BigInteger("1");

        for (int i = start; i <= end ; i++) {

            product = product.multiply(new BigInteger("" + i));
        }

        System.out.printf("product[%d..%d] = %d", start, end, product);
    }
}
