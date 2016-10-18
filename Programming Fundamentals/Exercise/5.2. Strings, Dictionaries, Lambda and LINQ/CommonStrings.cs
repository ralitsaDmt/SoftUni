using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.Common_Strings
{
    class CommonStrings
    {
        static void Main(string[] args)
        {
            string firstString = Console.ReadLine();
            string secondString = Console.ReadLine();

            FindComonnSubstring(firstString, secondString);
        }

        private static void FindComonnSubstring(string firstString, string secondString)
        {
            foreach (char letter in firstString)
            {
                if (secondString.IndexOf(letter.ToString()) > 0)
                {
                    Console.WriteLine("yes");
                    return;
                }
            }
            Console.WriteLine("no");
        }
    }
}
