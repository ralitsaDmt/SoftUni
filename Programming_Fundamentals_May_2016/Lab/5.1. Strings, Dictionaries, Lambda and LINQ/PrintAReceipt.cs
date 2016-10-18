using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Print_a_Receipt
{
    class Program
    {
        static void Main(string[] args)
        {
            List<double> numbers = Console.ReadLine()
                .Split()
                .Select(double.Parse)
                .ToList();

            double sum = 0;
            Console.WriteLine("/----------------------\\");

            for (int i = 0; i < numbers.Count; i++)
            {
                Console.WriteLine("| {0, 20:f2} |", numbers[i]);
                sum += numbers[i];
            }
            Console.WriteLine("|----------------------|");

            Console.WriteLine("| Total:{0, 14:f2} |", sum);

            Console.WriteLine("\\----------------------/");
        }
    }
}
