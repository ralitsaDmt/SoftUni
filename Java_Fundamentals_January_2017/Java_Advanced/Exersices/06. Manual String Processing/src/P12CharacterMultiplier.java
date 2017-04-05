import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P12CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String first = scan.next();
        String second = scan.next();

        long sum = charMultiply(first, second);
        System.out.println(sum);
    }

    private static long charMultiply(String first, String second) {
        long sum = 0;

        int length = Math.min(first.length(), second.length());

        for (int i = 0; i < length; i++) {
            sum += first.charAt(i) * second.charAt(i);
        }

        for (int i = length; i < first.length(); i++) {
            sum += first.charAt(i);
        }

        for (int i = length; i < second.length(); i++) {
            sum += second.charAt(i);
        }

        return sum;
    }
}
