import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<Character> opening = new ArrayDeque<>();
        ArrayDeque<Character> closing = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (IsOpening(ch)) opening.push(ch);
            else if(!opening.isEmpty()){
                char p = opening.peek();
                if (p == '(' && ch == ')'
                        || p == '[' && ch == ']'
                        || p == '{' && ch == '}'){
                    opening.pop();
                }
                else{
                    closing.push(ch);
                }
            }
            else{
                isBalanced = false;
                break;
            }
        }

        if (!opening.isEmpty() && !closing.isEmpty() && opening.size() == closing.size()){
            isBalanced = CompareOpeningAndClosing(opening, closing);
        }
        else if(opening.size() != closing.size()) isBalanced = false;

        if (isBalanced) System.out.printf("YES");
        else System.out.printf("NO");
    }

    private static boolean CompareOpeningAndClosing(ArrayDeque<Character> opening, ArrayDeque<Character> closing) {
        while (!opening.isEmpty() && !closing.isEmpty()){
            char open = opening.pop(), close = closing.poll();
            if (open == '(' && close != ')'
                    || open == '[' && close != ']'
                    || open == '{' && close != '}'){
                return false;
            }
        }

        return opening.isEmpty() && closing.isEmpty();
    }

    public static boolean IsOpening(char ch){
        if (ch == '(' || ch == '[' || ch == '{') return true;

        return false;
    }
}
