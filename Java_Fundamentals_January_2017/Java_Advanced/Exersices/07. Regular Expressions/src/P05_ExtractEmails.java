import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-zA-Z0-9]{1}([-_\\.]?[a-zA-Z0-9]+)+@[a-zA-Z]+-?[a-zA-Z]+(.[a-zA-Z]+-?[a-zA-Z])+(?=\\.|,|$)");

        while (true){
            String line = in.readLine();
            if(line.equals("end")) break;

            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }


    }
}
