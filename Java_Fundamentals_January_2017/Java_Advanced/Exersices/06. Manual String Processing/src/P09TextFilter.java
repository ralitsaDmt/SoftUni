import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] banned = in.readLine().split(", ");

        String text = in.readLine();

        for (String word :
                banned) {
            text = text.replaceAll(word, wordToAst(word));
        }

        System.out.println(text);
    }

    private static String wordToAst(String word){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            sb.append('*');
        }

        return sb.toString();
    }

}
