import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01ReverseString {
    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));
        }

        System.out.println(sb);
    }
}
