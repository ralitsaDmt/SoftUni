import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(", ");

        Function<String, Integer> parser = Integer::parseInt;

        int sum = 0;
        for (String s:
             input) {
            sum += parser.apply(s);
        }

        System.out.printf("Count = %s\n", input.length);
        System.out.printf("Sum = %s", sum);
    }
}
