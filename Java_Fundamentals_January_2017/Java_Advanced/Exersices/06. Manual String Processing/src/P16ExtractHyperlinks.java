import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16ExtractHyperlinks {
    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String text = readText(in);


    }

    private static String readText(BufferedReader in) throws IOException {

        StringBuilder sb = new StringBuilder();

        while(true){
            String line = in.readLine();
            if(!line.equals("END")) break;

            sb.append(line);
        }

        return sb.toString();
    }
}
