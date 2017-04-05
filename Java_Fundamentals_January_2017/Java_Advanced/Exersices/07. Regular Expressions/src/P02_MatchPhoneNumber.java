import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("\\+359(\\s|-)\\d\\1\\d{3}\\1\\d{4}\\b");

        while (true){
            String number = in.readLine();
            if(number.equals("end")) break;

            Matcher matcher = pattern.matcher(number);
            if(matcher.find())
                System.out.println(number);
        }
    }
}
