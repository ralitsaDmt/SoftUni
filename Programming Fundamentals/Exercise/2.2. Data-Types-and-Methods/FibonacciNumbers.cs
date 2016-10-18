using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _22.Fibonacci_Numbers
{
    class FibonacciNumbers
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            long fibNumber = Fib(n);
            Console.WriteLine(fibNumber);
        }

        private static long Fib(int n)
        {
            long a = 0;
            long b = 1;
            for (int i = 0; i <= n; i++)
            {
                long tmp = a;
                a = b;
                b += tmp;
            }
            return a;           
        }
    }
}
