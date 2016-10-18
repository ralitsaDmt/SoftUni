using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Unicode_Characters
{
    class UnicodeCharacters
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();

            StringBuilder unicodeCaharacters = new StringBuilder();

            foreach (var symbol in text)
            {
                unicodeCaharacters.Append("\\u");
                unicodeCaharacters.Append(((int)symbol).ToString("X4").ToLower());
            }

            Console.WriteLine(unicodeCaharacters);
        }
    }
}
