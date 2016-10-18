using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _20.Name_Of_Last_Digit
{
    class NameOfLastDigit
    {
        static void Main(string[] args)
        {
            long number = long.Parse(Console.ReadLine());

            int lastDigit = (int)(Math.Abs(number % 10));
            string name = FindLastDigit(lastDigit);
            

            Console.WriteLine(name);
        }

        private static string FindLastDigit(long number)
        {
            string name = string.Empty;
            switch (number)
            {
                case 0: name = "zero"; break;
                case 1: name = "one"; break;
                case 2: name = "two"; break;
                case 3: name = "three"; break;
                case 4: name = "four"; break;
                case 5: name = "five"; break;
                case 6: name = "six"; break;
                case 7: name = "seven"; break;
                case 8: name = "eight"; break;
                case 9: name = "nine"; break;
            }
            return name;
        }
    }
}
