using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Diagonal_Difference
{
    class DiagonalDifference
    {
        static void Main(string[] args)
        {
            int size = int.Parse(Console.ReadLine());

            int[][] matrix = new int[size][];

            FillMatrix(matrix, size);

            int primaryDiagonal = 0;
            int secondaryDiagonal = 0;

            for (int i = 0; i < size; i++)
            {
                primaryDiagonal += matrix[i][i];
                secondaryDiagonal += matrix[i][size - 1 - i];
            }

            int diff = Math.Abs(primaryDiagonal - secondaryDiagonal);
            Console.WriteLine(diff);
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
    }
}
