using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Sum_Arrays
{
    class SumArrays
    {
        static void Main(string[] args)
        {
            int[] firstArray = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int[] secondArray = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            int[] result = new int[Math.Max(firstArray.Length, secondArray.Length)];

            SumNumbers(firstArray, secondArray, result);
            Console.WriteLine(string.Join(" ", result));

        }

        private static void SumNumbers(int[] firstArray, int[] secondArray, int[] result)
        {
            for (int i = 0; i < result.Length; i++)
            {
                result[i] = firstArray[i % firstArray.Length] +
                    secondArray[i % secondArray.Length];
            }
        }
    }
}
