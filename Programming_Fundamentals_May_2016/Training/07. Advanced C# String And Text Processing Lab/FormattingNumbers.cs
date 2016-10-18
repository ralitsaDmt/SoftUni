using System;
using System.Linq;

class FormattingNumbers
{
    static void Main(string[] args)
    {
        string[] numbers = Console.ReadLine().Split().ToArray();
        uint num1 = uint.Parse(numbers[0]);
        double num2 = double.Parse(numbers[1]);
        double num3 = double.Parse(numbers[2]);

        Console.WriteLine("|{0, -10}|{1}|{2,10:f2}|{3,-10:f3}|", 
            num1.ToString("X"),
            Convert.ToString(num1, 2).PadLeft(10, '0'),
            num2, num3);        
    }
}

