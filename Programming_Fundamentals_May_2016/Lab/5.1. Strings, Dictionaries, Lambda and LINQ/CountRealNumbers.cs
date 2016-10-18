using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Count_Real_Numbers
{
    class CountRealNumbers
    {
        static void Main(string[] args)
        {
            List<double> numbers = Console.ReadLine()
                .Split()
                .Select(double.Parse)
                .ToList();

            SortedDictionary<double, int> counts = CountOccurances(numbers);

            PrintResults(counts);            
        }

        private static void PrintResults(SortedDictionary<double, int> counts)
        {
            foreach (var count in counts)
            {
                Console.WriteLine($"{count.Key} -> {count.Value}");
            }
        }

        private static SortedDictionary<double, int> CountOccurances(List<double> numbers)
        {
            SortedDictionary<double, int> counts = new SortedDictionary<double, int>();

            foreach (var number in numbers)
            {
                if (counts.ContainsKey(number))
                {
                    counts[number]++;
                }
                else
                {
                    counts[number] = 1;
                }
            }

            return counts;
        }
    }
}
