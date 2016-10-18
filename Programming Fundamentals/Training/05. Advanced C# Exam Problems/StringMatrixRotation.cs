using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.String_Matrix_Rotation
{
    class StringMatrixRotation
    {
        static void Main(string[] args)
        {
            // Read the command
            char[] delimiters = { '(', ')' };
            string[] command = Console.ReadLine()
                .Split(delimiters, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            int degrees = int.Parse(command[1]);
            int rotate = degrees / 90 % 4;

            // Initilize matrix and fill it with content
            List<char[]> matrix = new List<char[]>();
            FillMatrix(matrix);

            
            switch (rotate)
            {
                case 0: PrintOriginalMatrix(matrix); break;
                case 1: Rotate90(matrix); break;
                case 2: Rotate180(matrix); break;
                case 3: Rotate270(matrix); break;
                default:
                    break;
            }
        }

        private static void PrintOriginalMatrix(List<char[]> matrix)
        {
            // Find Max Lenght in Matrix
            int length = FindMaxLengthElement(matrix);

            for (int row = 0; row < matrix.Count; row++)
            {
                for (int col = 0; col < length; col++)
                {
                    if (col >= matrix[row].Length)
                    {
                        Console.Write(" ");
                    }
                    else
                    {
                        Console.Write(matrix[row][col]);
                    }
                }
                Console.WriteLine();
            }
        }

        private static void Rotate270(List<char[]> matrix)
        {
            // Find Max Lenght in Matrix
            int length = FindMaxLengthElement(matrix);

            int row = matrix.Count - 1;

            for (int col = length - 1; col >= 0; col--)
            {
                for (row = 0; row < matrix.Count; row++)
                {
                    if (col >= matrix[row].Length)
                    {
                        Console.Write(" ");
                    }
                    else
                    {
                        Console.Write(matrix[row][col]);
                    }
                }
                Console.WriteLine();
                row = matrix.Count - 1;
            }
        }

        private static void Rotate180(List<char[]> matrix)
        {
            // Find Max Lenght in Matrix
            int length = FindMaxLengthElement(matrix);

            for (int row = matrix.Count - 1; row >= 0; row--)
            {
                for (int col = length - 1; col >= 0; col--)
                {
                    if (col >= matrix[row].Length)
                    {
                        Console.Write(" ");
                    }
                    else
                    {
                        Console.Write(matrix[row][col]);
                    }
                }
                Console.WriteLine();
            }

        }

        private static int FindMaxLengthElement(List<char[]> matrix)
        {
            int length = 0;
            foreach (char[] line in matrix)
            {
                if (line.Length > length)
                {
                    length = line.Length;
                }
            }
            return length;
        }

        private static void Rotate90(List<char[]> matrix)
        {
            // Find Max Lenght in Matrix
            int length = FindMaxLengthElement(matrix);

            int row = matrix.Count - 1;

            for (int col = 0; col < length; col++)
            {
                for (row = matrix.Count - 1; row >= 0; row--)
                {
                    if (col >= matrix[row].Length)
                    {
                        Console.Write(" ");
                    }
                    else
                    {
                        Console.Write(matrix[row][col]);
                    }
                }
                Console.WriteLine();
                row = matrix.Count - 1;
            }
            
        }

        private static void FillMatrix(List<char[]> matrix)
        {
            string input = Console.ReadLine();

            while (input != "END")
            {
                char[] line = input.ToCharArray();
                matrix.Add(line);
                input = Console.ReadLine();
            }
        }
    }
}
