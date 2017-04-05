import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03ParseTags {
    private static final String UPCASE_OPEN = "<upcase>";
    private static final String UPCASE_CLOSE = "</upcase>";


    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();

        while (input.contains(UPCASE_OPEN)){
            int openIndex = input.indexOf(UPCASE_OPEN) + UPCASE_OPEN.length();
            int closeIndex = input.indexOf(UPCASE_CLOSE);

            String reminder = input.substring(openIndex, closeIndex);
            input = input.replace(UPCASE_OPEN + reminder + UPCASE_CLOSE, reminder.toUpperCase());
        }

        System.out.println(input);

    }
}
