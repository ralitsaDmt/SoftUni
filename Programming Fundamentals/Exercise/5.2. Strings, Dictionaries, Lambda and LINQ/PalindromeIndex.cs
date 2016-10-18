using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Palindrome_Index
{
    class PalindromeIndex
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();

            if (IsPalindrome(text) || text.Length == 1)
            {
                Console.WriteLine(-1);
            }
            else
            {
                FindIndexToMakePalindrome(text);
            }
        }

        private static void FindIndexToMakePalindrome(string text)
        {
            StringBuilder modifiedText = new StringBuilder();
            for (int i = 0; i < text.Length; i++)
            {
                modifiedText.Append(text.Substring(0, i));
                modifiedText.Append(text.Substring(i + 1));

                if (IsPalindrome(modifiedText.ToString()))
                {
                    Console.WriteLine(i);
                    return;
                }
                modifiedText.Clear();
            }
        }

        private static bool IsPalindrome(string text)
        {
            for (int i = 0; i < text.Length / 2; i++)
            {
                if (text[i] == text[text.Length -i - 1])
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
    }
}
