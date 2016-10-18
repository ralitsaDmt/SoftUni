using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Rotate_and_Sum
{
    class RotateAndSum
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int turns = int.Parse(Console.ReadLine());

            int[] sum = new int[numbers.Length];

            for (int i = 1; i <= turns; i++)
            {
                for (int j = 0; j < numbers.Length; j++)
                {
                    sum[(i + j) % numbers.Length] += numbers[j];
                }
            }

            Console.WriteLine(string.Join(" ", sum));
        }
    }
}
