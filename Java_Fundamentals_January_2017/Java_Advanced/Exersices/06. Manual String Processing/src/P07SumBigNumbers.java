import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String firstNum = reverseString(in.readLine());
        String secondNum = reverseString(in.readLine());

        StringBuilder sum = new StringBuilder();

        int len = Math.min(firstNum.length(), secondNum.length());

        int extra = 0;
        for (int i = 0; i < len; i++) {
            int temp = Integer.parseInt(String.valueOf(firstNum.charAt(i)))
                    + Integer.parseInt(String.valueOf(secondNum.charAt(i)))
                    + extra;

            if (temp >= 10){
                sum.append(temp % 10);
                extra = temp / 10;
            }
            else{
                sum.append(temp);
                extra = 0;
            }
        }

        if(firstNum.length() != secondNum.length()){
            String greater = firstNum.length() >= secondNum.length() ? firstNum : secondNum;

            for (int i = len; i < greater.length(); i++) {
                int temp = Integer.parseInt(String.valueOf(greater.charAt(i)))
                        + extra;

                if (temp >= 10){
                    sum.append(temp % 10);
                    extra = temp / 10;
                }
                else{
                    sum.append(temp);
                    extra = 0;
                }
            }
        }

        if(extra != 0){
            sum.append(extra);
        }

        System.out.println(sum.reverse());






    }

    private static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
