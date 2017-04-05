import java.util.ArrayList;
import java.util.Scanner;

public class FromBaseSevenToDecimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int base = scan.nextInt();

        long sum = 0;

        int reminder, power = 0;
        while (base > 0){
            reminder = base % 10;
            sum += reminder * (int)Math.pow(7, power);
            base /= 10;
            power++;
        }

        System.out.println(sum);
    }
}
