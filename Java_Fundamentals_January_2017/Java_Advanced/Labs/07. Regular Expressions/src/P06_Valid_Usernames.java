import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_Valid_Usernames {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^[a-zA-Z\\-_\\d]{3,16}$");
        while (true){
            String username = in.readLine();
            if (username.equals("END")) break;

            Matcher matcher = pattern.matcher(username);

            if(matcher.find()) System.out.println("valid");
            else System.out.println("invalid");
        }

    }
}
