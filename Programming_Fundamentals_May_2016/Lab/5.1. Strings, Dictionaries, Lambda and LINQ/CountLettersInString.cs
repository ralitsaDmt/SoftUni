using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Count_Letters_in_String
{
    class CountLettersInString
    {
        public static void Main(string[] args)
        {
            char[] text = Console.ReadLine().ToLower().ToCharArray();
            Array.Sort(text);
            int count = 1;

            for (int i = 0; i < text.Length - 1; i++)
            {
                if (text[i] == text[i + 1])
                {
                    count++;
                    if (i + 1 == text.Length - 1)
                    {
                        Console.WriteLine($"{text[i + 1]} -> {count}");
                    }
                }
                else
                {
                    Console.WriteLine($"{text[i]} -> {count}");
                    count = 1;
                }
            }
        }
    }
}
