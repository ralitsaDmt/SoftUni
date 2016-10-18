using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Reversed_chars
{
    class ReversedChars
    {
        static void Main(string[] args)
        {
            Stack<char> letters = new Stack<char>();
            for (int i = 0; i < 3; i++)
            {
                letters.Push(char.Parse(Console.ReadLine()));
            }
            for (int i = 0; i < 3; i++)
            {
                Console.Write(letters.Pop());
            }
            Console.WriteLine();
        }
    }
}
