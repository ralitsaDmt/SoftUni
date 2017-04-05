import java.math.BigInteger;
import java.util.Scanner;

public class P05ConvertFromBaseNToBase10 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String baseStr = scan.next();
        String numStr = scan.next();

        BigInteger base = new BigInteger(baseStr);
        BigInteger num = new BigInteger(numStr);

        BigInteger result = new BigInteger("0");
        int power = 0;

        while(num.compareTo(new BigInteger("0")) > 0){
            BigInteger reminder = num.divideAndRemainder(new BigInteger("10"))[1];
            BigInteger divide = num.divide(new BigInteger("10"));

            BigInteger baseToMult = base.pow(power);

            result = result.add(baseToMult.multiply(reminder));
            power++;

            num = divide;
        }

        System.out.println(result);
    }
}
