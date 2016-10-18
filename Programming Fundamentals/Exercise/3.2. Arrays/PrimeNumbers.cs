using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Prime_Numbers
{
    class PrimeNumbers
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            if (n >= 2)
            {
                bool[] primes = new bool[n + 1];
                AssignPrimes(primes);
                primes[0] = false;
                primes[1] = false;

                PrintPrimes(primes);
                Console.WriteLine();
            }            
        }

        private static void PrintPrimes(bool[] primes)
        {
            for (int i = 0; i < primes.Length; i++)
            {
                if (primes[i])
                {
                    Console.Write($"{i} ");
                    for (int k = i + 1; k < primes.Length; k++)
                    {
                        if (k % i == 0)
                        {
                            primes[k] = false;
                        }
                    }
                }
            }
        }

        private static void AssignPrimes(bool[] primes)
        {
            for (int i = 0; i < primes.Length; i++)
            {
                primes[i] = true;
            }
        }
    }
}
