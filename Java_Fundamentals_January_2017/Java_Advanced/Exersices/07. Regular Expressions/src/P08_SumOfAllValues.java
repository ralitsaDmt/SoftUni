import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P08_SumOfAllValues {
    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String keyString = in.readLine();
        String[] keys = extractKeys(keyString);

        if(keys == null){
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String text = in.readLine();
        List<Double> numbers = extractNumbers(text, keys);

        double sum = numbers.stream().mapToDouble(f -> f).sum();

        if (sum > 0){
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }
        else {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }
    }

    private static List<Double> extractNumbers(String text, String[] keys) {
        List<Double> numbers = new ArrayList<>();

        String pattern = keys[0] + "(\\d+(\\.\\d+)?)" + keys[1];

        Pattern numPattern = Pattern.compile(pattern);

        Matcher matcher = numPattern.matcher(text);

        while (matcher.find()){
            numbers.add(Double.parseDouble(matcher.group(1)));
        }

        return numbers;
    }

    private static String[] extractKeys(String keyString) {

        String startKeyPattern = "^([a-zA-Z_]+)\\d+";
        String endKeyPattern = ".+\\d([a-zA-Z_]+)$";

        Pattern startPattern = Pattern.compile(startKeyPattern);
        Pattern endPattern = Pattern.compile(endKeyPattern);

        Matcher startMatcher = startPattern.matcher(keyString);
        Matcher endMatcher = endPattern.matcher(keyString);

        if(startMatcher.find() && endMatcher.find()){
            return new String[] {startMatcher.group(1), endMatcher.group(1)};
        }

        return null;
    }
}
