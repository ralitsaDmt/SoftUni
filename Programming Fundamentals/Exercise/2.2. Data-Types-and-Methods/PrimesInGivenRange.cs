using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _24.Primes_in_Given_Range
{
    class PrimesInGivenRange
    {
        static void Main(string[] args)
        {
            long start = long.Parse(Console.ReadLine());
            long end = long.Parse(Console.ReadLine());
            List<long> primes = new List<long>();
            FindPrimesInRange(start, end, primes);
            Console.WriteLine(string.Join(", ", primes)); 
            
        }

        private static void FindPrimesInRange(long start, long end, List<long> primes)
        {
            for (long i = start; i <= end; i++)
            {
                if (IsPrime(i))
                {
                    primes.Add(i);
                }
            }
        }

        private static bool IsPrime(long number)
        {
            bool prime = true;

            if (number == 0 || number == 1)
            {
                return (false);
            }
            for (int i = 2; i <= Math.Sqrt(number); i++)
            {
                if (number % i == 0)
                {
                    prime = false;
                    break;
                }
            }

            return prime;
        }
    }
}
