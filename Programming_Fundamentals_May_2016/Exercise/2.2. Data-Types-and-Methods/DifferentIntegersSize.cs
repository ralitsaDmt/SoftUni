using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _17.Different_Integers_Size
{
    class DifferentIntegersSize
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            try
            {
                long num = long.Parse(input);
                List<string> types = new List<string>();

                if (num >= sbyte.MinValue && num <= sbyte.MaxValue)
                {
                    types.Add("sbyte");
                }
                if (num >= byte.MinValue && num <= byte.MaxValue)
                {
                    types.Add("byte");
                }
                if (num >= short.MinValue && num <= short.MaxValue)
                {
                    types.Add("short");
                }
                if (num > ushort.MinValue && num <= ushort.MaxValue)
                {
                    types.Add("ushort");
                }
                if (num >= int.MinValue && num <= int.MaxValue)
                {
                    types.Add("int");
                }
                if (num >= uint.MinValue && num <= uint.MaxValue)
                {
                    types.Add("uint");
                }
                if (num >= long.MinValue && num <= long.MaxValue)
                {
                    types.Add("long");
                }

                Console.WriteLine($"{num} can fit in:");
                for (int i = 0; i < types.Count; i++)
                {
                    Console.WriteLine($"* {types[i]}");
                }

            }
            catch
            {
                Console.WriteLine($"{input} can't fit in any type");
            }
        }
    }
}
