using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.CountSubstringOccurrences
{
    class CountSubstringOccurrences
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine().ToLower();
            string subStr = Console.ReadLine().ToLower();

            int counter = 0;
            int offset = -1;
            
            for (int i = 0; i < text.Length; i++)
            {
                offset = text.IndexOf(subStr, offset + 1);
                if (offset >= 0)
                {
                    counter++;
                }
                else
                {
                    break;
                }
            }

            Console.WriteLine(counter);
        }
    }
}
