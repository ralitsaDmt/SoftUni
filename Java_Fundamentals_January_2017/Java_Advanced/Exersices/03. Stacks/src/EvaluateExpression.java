import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;

public class EvaluateExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = in.readLine().split("\\s+");

        Queue<String> output = PolishReverse(tokens);

        Double result = Evaluate(output);

        System.out.printf("%.2f", result);
    }

    private static Double Evaluate(Queue<String> output) {
        Deque<Double> result = new ArrayDeque<>();

        while(!output.isEmpty()){
            if(IsNumber(output.peek())){
                result.push(Double.parseDouble(output.poll()));
            }
            else{
                String op = output.poll();

                double op2 = result.pop();
                double op1 = result.pop();

                switch (op){
                    case "+": result.push(op1 + op2); break;
                    case "-": result.push(op1 - op2); break;
                    case "*": result.push(op1 * op2); break;
                    case "/": result.push(op1 / op2); break;
                }
            }
        }

        return result.pop();
    }

    private static ArrayDeque<String> PolishReverse(String[] tokens) {
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

        return output;
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
