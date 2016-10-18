using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Reverse_Sentence
{
    class ReverseWordsInSentence
    {
        static void Main(string[] args)
        {
            string sentence = Console.ReadLine();

            char[] delimiters = { ',', '.', ':', ';', '=', '(', ')', '&', '[', ']', '"', '\'', '\\', '/', '!', '?', ' '};
            string[] splitSentence = sentence
                .Split(delimiters, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            char[] wordsSeparators = string.Join("", splitSentence).ToCharArray();

            string[] separators = sentence
                .Split(wordsSeparators, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            int wordsIndex = splitSentence.Length - 1;
            for (int i = 0; i < splitSentence.Length; i++)
            {
                Console.Write(splitSentence[wordsIndex]);
                Console.Write(separators[i]);
                wordsIndex--;
            }
            Console.WriteLine();

        }
    }
}
