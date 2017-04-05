namespace MatrixRotation
{
    using System;
    using System.Collections.Generic;

    public class MatrixRotation
    {
        public static void Main(string[] args)
        {
            string[] command = Console.ReadLine().Split(new string[] { "(", ")" },
                StringSplitOptions.None);

            int degrees = int.Parse(command[1]);

            List<char[]> matrix = ReadMatrix();

            matrix = RotateMatrix(matrix, degrees);

            PrintMatrix(matrix);
        }

        private static void PrintMatrix(List<char[]> matrix)
        {
            foreach (char[] c in matrix)
            {
                Console.WriteLine(string.Join("", c));
            }
        }

        private static List<char[]> RotateMatrix(List<char[]> matrix, int degrees)
        {
            List<char[]> rotated = new List<char[]>();

            int rotations = degrees % 360;

            switch (rotations)
            {
                case 0: rotated = matrix;
                    break;
                case 90:
                    rotated = Rotate90(matrix); break;
                case 180:
                    rotated = Rotate180(matrix); break;
                case 270:
                    rotated = Rotate270(matrix); break;
            }
            return rotated;
        }

        private static List<char[]> Rotate270(List<char[]> matrix)
        {
            int maxLenght = FindMaxLenght(matrix);
            int rows = matrix.Count;

            List<char[]> rotated = new List<char[]>();
            for (int i = 0; i < maxLenght; i++)
            {
                rotated.Add(new char[rows]);
            }

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < matrix[i].Length; j++)
                {
                    rotated[maxLenght - j - 1][i] = matrix[i][j];
                }
            }

            return rotated;
        }

        private static List<char[]> Rotate90(List<char[]> matrix)
        {
            int maxLenght = FindMaxLenght(matrix);
            int rows = matrix.Count;

            List<char[]> rotated = new List<char[]>();
            for (int i = 0; i < maxLenght; i++)
            {
                rotated.Add(new char[rows]);
            }

            for (int i = rows - 1; i >= 0; i--)
            {
                for (int j = 0; j < matrix[i].Length; j++)
                {
                    rotated[j][rows - i - 1] = matrix[i][j];
                }
            }

            return rotated;
        }

        private static List<char[]> Rotate180(List<char[]> matrix)
        {
            int maxLenght = FindMaxLenght(matrix);
            int rows = matrix.Count;

            List<char[]> rotated = new List<char[]>();
            for (int i = 0; i < rows; i++)
            {
                rotated.Add(new char[maxLenght]);
            }

            for (int i = matrix.Count - 1; i >= 0; i--)
            {
                for (int j = 0; j < matrix[i].Length; j++)
                {
                    rotated[matrix.Count - i - 1][maxLenght - j - 1] = matrix[i][j];
                }
            }

            return rotated;
        }

        private static int FindMaxLenght(List<char[]> matrix)
        {
            int maxLength = int.MinValue;

            foreach (char[] list in matrix)
            {
                if (list.Length > maxLength) maxLength = list.Length;
            }

            return maxLength;
        }

        private static List<char[]> ReadMatrix()
        {
            List<char[]> matrix = new List<char[]>();

            while (true)
            {
                string line = Console.ReadLine();
                if(line.Equals("END")) break;

                matrix.Add(line.ToCharArray());
            }

            return matrix;
        }
    }
}