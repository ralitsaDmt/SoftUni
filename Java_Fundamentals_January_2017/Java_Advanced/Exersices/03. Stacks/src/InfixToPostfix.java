import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = in.readLine().split("\\s+");

        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();

        for(String token : tokens)
        {
            if (IsNumber(token))
            {
                output.offer(token);
            }
            else if(token.equals("("))
            {
                operators.push(token);
            }
            else if (IsRightAssociative(token))
            {
                output.offer(token);
            }
            else if (IsLeftAssociative(token))
            {
                if (!operators.isEmpty())
                {
                    while (!operators.isEmpty()){
                        String op2 = operators.peek();
                        if (((token.equals("+") || token.equals("-"))
                                && IsLeftAssociative(op2))
                                || ((token.equals("*") || token.equals("/"))
                        && (op2.equals("*") || op2.equals("/") || op2.equals("^"))))
                        {
                            output.offer(operators.pop());
                        }
                        else break;
                    }
                }

                operators.push(token);
            }
            else if (token.equals(")"))
            {
                while (!operators.peek().equals("("))
                {
                    output.offer(operators.pop());
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty())
        {
            output.offer(operators.pop());
        }

        System.out.println(String.join(" ", output));
    }

    private static boolean IsLeftAssociative(String token)
    {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean IsRightAssociative(String token)
    {
        return token.equals("^");
    }

    private static boolean IsNumber(String token)
    {
        String[] ops = {"+", "-", "*", "/", "(", ")"};
        for(String op  : ops){
            if(token.equals(op)) return false;
        }

        return true;
    }
}
