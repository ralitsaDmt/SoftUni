import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            Pattern pattern = Pattern.compile("[" + ch + "]+");
            Matcher matcher = pattern.matcher(str);


            while (matcher.find()){
                str = str.replace(matcher.group(), String.valueOf(ch));
            }
        }

        System.out.println(str);
    }
}
