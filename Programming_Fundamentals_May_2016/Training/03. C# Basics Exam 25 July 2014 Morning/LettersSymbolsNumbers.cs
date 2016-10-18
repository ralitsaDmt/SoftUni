using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Letters__Symbols__Numbers
{
    class LettersSymbolsNumbers
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int letters = 0;
            int numbers = 0;
            int symbols = 0;
            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();

                for (int pos = 0; pos < input.Length; pos++)
                {
                    if (input[pos] >= 'A' &&
                        input[pos] <= 'Z' )
                    {
                        letters += (input[pos] - 64) * 10;
                    }
                    else if (input[pos] >= 'a' &&
                            input[pos] <= 'z')
                    {
                        letters += (input[pos] - 96) * 10;
                    }
                    else if (input[pos] >= '0' && input[pos] <= '9')
                    {
                        numbers += (input[pos] - 48) * 20;
                    }
                    else if (input[pos] != ' ' &&
                             input[pos] != '\t' &&
                             input[pos] != '\r' &&
                             input[pos] != '\n')
                    {
                        symbols += 200;
                    }
                }
            }

            Console.WriteLine(letters);
            Console.WriteLine(numbers);
            Console.WriteLine(symbols);
        }
    }
}
