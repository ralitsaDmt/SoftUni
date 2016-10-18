using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Capitalization
{
    class Capitalization
    {
        static void Main(string[] args)
        {
            char[] delimiters = { ' ', '.', ',', '?', '!', ';' };
            string[] text = Console.ReadLine()
                .Split(delimiters, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            CapitalizeEachFirstCharacter(text);
        }

        private static void PrintModifiedText(string[] text)
        {
            Console.WriteLine(string.Join(" ", text));
        }

        private static void CapitalizeEachFirstCharacter(string[] text)
        {
            StringBuilder modifiedText = new StringBuilder();

            for (int i = 0; i < text.Length; i++)
            {
                modifiedText.Append(char.ToUpper(text[i][0]).ToString());
                modifiedText.Append(text[i].Substring(1));
                if (i != text.Length - 1)
                {
                    modifiedText.Append(' ');
                }
               
            }

            Console.WriteLine(modifiedText);
        }
    }
}
