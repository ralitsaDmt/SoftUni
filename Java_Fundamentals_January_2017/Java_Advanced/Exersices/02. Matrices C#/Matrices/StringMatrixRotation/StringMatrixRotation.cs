namespace StringMatrixRotation
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class StringMatrixRotation
    {
        public static void Main(string[] args)
        {
            string[] command = Console.ReadLine().Split(new string[] {"(", ")"},
                StringSplitOptions.None);

            int degrees = int.Parse(command[1]);

            List<List<char>> matrix = ReadMatrix();

            matrix = RotateMatrix(matrix, degrees);

            PrintMatrix(matrix);

        }

        private static List<List<char>> RotateMatrix(List<List<char>> matrix, int degrees)
        {
            List<List<char>> rotated = new List<List<char>>();

            int rotation = degrees % 360;
            switch (rotation)
            {
                case 0:
                    rotated = matrix; break;
                case 90: rotated = Rotate90(matrix); break;
                case 180:
                    rotated = Rotate180(matrix); break;
            }

            return rotated;
        }

        private static List<List<char>> Rotate180(List<List<char>> matrix)
        {
            int maxLenght = FindMaxLenght(matrix);
            List<List<char>> rotated = FillWhiteSpaces(maxLenght, matrix);

            for (int i = matrix.Count - 1; i >= 0 ; i--)
            {
                rotated.Add(new List<char>());
                for (int j = matrix[i].Count - 1; j >= 0; j--)
                {
                    rotated[i - matrix[i].Count - 1].Add(matrix[i][j]);
                }
            }

            return rotated;
        }

        private static List<List<char>> FillWhiteSpaces(int maxLenght, List<List<char>> matrix)
        {
            List<List<char>> rotated = new List<List<char>>();

            for (int i = matrix.Count - 1; i >= 0; i--)
            {
                rotated.Add(new List<char>());
                int blancs = maxLenght - matrix[i].Count;

                for (int j = 0; j < blancs; j++)
                {
                    rotated[matrix.Count - i - 1].Add(' ');
                }
            }

            return rotated;
        }

        private static List<List<char>> Rotate90(List<List<char>> matrix)
        {
            int maxLenght = FindMaxLenght(matrix);
            List<List<char>> rotated = InitializeRotatedMatrix(maxLenght);
            
            for (int i = matrix.Count - 1; i >= 0; i--)
            {
                int index = 0;
                for (int j = 0; j < matrix[i].Count; j++)
                {
                    rotated[j].Add(matrix[i][j]);
                    index = j;
                }

                index++;
                while (index < rotated.Count)
                {
                    rotated[index].Add(' ');
                    index++;
                }
            }

            return rotated;
        }

        private static List<List<char>> InitializeRotatedMatrix(int maxLenght)
        {
            List<List<char>> rotated = new List<List<char>>();
            for (int i = 0; i < maxLenght; i++)
            {
                rotated.Add(new List<char>());
            }

            return rotated;
        }

        private static int FindMaxLenght(List<List<char>> matrix)
        {
            int maxLength = int.MinValue;

            foreach (List<char> list in matrix)
            {
                if (list.Count > maxLength) maxLength = list.Count;
            }

            return maxLength;
        }

        private static void PrintMatrix(List<List<char>> matrix)
        {
            foreach (List<char> list in matrix)
            {
                Console.WriteLine(string.Join("", list));
            }
        }

        private static List<List<char>> ReadMatrix()
        {
            List<List<char>> matrix = new List<List<char>>();

            while (true)
            {
                string input = Console.ReadLine();
                if(input.Equals("END")) break;

                matrix.Add(input.ToCharArray().ToList());
            }

            return matrix;
        }
    }
}
