using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Square_Numbers
{
    class SquareNumbers
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToList();

            var squareNums = numbers.Where(num => Math.Sqrt(num) == (int)(Math.Sqrt(num))).OrderBy(num => -num);

            Console.WriteLine(string.Join(" ", squareNums));
        }
    }
}
