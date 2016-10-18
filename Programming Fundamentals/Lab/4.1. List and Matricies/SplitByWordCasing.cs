using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Split_by_Word_Casing
{
    class SplitByWordCasing
    {
        static void Main(string[] args)
        {
            char[] separator = { ',', ';', ':', '.', '!', '(', ')', '"', '\'', '\\', '/',  '[', ']', ' '};

            string[] words = Console.ReadLine()
                .Split(separator, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            List<string> lowerCaseWords = new List<string>();
            List<string> upperCaseWords = new List<string>();
            List<string> mixedCaseWords = new List<string>();

            foreach (string word in words)
            {
                bool containsUpper = false;
                bool containsLower = false;
                bool containsSymbol = false;
                for (int i = 0; i < word.Length; i++)
                {
                    if (word[i] >= 65 && word[i] <= 90 )
                    {
                        containsUpper = true;
                    }
                    else if (word[i] >= 97 && word[i] <= 122)
                    {
                        containsLower = true;
                    }
                    else
                    {
                        containsSymbol = true;
                    }
                }

                if (containsLower && containsUpper || containsLower && containsSymbol || containsUpper && containsSymbol || containsSymbol)
                {
                    mixedCaseWords.Add(word);
                }
                else if (containsLower)
                {
                    lowerCaseWords.Add(word);
                }
                else if (containsUpper)
                {
                    upperCaseWords.Add(word);
                }
            }

            Console.WriteLine("Lower-case: " + string.Join(", ", lowerCaseWords));
            Console.WriteLine("Mixed-case: " + string.Join(", ", mixedCaseWords));
            Console.WriteLine("Upper-case: " + string.Join(", ", upperCaseWords));
        }

        
    }
}
