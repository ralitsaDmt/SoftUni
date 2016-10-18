using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.Sum_Reversed_Numbers
{
    class SumReversedNumbers
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();

            char[][] matrix = new char[input.Length][];

            for (int i = 0; i < input.Length; i++)
            {
                matrix[i] = input[i].ToCharArray();
            }

            int sum = CalculateSum(matrix);
            Console.WriteLine(sum);
        }

        private static int CalculateSum(char[][] matrix)
        {
            int sum = 0;
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                int rowSum = 0;
                int factor = 1;
                for (int col = 0; col < matrix[row].Length; col++)
                {
                    rowSum += factor * int.Parse(matrix[row][col].ToString());
                    factor *= 10;
                }
                sum += rowSum;
            }

            return sum;
        }
    }
}
