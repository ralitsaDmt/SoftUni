using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Matrix_Operator
{
    class MatrixOperator
    {
        static void Main(string[] args)
        {
            int rows = int.Parse(Console.ReadLine());
            
            List<List<long>> matrix = new List<List<long>>();
            for (int row = 0; row < rows; row++)
            {
                List<long> line = (Console.ReadLine()
                    .Split()
                    .Select(long.Parse)
                    .ToList());
                matrix.Add(line);
            }

            while (true)
            {
                string[] input = Console.ReadLine().Split();
                if (input[0] == "end")
                {
                    break;
                }

                string cmd = input[0];
                if (cmd == "remove")
                {
                    RemoveELements(matrix, input);
                }
                else if (cmd == "swap")
                {
                    SwapRows(matrix, input);
                }
                else if (cmd == "insert")
                {
                    InsertElements(matrix, input);
                }
                //PrintMatrix(matrix);
            }
            PrintMatrix(matrix);
        }

        private static void InsertElements(List<List<long>> matrix, string[] input)
        {
            int row = int.Parse(input[1]);
            long number = long.Parse(input[2]);

            matrix[row].Insert(0, number);
        }

        private static void SwapRows(List<List<long>> matrix, string[] input)
        {
            int firstRow = int.Parse(input[1]);
            int secondRow = int.Parse(input[2]);

            int firstLenght = matrix[firstRow].Count;
            int secondLenght = matrix[secondRow].Count;

            List<long> temp = new List<long>();
            temp.AddRange(matrix[firstRow]);

            matrix[firstRow].AddRange(matrix[secondRow]);
            matrix[secondRow].AddRange(temp);

            matrix[firstRow].RemoveRange(0, firstLenght);
            matrix[secondRow].RemoveRange(0, secondLenght);
        }

        private static void PrintMatrix(List<List<long>> matrix)
        {
            foreach (var row in matrix)
            {
                Console.WriteLine(string.Join(" ", row));
            }
        }

        private static void RemoveELements(List<List<long>> matrix, string[] input)
        {
            string type = input[1];
            string rowCol = input[2];
            int position = int.Parse(input[3]);

            if (rowCol == "row")
            {
                RemoveFromRow(matrix, type, position);
            }
            else
            {
                RemoveFromCol(matrix, type, position);
            }
        }

        private static void RemoveFromCol(List<List<long>> matrix, string type, int position)
        {
            int col = position;
            for (int row = 0; row < matrix.Count; row++)
            {
                if (col >= matrix[row].Count)
                {
                    continue;
                } 
                switch (type)
                {
                    case "positive": matrix[row] = matrix[row].Where(m => m < 0).ToList();
                        //if (matrix[row][col] >= 0)
                        //{
                            
                        //    //matrix[row].RemoveAt(col);
                        //}
                        break;
                    case "negative": matrix[row] = matrix[row].Where(m => m >= 0).ToList();
                        //if (matrix[row][col] < 0)
                        //{
                        //    matrix[row].RemoveAt(col);
                        //}
                        break;
                    case "odd": matrix[row] = matrix[row].Where(m => m % 2 == 0).ToList();
                        //if (matrix[row][col] % 2 != 0)
                        //{
                        //    matrix[row].RemoveAt(col);
                        //}
                        break;
                    case "even": matrix[row] = matrix[row].Where(m => m % 2 != 0).ToList();
                        //if (matrix[row][col] % 2 == 0)
                        //{
                        //    matrix[row].RemoveAt(col);
                        //}
                        break;
                }

            }
        }

        private static void RemoveFromRow(List<List<long>> matrix, string type, int position)
        {
            int row = position;
            for (int col = 0; col < matrix[row].Count; col++)
            {
                switch (type)
                {
                    case "positive":
                        if (matrix[row][col] >= 0)
                        {
                            matrix[row].RemoveAt(col);
                            col--;
                        }
                        break;
                    case "negative":
                        if (matrix[row][col] < 0)
                        {
                            matrix[row].RemoveAt(col);
                            col--;
                        }
                        break;
                    case "odd":
                        if (matrix[row][col] % 2 != 0)
                        {
                            matrix[row].RemoveAt(col);
                            col--;
                        }
                        break;
                    case "even":
                        if (matrix[row][col] % 2 == 0)
                        {
                            matrix[row].RemoveAt(col);
                            col--;
                        }
                        break;
                }
                
            }
        }
    }
}
