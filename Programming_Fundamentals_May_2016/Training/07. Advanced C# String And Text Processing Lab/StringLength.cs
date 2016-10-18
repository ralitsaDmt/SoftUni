using System;

class StringLength
{
    static void Main(string[] args)
    {
        string text = Console.ReadLine();
        char pad = '*';
        Console.WriteLine(text.PadRight(20, pad));
    }
}