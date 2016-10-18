using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Numbers
{
    static void Main(string[] args)
    {
        List<int> numbers = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToList();

        var greater = numbers.Where(x => x > numbers.Average()).OrderByDescending(x => x).ToList();


        if (greater.Count > 0)
        {
            Console.WriteLine(string.Join(" ", greater.Take(5)));
        }
        else
        {
            Console.WriteLine("No");
        }

        
    }
}