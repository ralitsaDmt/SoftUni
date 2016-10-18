using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Largest_Frame_In_Matrix
{
    class LargestFrameInMatrix
    {
        static void Main(string[] args)
        {
            int[] size = Console.ReadLine()
                .Split(new string[] {" "}, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int rows = size[0];
            int cols = size[1];

            int[][] matrix = new int[rows][];
            FillMatrix(matrix, rows);
            
            List<string> results = new List<string>();
            bool foundFrame = false;
            int maxFrame = rows * cols;

            while (!foundFrame)
            {
                for (int top = 0; top < rows; top++)
                {
                    for (int left = 0; left < cols; left++)
                    {
                        for (int bottom = rows - 1; bottom >= top; bottom--)
                        {
                            for (int right = cols - 1; right >= left; right--)
                            {
                                bool isMaxSize = IsRequredSize(maxFrame, top, left, bottom, right);
                                bool areElementsEqual = areElementsInFrameEqual(matrix, top, left, bottom, right);


                                if (isMaxSize && areElementsEqual)
                                {
                                    AddCurrentFrameToList(results, top, left, bottom, right);
                                    foundFrame = true;
                                }
                            }
                        }
                    }
                }

                if (!foundFrame)
                {
                    maxFrame--;
                }
                else
                {
                    break;
                }
            }
            results.Sort();
            Console.WriteLine(string.Join(", ", results));
        }

        private static void AddCurrentFrameToList(List<string> results, int top, int left, int bottom, int right)
        {
            int heigth = bottom - top + 1;
            int width = right - left + 1;

            results.Add(string.Join("x", heigth, width));
        }

        private static bool areElementsInFrameEqual(int[][] matrix, int top, int left, int bottom, int right)
        {
            int element = matrix[top][left];

            for (int row = top; row <= bottom; row++)
            {
                if (matrix[row][left] != element || matrix[row][right] != element)
                {
                    return false;
                }               
            }
            for (int col = left; col <= right; col++)
            {
                if (matrix[top][col] != element || matrix[bottom][col] != element)
                {
                    return false;
                }
            }

            return true;
        }

        private static bool IsRequredSize(int maxFrame, int top, int left, int bottom, int right)
        {
            int heigth = bottom - top + 1;
            int width = right - left + 1;

            return heigth * width == maxFrame;
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
