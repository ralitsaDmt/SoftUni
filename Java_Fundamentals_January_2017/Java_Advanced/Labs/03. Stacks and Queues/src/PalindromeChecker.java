import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();
        ArrayDeque<Character> collection = new ArrayDeque<>();

        for (char ch :
                input) {
            collection.offer(ch);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < collection.size() / 2; i++) {
            char first = collection.pop();
            char last = collection.pollLast();
            if (collection.pop() != collection.pollLast()){
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}
