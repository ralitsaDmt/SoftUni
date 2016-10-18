using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class SetsOfElements
{
    static void Main(string[] args)
    {
        int[] counts = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToArray();

        int n = counts[0];
        int m = counts[1];

        List<int> setN = FillSet(n);
        List<int> setM = FillSet(m);

        var repeatingNumbers = FindRepeatingNumbers(setN, setM);

        Console.WriteLine(string.Join(" ", repeatingNumbers));
    }

    private static List<int> FindRepeatingNumbers(List<int> setN, List<int> setM)
    {
        var set = new List<int>();

        foreach (var num in setN)
        {
            if (setM.Contains(num))
            {
                set.Add(num);
            }
        }

        return set;
    }

    private static List<int> FillSet(int count)
    {
        var set = new List<int>();
        for (int i = 0; i < count; i++)
        {
            set.Add(int.Parse(Console.ReadLine()));
        }
        return set;
    }
}