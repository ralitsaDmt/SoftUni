using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Plus_Remove
{
    class Program
    {
        static void Main(string[] args)
        {
            //input data
            string input = Console.ReadLine();
            List<string> original = new List<string>();
            int maxInputLength = 0;

            while (input != "END")
            {
                original.Add(input);
                if (input.Length > maxInputLength)
                {
                    maxInputLength = input.Length;
                }
                input = Console.ReadLine();
            }

            List<char[]> matrixToCheck = new List<char[]>();
            List<char[]> matrixToRemove = new List<char[]>();

            //fill two matricses with lines with equal length
            for (int i = 0; i < original.Count; i++)
            {
                char[] tmp1 = (original[i].ToLower() + new string(' ', maxInputLength - original[i].Length)).ToArray();
                char[] tmp2 = (original[i] + new string(' ', maxInputLength - original[i].Length)).ToArray();

                matrixToCheck.Add(tmp1);
                matrixToRemove.Add(tmp2);
            }

            //check matrixForCheck for plus-shapes
            for (int row = 1; row < matrixToRemove.Count - 1; row++)
            {
                for (int col = 1; col < maxInputLength - 1; col++)
                {
                    if (matrixToCheck[row][col] == matrixToCheck[row + 1][col] &&
                        matrixToCheck[row][col] == matrixToCheck[row - 1][col] &&
                        matrixToCheck[row][col] == matrixToCheck[row][col + 1] &&
                        matrixToCheck[row][col] == matrixToCheck[row][col - 1])
                    {
                        matrixToRemove[row][col] = '\0';
                        matrixToRemove[row - 1][col] = '\0';
                        matrixToRemove[row + 1][col] = '\0';
                        matrixToRemove[row][col - 1] = '\0';
                        matrixToRemove[row][col + 1] = '\0';
                    }
                }
            }

            //print matrix without the plus-shapes
            foreach (var row in matrixToRemove)
            {
                foreach (var col in row)
                {
                    if (col != '\0')
                    {
                        Console.Write(col);
                    }
                }
                Console.WriteLine();
            }

        }
    }
}
