import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P11Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] text = in.readLine().split("[\\s+,\\.!?]+");

        Set<String> palindromes = new TreeSet<>();

        for(String word: text){
            if(isPalindrome(word)){
                palindromes.add(word);
            }
        }

        System.out.println(palindromes);
    }

    private static boolean isPalindrome(String word) {
        if(word.length() == 1){
            return true;
        }

        for (int i = 0; i < word.length() / 2; i++) {
            if(word.charAt(i) != word.charAt(word.length()- i - 1)) return false;
        }

        return true;
    }
}
