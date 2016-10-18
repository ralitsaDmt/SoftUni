using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Fold_and_Sum
{
    class FoldAndSum
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            int k = numbers.Length / 4;

            int[] firstRow = new int[k * 2];
            int[] secondRow = new int[k * 2];
            int[] sum = new int[k * 2];

            FillFirstRaw(numbers, firstRow, k);
            FillSecondRaw(numbers, secondRow, k);
            SumFirstAndSecondRaw(sum, firstRow, secondRow, k);
            //Console.WriteLine(string.Join(" ",firstRow));
            //Console.WriteLine(string.Join(" ", secondRow));
            Console.WriteLine(string.Join(" ", sum));
        }

        private static void SumFirstAndSecondRaw(int[] sum, int[] firstRow, int[] secondRow, int k)
        {
            for (int i = 0; i < k * 2; i++)
            {
                sum[i] = firstRow[i] + secondRow[i];
            }
        }

        private static void FillSecondRaw(int[] numbers, int[] secondRow, int k)
        {
            int index = 0;

            for (int i = k; i < 3 * k; i++)
            {
                secondRow[index] = numbers[i];
                index++;
            }
        }

        private static void FillFirstRaw(int[] numbers, int[] firstRow, int k)
        {
            int index = 0;
            for (int i = k - 1; i >= 0; i--)
            {
                firstRow[index] = numbers[i];
                index++;
            }

            for (int i = 4 * k - 1; i >= 3 * k; i--)
            {
                firstRow[index] = numbers[i];
                index++;
            }
        }
    }
}
