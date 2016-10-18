using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Max_Sequence_of_Equal_Elements
{
    class MaxSequenceOfEqualElements
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToList();

            int bestStart = 0;
            int bestLenght = 0;

            for (int pos = 0; pos < numbers.Count - 1; pos++)
            {
                int start = pos;
                int lenght = 0;

                if (numbers[pos] == numbers[pos + 1])
                {
                    start = pos;
                    while (pos < numbers.Count - 1 && numbers[pos] == numbers[pos + 1])
                    {
                        lenght++;
                        pos++;
                    }
                }

                if (lenght > bestLenght)
                {
                    bestStart = start;
                    bestLenght = lenght;
                    pos += lenght - 1;
                }
            }

            for (int pos = bestStart; pos <= bestStart + bestLenght; pos++)
            {
                Console.Write(numbers[pos] + " ");
            }
            Console.WriteLine();
        }
    }
}
