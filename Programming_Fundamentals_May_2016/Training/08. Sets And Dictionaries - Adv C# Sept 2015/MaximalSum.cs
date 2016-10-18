using System;
using System.Collections.Generic;
using System.Linq;

class MaximalSum
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
        FillMatrix(matrix, rows, cols);

        Dictionary<string, int> results = FindMax3x3Platform(matrix, rows, cols);

        
        PrintResult(matrix, results);

    }

    private static void PrintResult(int[][] matrix, Dictionary<string, int> results)
    {
        int maxSum = results["maxSum"];
        int startRow = results["startRow"];
        int startCol = results["startCol"];

        Console.WriteLine($"Sum = {maxSum}");
        for (int row = startRow; row < startRow + 3; row++)
        {
            for (int col = startCol; col < startCol + 3; col++)
            {
                Console.Write(matrix[row][col] + " ");
            }
            Console.WriteLine(); ;
        }
    }

    private static Dictionary<string, int> FindMax3x3Platform(int[][] matrix, int rows, int cols)
    {
        
            int startRow = -1;
        int startCol = -1;
        int maxSum = int.MinValue;

        for (int row = 0; row < rows - 2; row++)
        {
            for (int col = 0; col < cols - 2; col++)
            {
                int sum = Find3x3Sum(matrix, row, col);
                if (sum > maxSum)
                {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        var results = new Dictionary<string, int>()
        {
            { "maxSum", maxSum},
            { "startRow", startRow},
            { "startCol", startCol }
        };
        return results;
    }
     
    private static int Find3x3Sum(int[][] matrix, int row, int col)
    {
        int sum = 0;
        for (int i = row; i < row + 3; i++)
        {
            for (int j = col; j < col + 3; j++)
            {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void FillMatrix(int[][] matrix, int rows, int cols)
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
