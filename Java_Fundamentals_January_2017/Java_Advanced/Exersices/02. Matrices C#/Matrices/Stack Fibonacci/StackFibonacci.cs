namespace Stack_Fibonacci
{
    using System;
    using System.Collections.Generic;

    public class StackFibonacci
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Stack<long> fibNumbers = new Stack<long>();
            
            fibNumbers.Push(1);
            fibNumbers.Push(1);

            while (fibNumbers.Count <= n)
            {
                long f0 = fibNumbers.Pop();
                long f1 = fibNumbers.Peek();

                fibNumbers.Push(f0);
                fibNumbers.Push(f0 + f1);
            }

            Console.WriteLine(fibNumbers.Peek());
        }
    }
}
