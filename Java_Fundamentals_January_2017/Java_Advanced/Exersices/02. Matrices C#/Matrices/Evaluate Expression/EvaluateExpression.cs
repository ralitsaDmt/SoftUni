namespace Evaluate_Expression
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class EvaluateExpression
    {
        public static void Main(string[] args)
        {
            string[] tokens = Console.ReadLine().Split(' ');
            Queue<string> output = PolishReverse(tokens);

            decimal result = Evaluate(output);

            Console.WriteLine($"{result:f2}");

        }

        private static decimal Evaluate(Queue<string> output)
        {

            Stack<decimal> operands = new Stack<decimal>();
            Queue<string> operators = new Queue<string>();

            if (output.Count != 0)
            {
                while (output.Count != 0)
                {
                    if (IsNumber(output.Peek()))
                    {
                        operands.Push(decimal.Parse(output.Dequeue()));
                    }
                    else
                    {
                        operators.Enqueue(output.Dequeue());
                    }
                }
            }

            while (operands.Count > 1)
            {
                string op = operators.Dequeue();
                operands = CalcResult(operands, op);
            }

            return operands.Pop();
        }

        private static Stack<decimal> CalcResult(Stack<decimal> operands, string op)
        {
            decimal op2 = operands.Pop();
            decimal op1 = operands.Pop();
            switch (op)
            {
                case "+": operands.Push(op1 + op2); break;
                case "-": operands.Push(op1 - op2); break;
                case "*": operands.Push(op1 * op2); break;
                case "/": operands.Push(op1 / op2); break;
                case "^":
                    operands.Push((decimal)(Math.Pow((double)op1, (int)op2))); break;
            }

            return operands;
        }

        private static Queue<string> PolishReverse(string[] tokens)
        {
            Queue<String> output = new Queue<string>();
            Stack<string> operators = new Stack<string>();

            foreach (string token in tokens)
            {
                if (IsNumber(token))
                {
                    output.Enqueue(token);
                }
                else if (token == "(")
                {
                    operators.Push(token);
                    continue;
                }
                else if (IsRightAssociative(token))
                {
                    output.Enqueue(token);
                }
                else if (IsLeftAssociative(token))
                {
                    if (operators.Count != 0)
                    {
                        while (operators.Count > 0)
                        {
                            string op2 = operators.Peek();
                            if ((token == "+" || token == "-") && (op2 == "*" || op2 == "/")
                                || ((token == "*" || token == "/") && (op2 == "*" || op2 == "/" || op2 == "^")))
                            {
                                output.Enqueue(operators.Pop());
                            }
                            else break;
                        }
                    }

                    operators.Push(token);
                }
                else if (token == ")")
                {
                    while (operators.Peek() != "(")
                    {
                        output.Enqueue(operators.Pop());
                    }
                    operators.Pop();
                }
            }

            while (operators.Count != 0)
            {
                output.Enqueue(operators.Pop());
            }

            return output;
        }

        private static bool IsLeftAssociative(string token)
        {
            return token == "+" || token == "-" || token == "*" || token == "/";
        }

        private static bool IsRightAssociative(string token)
        {
            return token == "^";
        }

        private static bool IsNumber(string token)
        {
            string[] operators = { "+", "-", "*", "/", "(", ")" };
            return !operators.Contains(token);
        }
    }
}

