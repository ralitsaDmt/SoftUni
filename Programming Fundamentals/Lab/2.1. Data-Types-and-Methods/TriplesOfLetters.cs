using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Triples_of_Letters
{
    class TriplesOfLetters
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < 3; i++)
            {
                for (int letter1 = 'a'; letter1 < 'a' + n; letter1++)
                {
                    for (int letter2 = 'a'; letter2 < 'a' + n; letter2++)
                    {
                        for (int letter3 = 'a'; letter3 < 'a' + n; letter3++)
                        {
                            Console.WriteLine("" + (char)letter1 + (char)letter2 + (char)letter3);
                        }
                    }
                }
            }
        }
    }
}
