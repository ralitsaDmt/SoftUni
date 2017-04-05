import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String word = in.readLine();

        String text = in.readLine();

        List<String> sentences = findSentences(word, text);
    }

    private static List<String> findSentences(String word, String text) {
        List<String> sentences = new ArrayList<>();

        Pattern pattern = Pattern.compile("[A-Z][\\w+\\s+\\-'\",:()\\/\\\\]+[.|!|?]");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            Pattern wordPattern = Pattern.compile("\\b" + word + "\\b");
            Matcher match = wordPattern.matcher(matcher.group());

            if(match.find()){
                System.out.println(matcher.group());
            }
        }

        return sentences;
    }
}
