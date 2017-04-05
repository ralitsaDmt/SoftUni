import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();

        ArrayDeque<Integer> bracketIndex = new ArrayDeque<>();
        ArrayList<String> subexpressions = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '('){
                bracketIndex.push(i);
            }
            else if(ch == ')'){
                int startIndex = bracketIndex.pop();
                int endIndex = i + 1;
                String subexpression = expression.substring(startIndex, endIndex);
                subexpressions.add(subexpression);
            }
        }

        for (String exp :
                subexpressions) {
            System.out.println(exp);
        }
    }
}
