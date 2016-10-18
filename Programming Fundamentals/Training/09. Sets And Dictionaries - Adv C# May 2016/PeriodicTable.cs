using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class PeriodicTable
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        List<string> elements = FillList(n);
        Console.WriteLine(string.Join(" ", elements
            .OrderBy(e => e)));
         
    }

    private static List<string> FillList(int n)
    {
        var elements = new List<string>();

        for (int i = 0; i < n; i++)
        {
            string[] line = Console.ReadLine().Split();
            foreach (var item in line)
            {
                if (!elements.Contains(item))
                {
                    elements.Add(item);
                }
            }
        }
        return elements;
    }
}

