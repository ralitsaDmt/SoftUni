using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Target_Practice
{
    class TargetPractice
    {
        static void Main(string[] args)
        {
            int[] size = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();
            int rows = size[0];
            int cols = size[1];
            string input = Console.ReadLine();
            int[] impact = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            char[][] matrix = new char[rows][];
            int impactRow = impact[0];
            int impactCol = impact[1];
            int radius = impact[2];

            matrix = FillMatrix(matrix, rows, cols, input);

            ShootTheSnake(ref matrix, rows, cols, impactRow, impactCol, radius);

            PrintMatrix(matrix, rows, cols);
        }

        private static void ShootTheSnake(ref char[][] matrix, int rows, int cols, int impactRow, int impactCol, int radius)
        {
            int startRow = impactRow - radius;
            if (startRow < 0) startRow = 0;
            int endRow = impactRow + radius;
            if (endRow >= rows) endRow = rows - 1;

            int startCol = impactCol - radius;
            if (startCol < 0) startCol = 0;
            int endCol = impactCol + radius;
            if (endCol >= cols) endCol = cols - 1;

            int startC = impactCol;
            int endC = impactCol;
            int row = startRow;

            while (startC >= startCol && endC <= endCol)
            {
                for (int col = startC; col <= endC; col++)
                {
                    matrix[row][col] = '\0';
                }
                row++;
                startC--;
                endC++;
            }
            startC += 2;
            endC -= 2;
            while (startC <= impactCol && endC >= impactCol)
            {
                for (int col = startC; col <= endC; col++)
                {
                    matrix[row][col] = '\0';
                }
                startC++;
                endC--;
                row++;
            }
        }


        private static void PrintMatrix(char[][] matrix, int rows, int cols)
        {
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    Console.Write(matrix[row][col] + " ");
                }
                Console.WriteLine();
            }
        }

        private static char[][] FillMatrix(char[][] matrix, int rows, int cols, string input)
        {
            int stair = 1;
            int index = 0;

            for (int row = 0; row < rows; row++)
            {
                matrix[row] = new char[cols];
            }

            for (int row = rows - 1; row >= 0; row--)
            {
                if (stair % 2 != 0)
                {
                    for (int col = cols - 1; col >= 0; col--)
                    {
                        matrix[row][col] = input[index % input.Length];
                        index++;
                    }
                }
                else
                {
                    for (int col = 0; col < cols; col++)
                    {
                        matrix[row][col] = input[index % input.Length];
                        index++;
                    }
                }
                stair++;
            }
            return matrix;
        }
    }
}
