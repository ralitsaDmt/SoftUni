using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Matrix_of_Letters
{
    class MatrixOfLetters
    {
        static void Main(string[] args)
        {
            int[][] matrix = new int [5][];

            for (int i = 0; i < 5; i++)
            {
                matrix[i] = Console.ReadLine().Split().Select(int.Parse).ToArray();
            }


            //int rows = int.Parse(Console.ReadLine());
            //int cols = int.Parse(Console.ReadLine());

            //char[][] matrix = new char[rows][];


            //for (int currentRow = 0; currentRow < rows; currentRow++)
            //{
            //    matrix[currentRow] = new char[cols];
            //}

            //char filler = 'A';

            //for (int currentRow = 0; currentRow < matrix.GetLength(0); currentRow++)
            //{
            //    for (int currentCol = 0; currentCol <matrix[currentRow].Length; currentCol++)
            //    {
            //        matrix[currentRow][currentCol] = filler;
            //        filler++;
            //    }
            //}

            //for (int currentRow = 0; currentRow < matrix.GetLength(0); currentRow++)
            //{
            //    for (int currentCol = 0; currentCol < matrix[currentRow].Length; currentCol++)
            //    {
            //        Console.Write(matrix[currentRow][currentCol] + " ");
            //    }
            //    Console.WriteLine();
            //}

            ////foreach (var row in matrix)
            ////{
            ////    foreach (var col in matrix)
            ////    {
            ////        Console.Write(matrix[row][col] + " ");
            ////    }
            ////    Console.WriteLine();
            ////}

            //foreach (var row in matrix)
            //{
            //    Console.WriteLine(string.Join(" ", row));
            //}
        }
    }
}
