using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Palindromes
{
    class Palindromes
    {
        static void Main(string[] args)
        {   
            char[] delimiters = { ' ', ',', '.', '?', '!'};
            string[] text = Console.ReadLine()
                .Split(delimiters, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            List<string> palindormes = new List<string>();
            FindAllUniquePalindromes(text, palindormes);

            PrintResults(palindormes);
        }

        private static void PrintResults(List<string> palindormes)
        {
            palindormes.Sort();
            Console.WriteLine(string.Join(", ", palindormes));
        }

        private static void FindAllUniquePalindromes(string[] text, List<string> palindormes)
        {
            foreach (string word in text)
            {
                if ((WordIsPalindrome(word) && !palindormes.Contains(word)) ||
                    word.Length == 1)
                {
                    palindormes.Add(word);
                }
            }
        }

        private static bool WordIsPalindrome(string word)
        {
            bool isPalindrome = false;
            for (int i = 0; i < word.Length / 2; i++)
            {
                if (word[i] == word[word.Length - i - 1])
                {
                    isPalindrome = true;
                }
                else
                {
                    isPalindrome = false;
                    break;
                }
            }
            return isPalindrome;
        }
    }
}
