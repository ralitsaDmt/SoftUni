using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Sort_Numbers
{
    class SortNumbers
    {
        static void Main(string[] args)
        {
            List<string> number = new List<string>{ "hghfdgdhd", "nbjhklj", "ghj" };

            number = number.OrderBy(a => a.Length).ThenBy(a => a).ThenByDescending(a => a).ToList();
            Console.WriteLine(string.Join(" ", number));
        }
    }
}
