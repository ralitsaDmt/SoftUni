import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P03FormattingNumbers {
    public static void main(String[] args) throws IOException {
       Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        String binary = Integer.toBinaryString(a);

        if(binary.length() > 10){
            binary = binary.substring(0, 10);
        }
        else{
            while (binary.length() < 10){
                binary = "0" + binary;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("|")
                .append(String.format("%-10x", a).toUpperCase())
                .append("|")
                .append(String.format("%s", binary))
                .append("|")
                .append(String.format("%10.2f", b))
                .append("|")
                .append(String.format("%-10.3f", c))
                .append("|");


        System.out.println(sb);
    }
}
