using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.Equal_Sums
{
    class EqualSums
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            FindElement(numbers);
        }

        private static void FindElement(int[] numbers)
        {
            bool isFound = false;
            for (int i = 0; i < numbers.Length; i++)
            {
                int leftSum = findLeftSum(numbers, i);
                int rightSum = findRightSum(numbers, i);
                if (leftSum == rightSum)
                {
                    Console.WriteLine(i);
                    isFound = true;
                    return;
                }
            }
            if (!isFound)
            {
                Console.WriteLine("no");
            }
            
        }

        private static int findRightSum(int[] numbers, int current)
        {
            int sum = 0;
            if (current != numbers.Length - 1)
            {
                for (int i = numbers.Length - 1; i > current; i--)
                {
                    sum += numbers[i];
                }
            }
            return sum;
        }

        private static int findLeftSum(int[] numbers, int current)
        {
            int sum = 0;
            if (current != 0)
            {
                for (int i = 0; i < current; i++)
                {
                    sum += numbers[i];
                }
            }
            return sum;
        }
    }
}
