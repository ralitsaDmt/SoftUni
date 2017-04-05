import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] phrase = scan.nextLine().toCharArray();
        ArrayDeque<Character> reversed = new ArrayDeque<>();

        for (char ch :
                phrase) {
            reversed.push(ch);
        }

        while (!reversed.isEmpty()){
            System.out.print(reversed.pop());
        }
    }
}
