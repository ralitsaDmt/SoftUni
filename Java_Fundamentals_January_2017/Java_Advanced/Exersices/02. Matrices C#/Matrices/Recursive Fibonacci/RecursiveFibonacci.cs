namespace Recursive_Fibonacci
{
    using System;

    public class RecursiveFibonacci
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            long[] numbers = new long[n + 2];
            numbers[0] = 1;
            numbers[1] = 1;

            long result = Fib(numbers, n);
            Console.WriteLine(result);
        }

        private static long Fib(long[] numbers, int n)
        {
            if (numbers[n] == 0)
            {
                numbers[n] = Fib(numbers, n - 1) + Fib(numbers, n - 2);
            }

            return numbers[n];
        }
    }
}
