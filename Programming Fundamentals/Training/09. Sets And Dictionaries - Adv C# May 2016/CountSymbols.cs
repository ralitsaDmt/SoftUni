using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Count_Symbols
{
    class CountSymbols
    {
        static void Main(string[] args)
        {
            char[] symbols = Console.ReadLine().ToCharArray();

            var countSymbols = new Dictionary<char, int>();

            foreach (var symbol in symbols)
            {
                if (countSymbols.ContainsKey(symbol))
                {
                    countSymbols[symbol]++;
                }
                else
                {
                    countSymbols[symbol] = 1;
                }
            }

            var sorted = countSymbols.OrderBy(s => s.Key);
            foreach (var symbol in sorted)
            {
                Console.WriteLine($"{symbol.Key}: {symbol.Value} time/s");
            }
        }
    }
}