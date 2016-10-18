using System;
using System.Numerics;

namespace _07.Sum_big_numbers
{
    class SumBigNumbers
    {
        static void Main(string[] args)
        {
            BigInteger num1 = BigInteger.Parse(Console.ReadLine());
            BigInteger num2 = BigInteger.Parse(Console.ReadLine());

            BigInteger sum = num1 + num2;
            Console.WriteLine(sum);
        }
    }
}
