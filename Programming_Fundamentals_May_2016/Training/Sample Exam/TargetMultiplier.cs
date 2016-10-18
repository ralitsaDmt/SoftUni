using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Target_Multiplier
{
    class TargetMultiplier
    {
        static void Main(string[] args)
        {
            int[] size = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            int rows = size[0];
            int cols = size[1];

            long[][] matrix = new long[rows][];

            for (int row = 0; row < rows; row++)
            {
                matrix[row] = Console.ReadLine()
                    .Split()
                    .Select(long.Parse)
                    .ToArray();
            }

            int[] target = Console.ReadLine()
                    .Split()
                    .Select(int.Parse)
                    .ToArray();
            int targetRow = target[0];
            int targetCol = target[1];

            ShootTheMatrix(matrix, targetRow, targetCol);

            PrintMatrix(matrix);
        }

        private static void ShootTheMatrix(long[][] matrix, int targetRow, int targetCol)
        {
            long sum = 0;

            for (int row = targetRow - 1; row <= targetRow + 1; row++)
            {
                for (int col = targetCol - 1; col <= targetCol + 1; col++)
                {
                    if (row != targetRow || col != targetCol)
                    {
                        sum += matrix[row][col];
                        matrix[row][col] *= matrix[targetRow][targetCol];
                    }
                }
            }

            matrix[targetRow][targetCol] *= sum;
        }

        private static void PrintMatrix(long[][] matrix)
        {
            foreach (var row in matrix)
            {
                Console.WriteLine(string.Join(" ", row));
            }
        }
    }
}
