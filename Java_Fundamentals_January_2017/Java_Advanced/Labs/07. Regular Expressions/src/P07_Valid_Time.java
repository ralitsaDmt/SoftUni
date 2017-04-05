import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_Valid_Time {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$");

        while (true){
            String line = in.readLine();
            if(line.equals("END")) break;

            Matcher matcher = pattern.matcher(line);
            if(matcher.find()){
                int hour = Integer.parseInt(matcher.group(1));
                int minutes = Integer.parseInt(matcher.group(2));
                int seconds = Integer.parseInt(matcher.group(3));

                if (hour >= 1 && hour <= 12
                        && minutes >= 0 && minutes <= 59
                        && seconds >= 0 && seconds <= 59){
                    System.out.println("valid");
                }
                else{
                    System.out.println("invalid");
                }
            }
            else{
                System.out.println("invalid");
            }
        }
    }
}
