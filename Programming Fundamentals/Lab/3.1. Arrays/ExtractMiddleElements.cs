using System;
using System.Linq;

namespace _10.Extract_Middle_Elements
{
    class ExtractMiddleElements
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int length = numbers.Length;
                
            FindMiddleElements(numbers, length);
        }

        static void FindMiddleElements(int[] numbers, int length)
        {
            if (length == 1)
            {
                Console.WriteLine($"{{ {numbers[0]} }}");
            }
            else if (length % 2 == 0)
            {
                Console.WriteLine($"{{ {numbers[length / 2 - 1]}, {numbers[length / 2]} }}");
            }
            else
            {
                Console.WriteLine($"{{ {numbers[length / 2 - 1]}, {numbers[length / 2]}, {numbers[length / 2 + 1]} }}");
            }
        }


    }
}
