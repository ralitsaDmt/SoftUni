using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04._2_x_2_Squares_in_Matrix
{
    class SquaresInMatrix
    {
        static void Main(string[] args)
        {
            int[] size = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            int rows = size[0];
            int cols = size[1];

            char[][] matrix = new char[rows][];
            FillMatrix(matrix, rows);

            int countSquares = Count2x2Squares(matrix, rows);
            Console.WriteLine(countSquares);

        }

        private static int Count2x2Squares(char[][] matrix, int rows)
        {
            int count = 0;
            for (int row = 0; row < rows - 1; row++)
            {
                for (int col = 0; col < matrix[row].Length - 1; col++)
                {
                    if (matrix[row][col] == matrix[row][col + 1] &&
                        matrix[row][col] == matrix[row + 1][col] &&
                        matrix[row][col] == matrix[row + 1][col + 1])
                    {
                        count++;
                    }
                }
            }
            return count;
        }

        private static void FillMatrix(char[][] matrix, int rows)
        {
            for (int row = 0; row < rows; row++)
            {
                matrix[row] = Console.ReadLine()
                    .Split()
                    .Select(char.Parse)
                    .ToArray();
            }
        }
    }
}
