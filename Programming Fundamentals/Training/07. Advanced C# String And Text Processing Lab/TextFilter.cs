using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Text_Filter
{
    class TextFilter
    {
        static void Main(string[] args)
        {
            string[] bannedWords = Console.ReadLine()
                .Split(new char[] { ' ', ','}, 
                StringSplitOptions.RemoveEmptyEntries);

            string text = Console.ReadLine();
                        
            foreach (var word in bannedWords)
            {
                int offset = -1;
                for (int i = 0; i < text.Length; i++)
                {
                    offset = text.IndexOf(word, offset + 1);
                    if (offset >= 0)
                    {
                        text = text.Replace(word, new string('*', word.Length));
                    }
                    else
                    {
                        break;
                    }
                }
            }

            Console.WriteLine(text);
        }
    }
}
