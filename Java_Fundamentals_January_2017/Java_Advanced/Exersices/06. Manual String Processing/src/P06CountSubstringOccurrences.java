import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P06CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String text = in.readLine();
        String word = in.readLine();

        int offset = 0, counter = 0;

        for (int i = 0; i <= text.length() - word.length(); i++) {
            String substr = text.substring(i, i + word.length());

            if(substr.equalsIgnoreCase(word)){
                counter++;
            }
        }

        System.out.println(counter);
    }
}
