using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Forbidden_Substrings
{
    class ForbiddenSubstrings
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            string[] forbiddenWords = Console.ReadLine().Split().ToArray();

            foreach (var forbiddenWord in forbiddenWords)
            {
                text = text.Replace(forbiddenWord, new string('*', forbiddenWord.Length));
            }
            Console.WriteLine(text);

        }
    }
}
