using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Condense_Array_to_Number
{
    class CondenseArrayToNumber
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            CondenseNumbers(numbers);
        }

        private static void CondenseNumbers(int[] numbers)
        {
            int condensedArray = 0;
            if (numbers.Length == 1)
            {
                condensedArray = numbers[0];
            }
            while (numbers.Length > 1)
            {
                int[] condensed = new int[numbers.Length - 1];
                SumNumbersToCondensed(numbers, condensed);
                numbers = condensed;
                condensedArray = condensed[0];
            }
            Console.WriteLine(condensedArray);            
        }

        private static void SumNumbersToCondensed(int[] numbers, int[] condensed)
        {
            for (int i = 0; i < condensed.Length; i++)
            {
                condensed[i] = numbers[i] + numbers[i + 1];
            }
        }
    }
}
