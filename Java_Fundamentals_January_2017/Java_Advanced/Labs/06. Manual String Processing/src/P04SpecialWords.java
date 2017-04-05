import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P04SpecialWords {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] specialWords = in.readLine().split(" ");

        Map<String, Integer> counter = new HashMap<>();
        for (String word: specialWords) counter.put(word, 0);

        String text = in.readLine();

        String[] textArr = text.split("[\\p{Punct}\\s]+");

        for (int i = 0; i < textArr.length; i++) {
            for (int j = 0; j < specialWords.length; j++) {
                if(textArr[i].equalsIgnoreCase(specialWords[j])){
                    counter.put(specialWords[j], counter.get(specialWords[j]) + 1);
                }
            }
        }

        counter.entrySet().forEach(c -> System.out.printf("%s - %s\n", c.getKey(), c.getValue()));
    }
}
