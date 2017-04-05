import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05ConcatenatingStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(in.readLine())
            .append(" ");
        }

        System.out.println(sb);
    }
}
