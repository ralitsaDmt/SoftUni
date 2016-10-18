using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Rotate_a_Matrix
{
    class RotateAMatrix
    {
        static void Main(string[] args)
        {
            int rows = int.Parse(Console.ReadLine());
            int cols = int.Parse(Console.ReadLine());
            var matrix = new string[rows][];
            for (int row = 0; row < rows; row++)
                matrix[row] = Console.ReadLine()
                  .Split(' ').ToArray();

            for (int currentCol = 0; currentCol < cols; currentCol++)
            {
                for (int currentRow = rows - 1; currentRow >= 0; currentRow--)
                {
                    Console.Write(matrix[currentRow][currentCol] + " ");
                }
                Console.WriteLine();
            }

        }
    }
}
