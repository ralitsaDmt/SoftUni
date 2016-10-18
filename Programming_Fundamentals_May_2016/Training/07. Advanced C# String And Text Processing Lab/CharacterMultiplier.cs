using System;
using System.Linq;
using System.Text;

class CharacterMultiplier
{
    static void Main()
    {
        string[] input = Console.ReadLine()
            .Split();

        long sum = SumOfCharacters(input);

        Console.WriteLine(sum);
    }

    private static long SumOfCharacters(string[] input)
    {
        long sum = 0;

        string longer = string.Empty;
        string shorter = string.Empty;

        if (input[0].Length > input[1].Length)
        {
            longer = input[0];
            shorter = input[1];
        }
        else
        {
            longer = input[1];
            shorter = input[0];
        }

        for (int i = 0; i < shorter.Length; i++)
        {
            sum += (longer[i] * shorter[i]);
        }

        for (int i = longer.Length - 1; i >= shorter.Length; i--)
        {
            sum += longer[i];
        }

        return sum;
    }
}