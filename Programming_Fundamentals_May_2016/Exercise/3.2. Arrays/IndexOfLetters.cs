using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.Index_of_Letters
{
    class IndexOfLetters
    {
        static void Main(string[] args)
        {
            string word = Console.ReadLine().ToLower();

            char[] alphabet = new char[26];
            FillTheAlphabet(alphabet);

            PrintIndexes(word, alphabet);
        }

        private static void PrintIndexes(string word, char[] alphabet)
        {
            for (int i = 0; i < word.Length; i++)
            {
                for (int j = 0; j < alphabet.Length; j++)
                {
                    if (word[i] == alphabet[j])
                    {
                        Console.WriteLine($"{word[i]} -> {j}");
                        break;
                    }
                }
            }
        }

        private static void FillTheAlphabet(char[] alphabet)
        {
            char element = 'a';
            for (int i = 0; i < alphabet.Length; i++)
            {
                alphabet[i] = element;
                element++;
            }
        }
    }
}
