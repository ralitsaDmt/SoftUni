using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Max_Sequence_of_Equal_Elements
{
    class MaxSequenceOfEqualElements
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(new string[] { " " }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int maxCount = 1;
            int startIndex = 0;

            for (int current = 0; current < numbers.Length - 1; current++)
            {
                int count = 1;
                int index = 0;
                for (int next = current + 1; next < numbers.Length; next++)
                {
                    if (numbers[current] == numbers[next])
                    {
                        count++;
                        index = current;
                    }
                    else
                    {
                        break;
                    }
                }
                if (count > maxCount)
                {
                    maxCount = count;
                    startIndex = index;
                }
                current += count - 1;
            }

            PrintLongestSequence(numbers, startIndex, maxCount);
        }

        private static void PrintLongestSequence(int[] numbers, int index, int count)
        {
            for (int i = index; i < index + count; i++)
            {
                Console.Write($"{numbers[i]} ");
            }
            Console.WriteLine();
        }
    }
}
