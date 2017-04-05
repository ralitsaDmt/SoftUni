import java.math.BigInteger;
import java.util.Scanner;

public class P04ConvertFromBase10ToBaseN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String baseStr = scan.next();
        String numStr = scan.next();

        BigInteger base = new BigInteger(baseStr);
        BigInteger num = new BigInteger(numStr);

        StringBuilder sb = new StringBuilder();

        while(num.compareTo(new BigInteger("0")) > 0){
            BigInteger reminder = num.divideAndRemainder(base)[1];
            BigInteger divide = num.divideAndRemainder(base)[0];
            sb.append(reminder);
            num = divide;
        }

        System.out.println(sb.reverse());

    }
}
