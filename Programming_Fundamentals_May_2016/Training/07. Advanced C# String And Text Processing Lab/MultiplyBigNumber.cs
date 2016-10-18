using System;
using System.Numerics;

namespace _08.Multiply_big_number
{
    class MultiplyBigNumber
    {
        static void Main(string[] args)
        {
            BigInteger num1 = BigInteger.Parse(Console.ReadLine());
            BigInteger num2 = BigInteger.Parse(Console.ReadLine());

            BigInteger product = num1 * num2;
            Console.WriteLine(product);
        }
    }
}
