using System;
using System.Linq;

class FillTheMatrix
{
    static void Main()
    {
        int[] size = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToArray();
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++)
        {
            matrix[row] = new int[cols];
        }

        string type = Console.ReadLine();

        switch (type)
        {
            case "A": APatternFill(matrix, rows, cols); break;
            case "B": BPatternFill(matrix, rows, cols); break;
        }       
        
        PrintMatrix(matrix);
    }

    private static void APatternFill(int[][] matrix, int rows, int cols)
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

    private static void PrintMatrix(int[][] matrix)
    {
        foreach (var row in matrix)
        {
            Console.WriteLine(string.Join(" ", row));
        }
    }

    private static void BPatternFill(int[][] matrix, int rows, int cols)
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
}
