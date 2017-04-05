import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String text = in.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            sb.append("\\u").append(String.format("%1$4s",
                    Integer.toHexString(text.codePointAt(i))).replace(' ', '0'));
        }

        System.out.println(sb);
    }
}
