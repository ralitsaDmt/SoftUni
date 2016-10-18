using System;
using System.Linq;
using System.Text;

class ReverseString
{
    static void Main(string[] args)
    {
        StringBuilder reverseText = new StringBuilder();
        string text = Console.ReadLine();

        for (int i = text.Length - 1; i >= 0; i--)
        {
            reverseText.Append(text[i]);
        }
        Console.WriteLine(reverseText);
    }
}