import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08MultiplyBigNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String bigNumber = reverseString(in.readLine());
        int num = Integer.parseInt(in.readLine());

        String product = multiplyNumber(bigNumber, num);
        System.out.println(product);
    }

    private static String multiplyNumber(String bigNumber, int num) {
        StringBuilder sb = new StringBuilder();

        if(bigNumber.equals("0") || num == 0){
            return "0";
        }
        else if(num == 1) {
            return bigNumber;
        }
        else{
            int extra = 0;
            for (int i = 0; i < bigNumber.length(); i++) {
                int temp = Integer.parseInt(String.valueOf(bigNumber.charAt(i))) * num + extra;

                sb.append(temp % 10);
                extra = temp / 10;
            }

            if(extra != 0){
                sb.append(extra);
            }
        }



        return sb.reverse().toString();
    }

    private static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
