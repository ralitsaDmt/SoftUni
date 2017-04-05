import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class UpperStrings {
    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = Arrays.asList(in.readLine().split("\\s+"));

        strings.stream().map(String::toUpperCase)
                .forEach(x -> System.out.print(x + " "));
    }
}
