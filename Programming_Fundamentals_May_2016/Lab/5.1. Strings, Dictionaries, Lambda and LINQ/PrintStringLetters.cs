using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Print_String_Letters
{
    class PrintStringLetters
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();

            for (int i = 0; i < text.Length; i++)
            {
                Console.WriteLine($"str[{i}] -> '{text[i]}'");
            }


            //string sentence = "welcome to softuni!";
            //char[] sentenceArray = sentence.ToCharArray();
            //sentenceArray[sentenceArray.Length - 1] = '.';
            //Console.WriteLine(string.Join("", sentenceArray));
            //Console.WriteLine(sentenceArray);
            //Console.WriteLine(sentenceArray.ToString());
        }
    }
}
