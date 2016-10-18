using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Reverse_String
{
    class ReverseString
    {
        static void Main(string[] args)
        {
            string word = Console.ReadLine();
            PrintReverse(word);

            //char[] word = Console.ReadLine()
            //    .ToCharArray();

            //PrintWordInReverse(word);
        }

        // fastest method
        private static void PrintReverse(string word)
        {
            for (int i = word.Length - 1; i >= 0; i--)
            {
                Console.Write(word[i]);
            }
            Console.WriteLine();
        }

        private static void PrintWordInReverse(char[] word)
        {
            // slowest method
            //Console.WriteLine(string.Join("", word.Reverse()));

            //for (int i = word.Length - 1; i >= 0; i--)
            //{
            //    Console.Write(word[i]);
            //}
            //Console.WriteLine();
        }
    }
}
