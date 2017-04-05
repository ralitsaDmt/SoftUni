import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class P04CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "D:\\input.txt";

        char[] vowelsArr = "aouei".toCharArray();
        char[] punctuationArr = "?.!,".toCharArray();
        char[] consonantsArr = "bcdfghjklmnpqrstvwxyz".toCharArray();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {

            String s;
            long vowels = 0, consonants = 0, punctuation = 0;
            while((s = reader.readLine()) != null){

                for(int i = 0; i < s.length(); i++){
                    char ch = s.charAt(i);

                    if(Contains(vowelsArr, ch)) vowels++;
                    else if (Contains(consonantsArr, ch)) consonants++;
                    else if (Contains(punctuationArr, ch)) punctuation++;
                }
            }

            System.out.printf("Vowels: %s\n", vowels);
            System.out.printf("Consonants: %s\n", vowels);
            System.out.printf("Punctuation: %s\n", vowels);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean Contains(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ch) return true;
        }

        return false;
    }
}