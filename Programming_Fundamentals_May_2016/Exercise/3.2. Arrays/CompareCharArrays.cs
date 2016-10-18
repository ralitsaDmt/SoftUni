using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Compare_Char_Arrays
{
    class CompareCharArrays
    {
        static void Main(string[] args)
        {
            char[] firstArray = Console.ReadLine()
                .Split()
                .Select(char.Parse)
                .ToArray();
            char[] secondArray = Console.ReadLine()
                .Split()
                .Select(char.Parse)
                .ToArray();

            int length = Math.Min(firstArray.Length, secondArray.Length);

            bool firstIsShorter = false;
            bool secondIsShorter = false;
            bool areEqual = false;
            for (int i = 0; i < length; i++)
            {
                if (firstArray[i] < secondArray[i])
                {
                    firstIsShorter = true;
                    break;
                }
                else if (secondArray[i] < firstArray[i])
                {
                    secondIsShorter = true;
                    break;
                }
                else
                {
                    areEqual = true;
                }
            }

            if (firstIsShorter ||
                (!firstIsShorter && !secondIsShorter && areEqual && firstArray.Length <= secondArray.Length))
            {
                Print(firstArray);
                Print(secondArray);
            }
            else if (secondIsShorter ||
                (!firstIsShorter && !secondIsShorter && areEqual && firstArray.Length > secondArray.Length))
            {
                Print(secondArray);
                Print(firstArray);
            }
        }

        private static void Print(char[] array)
        {
            Console.WriteLine(string.Join("", array));
        }
    }
}
