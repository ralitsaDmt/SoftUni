using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Nacepin
    {
        static void Main(string[] args)
        {
            decimal usPrice = decimal.Parse(Console.ReadLine());
            uint usWeight = uint.Parse(Console.ReadLine());
            decimal ukPrice = decimal.Parse(Console.ReadLine());
            uint ukWeight = uint.Parse(Console.ReadLine());
            decimal chPrice = decimal.Parse(Console.ReadLine());
            uint chWeight = uint.Parse(Console.ReadLine());

            decimal usPerKg = usPrice / usWeight / 0.58m;
            decimal ukPerKg = ukPrice / ukWeight / 0.41m;
            decimal chPerKg = chPrice / chWeight * 0.27m;

            decimal min = Math.Min(usPerKg, Math.Min(ukPerKg, chPerKg));
            decimal max = Math.Max(usPerKg, Math.Max(ukPerKg, chPerKg));

            string store = string.Empty;
            if (min == chPerKg)
            {
                store = "Chinese";
            }
            else if (min == ukPerKg)
            {
                store = "UK";
            }
            else if (min == usPerKg)
            {
                store = "US";
            }

            Console.WriteLine($"{store} store. {min:f2} lv/kg");
            Console.WriteLine($"Difference {(max - min):f2} lv/kg");
        }
    }
}
