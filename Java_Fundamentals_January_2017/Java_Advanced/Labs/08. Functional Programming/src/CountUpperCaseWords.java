import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] text = in.readLine().split("\\s+");

        Predicate<String> checkUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> result = new ArrayList<>();

        for (String word :
                text) {
            if (checkUpperCase.test(word)) {
                result.add(word);
            }
        }

        System.out.println(result.size());
        System.out.println(String.join("\n", result));

    }
}
