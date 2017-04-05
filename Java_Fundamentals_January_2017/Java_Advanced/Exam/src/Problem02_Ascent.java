import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Problem02_Ascent {

    private static Map<String, String> memorize;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        memorize = new LinkedHashMap<>();

        String regex = "[,_][a-zA-Z]+\\d";
        Pattern pattern = Pattern.compile(regex);

        while (true){
            String input = in.readLine();
            if (input.equals("Ascend")) {
                break;
            }

            String toBeReplaced;
            String decoded;

            for (Map.Entry<String, String> memo : memorize.entrySet()) {
                input = input.replace(memo.getKey(), memo.getValue());
            }


            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                toBeReplaced = matcher.group();

                decoded  = decodeWord(matcher.group());
                input = input.replaceAll(toBeReplaced, decoded);
                memorize.put(toBeReplaced, decoded);
            }

             System.out.println(input);
        }
    }

    private static String decodeWord(String word) {

        char sign = word.charAt(0);
        char[] seq = (word.substring(1, word.length() - 1)).toCharArray();
        Integer digit = Integer.parseInt(word.substring(word.length() - 1));

        int index = 1;
        if (sign == '_'){
            index = -1;
        }

        for (int i = 0; i < seq.length; i++) {
            seq[i] += index * digit;
        }

        StringBuilder sb = new StringBuilder();
        for (char aSeq : seq) {
            sb.append(aSeq);
        }

        return sb.toString();
    }
}
