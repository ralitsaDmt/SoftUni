using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Blur_Filter
{
    class BlurFilter
    {
        static void Main(string[] args)
        {
            long blur = long.Parse(Console.ReadLine());

            int[] size = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int rows = size[0];
            int cols = size[1];

            long[,] matrix = new long[rows, cols];
            FillMatrix(matrix);

            int[] coordinates = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            AddBlur(matrix, blur, coordinates);
            PrintMatrix(matrix);
        }

        private static void PrintMatrix(long[,] matrix)
        {
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    Console.Write("{0} ", matrix[row, col]);
                }
                Console.WriteLine();
            }
        }

        private static void AddBlur(long[,] matrix, long blur, int[] coordinates)
        {
            int blurRow = coordinates[0];
            int blurCol = coordinates[1];

            matrix[blurRow, blurCol] += blur;
            if (blurRow - 1 >= 0)
            {
                if (blurCol - 1 >= 0)
                {
                    matrix[blurRow - 1, blurCol - 1] += blur;
                }
                matrix[blurRow - 1, blurCol] += blur;
                if (blurCol + 1 < matrix.GetLength(1))
                {
                    matrix[blurRow - 1, blurCol + 1] += blur;
                }
            }

            if (blurCol - 1 >= 0)
            {
                matrix[blurRow, blurCol - 1] += blur;
            }
            if (blurCol + 1 < matrix.GetLength(1))
            {
                matrix[blurRow, blurCol + 1] += blur;
            }

            if (blurRow + 1 < matrix.GetLength(0))
            {
                if (blurCol - 1 >= 0)
                {
                    matrix[blurRow + 1, blurCol - 1] += blur;
                }
                matrix[blurRow + 1, blurCol] += blur;
                if (blurCol + 1 < matrix.GetLength(1))
                {
                    matrix[blurRow + 1, blurCol + 1] += blur;
                }
            }

        }

        private static void FillMatrix(long[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                long[] input = Console.ReadLine()
                    .Split(' ')
                    .Select(long.Parse)
                    .ToArray();
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    matrix[i, j] = input[j];
                }
            }
        }
    }
}
