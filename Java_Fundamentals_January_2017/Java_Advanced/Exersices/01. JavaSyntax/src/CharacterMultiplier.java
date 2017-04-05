import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str1 = scan.next();
        String str2 = scan.next();

        long sum = CalculateSum(str1, str2);
        System.out.println(sum);
    }

    private static long CalculateSum(String str1, String str2) {
        long sum = 0;

        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            sum += str1.charAt(i) * str2.charAt(i);
        }

        String longer = "";
        if (str1.length() == minLength && minLength != 0){
            longer = str2;
        }
        else{
            longer = str1;
        }

        for (int i = minLength; i < longer.length(); i++) {
            sum += longer.charAt(i);
        }

        return sum;
    }
}
