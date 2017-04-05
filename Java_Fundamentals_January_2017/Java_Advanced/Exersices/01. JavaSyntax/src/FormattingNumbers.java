import java.text.DecimalFormat;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        String hex = Integer.toHexString(a).toUpperCase();
        int binary = Integer.parseInt(Integer.toBinaryString(a));

        System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|", hex, binary, b, c);
    }
}
