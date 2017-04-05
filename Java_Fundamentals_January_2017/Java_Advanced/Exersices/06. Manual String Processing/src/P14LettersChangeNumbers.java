import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));



        String[] input = in.readLine().split("\\s+");

        double totalSum = 0;

        for (String str : input){
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            double num = Double.parseDouble(str.substring(1, str.length() - 1));

            if (Character.isUpperCase(first)){
                totalSum += num / (first - 64);
            }
            else if(Character.isLowerCase(first)){
                totalSum += num * (first - 96);
            }

            if(Character.isUpperCase(last)){
                totalSum -= (last - 64);
            }
            else if(Character.isLowerCase(last)){
                totalSum += (last - 96);
            }
        }

        System.out.printf("%.2f", totalSum);
    }
}
