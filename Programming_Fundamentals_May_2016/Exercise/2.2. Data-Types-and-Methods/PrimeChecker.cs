using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _23.Prime_Checker
{
    class PrimeChecker
    {
        static void Main(string[] args)
        {
            long num = long.Parse(Console.ReadLine());

            bool prime = IsPrime(num);
            Console.WriteLine(prime);
        }

        private static bool IsPrime(long num)
        {
            bool prime = true;

            if (num == 0 || num == 1)
            {
                return (false);
            }
            for (int i = 2; i <= Math.Sqrt(num); i++)
            {
                if (num % i == 0)
                {
                    prime = false;
                    break;
                }
            }

            return prime;
        }
    }
}
