using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Hourglass_Sum
{
    class HourglassSum
    {
        static void Main(string[] args)
        {
            int rows = 6;
            long[][] matrix = new long[6][];
            FillMatrix(matrix, rows);

            long maxSum = long.MinValue;

            for (int row = 0; row < rows - 2; row++)
            {
                for (int col = 0; col < matrix[row].Length - 2; col++)
                {
                    long sum = CalculateHourglassSum(matrix, row, col);
                    if (sum > maxSum)
                    {
                        maxSum = sum;
                    }
                }
            }

            Console.WriteLine(maxSum);
        }

        private static long CalculateHourglassSum(long[][] matrix, int row, int col)
        {
            long sum = 0;

            for (int r = row; r < row + 3; r++)
            {
                for (int c = col; c < col + 3; c++)
                {
                    if (r == row + 1 && (c == col || c == col + 2))
                    {
                        continue;                        
                    }
                    else
                    {
                        sum += matrix[r][c];
                    }
                }
            }

            return sum;
        }

        private static void FillMatrix(long[][] matrix, int rows)
        {
            for (int row = 0; row < rows; row++)
            {
                matrix[row] = Console.ReadLine()
                    .Split()
                    .Select(long.Parse)
                    .ToArray();
            }
        }
    }
}
