using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;

namespace _04.Convert_from_10_to_N
{
    class ConvertFrom10ToN
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split();

            int baseToConvertTo = int.Parse(input[0]);
            BigInteger numberToConvert = BigInteger.Parse(input[1]);
            List<int> convertedNumber = new List<int>();

            //StringBuilder convertedNumber = new StringBuilder();

            while (numberToConvert != 0)
            {
                int reminder = (int)(numberToConvert % baseToConvertTo);
                convertedNumber.Add(reminder);
                numberToConvert /= baseToConvertTo;
            }

            convertedNumber.Reverse();
            Console.WriteLine(string.Join("", convertedNumber));

        }
    }
}
