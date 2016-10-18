using System;
using System.Collections.Generic;
using System.Linq;

class Palindromes
{
    static void Main(string[] args)
    {
        char[] delimiters = { ' ', '.', ',', '?', '!', '(', ')', '[', ']', '/', '\\', '\'', ';' };
        string[] text = Console.ReadLine()
            .Split(delimiters, StringSplitOptions.RemoveEmptyEntries);

        List<string> palindromes = new List<string>();

        foreach (var word in text)
        {
            if (IsPalindrome(word) || word.Length == 1)
            {
                palindromes.Add(word);
            }
        }

        Console.WriteLine("[{0}]",
            string.Join(", ",
            palindromes.Distinct().OrderBy(t => t)));

    }

    private static bool IsPalindrome(string word)
    {
        bool areEqual = false;
        for (int i = 0; i < word.Length / 2; i++)
        {
            if (word[i] == word[word.Length - i - 1])
            {
                areEqual = true;
            }
            else
            {
                areEqual = false;
                break;
            }
        }
        return areEqual;
    }
}

