namespace Infix_to_Postfix
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq;

    public class InfixToPostfix
    {
        public static void Main(string[] args)
        {
            string[] tokens = Console.ReadLine().Split(' ');

            Queue<string> output = new Queue<string>();
            Stack<string> operators = new Stack<string>();

            foreach (string token in tokens)
            {
                if (IsNumber(token))
                {
                    output.Enqueue(token);
                }
                else if(token == "(")
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

            Console.WriteLine(string.Join(" ", output));

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
            string[] operators = {"+", "-", "*", "/", "(", ")"};
            return !operators.Contains(token);
        }
    }

    
}
