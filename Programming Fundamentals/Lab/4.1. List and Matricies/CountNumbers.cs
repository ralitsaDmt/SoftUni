using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Count_Numbers
{
    class CountNumbers
    {
        static void Main(string[] args)
        {
            List<int> numbers = new List<int>();
            numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .OrderBy(number => number)
                .ToList();

            int prevElement = numbers[0];
            int counter = 1;

            for (int currentElement = 1; currentElement < numbers.Count; currentElement++)
            {
                if (numbers[currentElement] == prevElement)
                {
                    counter++;
                }
                else
                {
                    Console.WriteLine("{0} -> {1}", prevElement, counter);
                    counter = 1;
                    prevElement = numbers[currentElement];
                }
            }
            Console.WriteLine("{0} -> {1}", prevElement, counter);
        }
    }
}
