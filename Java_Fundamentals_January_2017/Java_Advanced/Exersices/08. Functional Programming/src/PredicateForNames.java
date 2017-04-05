import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(in.readLine());

        String[] input = in.readLine().split("\\s+");

        Predicate<String> checkLength = s -> s.length() <= len;

        Arrays.stream(input).filter(checkLength)
        .forEach(System.out::println);
    }
}
