import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_Extract_Tags {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String text = in.readLine();

        Pattern pattern = Pattern.compile("<.+?>");


        while (!text.equals("END")){
            Matcher matcher = pattern.matcher(text);

            while (matcher.find())
            System.out.println(matcher.group());

            text = in.readLine();
        }

    }
}
