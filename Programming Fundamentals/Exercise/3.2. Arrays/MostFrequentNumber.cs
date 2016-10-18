using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Most_Frequent_Number
{
    class MostFrequentNumber
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            bool[] isChecked = new bool[numbers.Length];

            int maxElement = numbers[0];
            int maxCount = 1;

            for (int current = 0; current < numbers.Length - 1; current++)
            {
                isChecked[current] = true;
                int count = 1;
                int element = 0;
                for (int scan = current + 1; scan < numbers.Length; scan++)
                {
                    if (numbers[current] == numbers[scan] && !isChecked[scan])
                    {
                        count++;
                        element = numbers[scan];
                        isChecked[scan] = true;
                    }
                    if (count > maxCount)
                    {
                        maxCount = count;
                        maxElement = element;
                    }
                }
            }

            Console.WriteLine(maxElement);
        }
    }
}
