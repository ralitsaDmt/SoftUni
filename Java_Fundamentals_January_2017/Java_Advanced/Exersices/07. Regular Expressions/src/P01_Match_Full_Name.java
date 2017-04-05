import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Match_Full_Name {
    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(([A-Z][a-z]+)\\s*){2}$");

        while (true){
            String name = in.readLine();
            if(name.equals("end")) break;

            Matcher matcher = pattern.matcher(name);

            if(matcher.find()){
                System.out.println(name);
            }

        }
    }
}
