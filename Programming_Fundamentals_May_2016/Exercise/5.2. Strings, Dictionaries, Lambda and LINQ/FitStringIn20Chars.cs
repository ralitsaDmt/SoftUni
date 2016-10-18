using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Fit_String_in_Chars
{
    class FitStringIn20Chars
    {
        static void Main(string[] args)
        {
            string str = Console.ReadLine();

            PrintString(str);
        }

        private static void PrintString(string str)
        {
            if (str.Length < 20)
            {
                Console.WriteLine(str.PadRight(20, '*')); ;
            }
            else
            {
                Console.WriteLine(str.Substring(0, 20));
            }
        }
    }
}
