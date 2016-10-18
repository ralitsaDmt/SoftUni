using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Matrix_Generator
{
    class MatrixGenerator
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine()
                .Split()
                .ToArray();

            string type = input[0];
            int rows = int.Parse(input[1]);
            int cols = int.Parse(input[2]);

            int[][] matrix = new int[rows][];
            AssignMatrix(matrix, rows, cols);

            switch (type)
            {
                case "A": FillMatrixTypeA(matrix, rows, cols); break;
                case "B": FillMatrixTypeB(matrix, rows, cols); break;
                case "C": FillMatrixTypeC(matrix, rows, cols); break;
                case "D": FillMatrixTypeD(matrix, rows, cols); break;
            }

            PrintMatrix(matrix);

        }

        private static void FillMatrixTypeD(int[][] matrix, int rows, int cols)
        {
            int element = 1;
            int row = -1;
            int col = -1;

            while (element < rows * cols)
            {
                row++;
                col++;
                while (row < rows && matrix[row][col] == 0)
                {
                    matrix[row][col] = element;
                    row++;
                    element++;
                }

                col++;
                row--;
                while (col < cols && matrix[row][col] == 0)
                {
                    matrix[row][col] = element;
                    col++;
                    element++;
                }

                col--;
                row--;
                while (row >= 0 && matrix[row][col] == 0)
                {
                    matrix[row][col] = element;
                    row--;
                    element++;
                }

                col--;
                row++;
                while (col >= 0 && matrix[row][col] == 0)
                {
                    matrix[row][col] = element;
                    col--;
                    element++;
                }
            }
        }

        private static void FillMatrixTypeC(int[][] matrix, int rows, int cols)
        {
            int element = 1;

            // Fill left diagonal
            int row = rows - 1;
            int col = 0;
            matrix[row][col] = element;
            element++;
            for (row = rows - 2; row >= 0; row--)
            {
                int temp = row;
                col = 0;
                while (row < rows)
                {
                    matrix[row][col] = element;
                    row++;
                    col++;
                    element++;
                }
                row = temp;
            }

            // Fill right diagonal
            for (col = 1; col < cols; col++)
            {
                row = 0;
                int temp = col;
                while (row <= rows - 1 && col <= cols - 1)
                {
                    matrix[row][col] = element;
                    row++;
                    col++;
                    element++;
                }
                col = temp;
            }
        }

        private static void FillMatrixTypeB(int[][] matrix, int rows, int cols)
        {
            int element = 1;

            for (int col = 0; col < cols; col++)
            {
                if (col % 2 == 0)
                {
                    for (int row = 0; row < rows; row++)
                    {
                        matrix[row][col] = element;
                        element++;
                    }
                }
                else
                {
                    for (int row = rows - 1; row >= 0; row--)
                    {
                        matrix[row][col] = element;
                        element++;
                    }
                }

            }
        }

        private static void AssignMatrix(int[][] matrix, int rows, int cols)
        {
            for (int row = 0; row < rows; row++)
            {
                matrix[row] = new int[cols];
            }
        }

        private static void PrintMatrix(int[][] matrix)
        {
            foreach (var row in matrix)
            {
                Console.WriteLine(string.Join(" ", row));
            }
        }

        private static void FillMatrixTypeA(int[][] matrix, int rows, int cols)
        {
            int element = 1;
            for (int col = 0; col < cols; col++)
            {
                for (int row = 0; row < rows; row++)
                {
                    matrix[row][col] = element;
                    element++;
                }
            }
        }
    }
}
