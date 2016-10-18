using System;
using System.Numerics;
using System.Linq;

namespace _05.Convert_from_N_to_10
{
    class ConvertFromNTo10
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split();

            int baseToConvertFrom = int.Parse(input[0]);
            char[] number = input[1].ToCharArray();
            BigInteger converted = 0;

            int position = 0;
            for (int i = number.Length - 1; i >= 0; i--)
            {
                int current = int.Parse(number[i].ToString()) * (int)(Math.Pow(baseToConvertFrom, position));
                converted += current;
                position++;
            }            

            Console.WriteLine(converted);
        }
    }
}
