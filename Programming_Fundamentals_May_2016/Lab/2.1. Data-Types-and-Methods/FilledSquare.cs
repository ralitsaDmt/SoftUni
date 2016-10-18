using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Filled_Square
{
    class FilledSquare
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            PrintTopBottom(n);
            PrintMiddleRows(n);
            PrintTopBottom(n);
        }

        private static void PrintMiddleRows(int size)
        {
            for (int i = 0; i < size - 2; i++)
            {
                Console.Write("-");
                for (int j = 0; j < size - 1; j++)
                {
                    Console.Write("\\/");
                }
                Console.WriteLine('-');
            }
        }

        private static void PrintTopBottom(int size)
        {
            Console.WriteLine(new string('-', size * 2));
        }
    }
}
