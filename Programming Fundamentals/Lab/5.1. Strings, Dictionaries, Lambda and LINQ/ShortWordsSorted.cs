using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Short_Words_Sorted
{
    class ShortWordsSorted
    {
        static void Main(string[] args)
        {
            List<string> words = Console.ReadLine()
                .ToLower()
                .Split()
                .Distinct()
                .ToList();

            Console.WriteLine(string.Join(", ", words.Where(word => word.Length < 5).OrderBy(word => word)));
        }
    }
}
