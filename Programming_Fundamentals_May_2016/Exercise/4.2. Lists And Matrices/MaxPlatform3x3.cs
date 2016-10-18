using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Max_Platform_3_x_3
{
    class MaxPlatform3x3
    {
        static void Main(string[] args)
        {
            int[] size = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            int rows = size[0];
            int cols = size[1];

            int[][] matrix = new int[rows][];
            FillMatrix(matrix, rows);

            int maxSum = 0;
            int startRow = 0;
            int startCol = 0;

            for (int row = 0; row < rows - 2; row++)
            {
                for (int col = 0; col < matrix[row].Length - 2; col++)
                {
                    int sum = Find3x3Sum(matrix, row, col);
                    if (sum > maxSum)
                    {
                        maxSum = sum;
                        startRow = row;
                        startCol = col;
                    }
                }
                
            }
            Console.WriteLine(maxSum);
            PrintMaxPlatform(matrix, startRow, startCol);
        }

        private static int Find3x3Sum(int[][] matrix, int row, int col)
        {
            int sum = 0;

            for (int r = 0; r < row; r++)
            {
                for (int c = 0; c < col; c++)
                {
                    sum += matrix[r][c];
                }
                
            }

            return sum;
        }

        private static void FillMatrix(int[][] matrix, int rows)
        {
            for (int row = 0; row < rows; row++)
            {
                matrix[row] = Console.ReadLine()
                    .Split()
                    .Select(int.Parse)
                    .ToArray();
            }
        }

        private static void PrintMaxPlatform(long[][] matrix, int startRow, int startCol)
        {
            for (int row = startRow; row < startRow + 3; row++)
            {
                for (int col = startCol; col < startCol + 3; col++)
                {
                    Console.Write(matrix[row][col] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}
