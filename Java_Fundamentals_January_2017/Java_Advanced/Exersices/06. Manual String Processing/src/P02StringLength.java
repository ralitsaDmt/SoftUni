import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();

        if(str.length() > 20) {
            System.out.println(str.substring(0, 20));
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(str);

            while (sb.length() < 20) sb.append("*");
            System.out.println(sb);
        }
    }
}
