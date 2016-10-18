using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Dress_Pattern
{
    class DressPattern
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            //first line - static
            int leftRight = 4 * n;
            int mid = 4 * n;
            Console.WriteLine("{0}.{1}.{0}", 
                new string('_', leftRight),
                new string('_', mid));

            //second n * 2 lines
            leftRight -= 2;
            mid -= 2;
            int inner = 2;
            for (int i = 0; i < n * 2; i++)
            {
                Console.WriteLine("{0}.{1}.{2}.{1}.{0}",
                    new string('_', leftRight),
                    new string('*', inner),
                    new string('_', mid));
                leftRight -= 2;
                mid -= 2;
                inner += 3;
            }

            //third n lines
            inner = 12 * n;
            for (int i = 0; i < n; i++)
            {
                Console.WriteLine(".{0}.",
                    new string('*', inner));
            }

            //forth line - static
            leftRight = 3 * n;
            inner = 6 * n + 2;
            Console.WriteLine("{0}{1}{0}",
                new string('.', leftRight),
                new string('*', inner));

            //fifth n lines
            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("{0}{1}{0}",
                    new string('_', leftRight),
                    new string('o', inner));
            }

            //sixth n * 2 lines
            inner -= 2;
            for (int i = 0; i < n * 3; i++)
            {
                Console.WriteLine("{0}.{1}.{0}",
                    new string('_', leftRight),
                    new string('*', inner));
                leftRight--;
                inner += 2;
            }

            //seveth line - static
            Console.WriteLine(new string('.', 12 * n + 2));
        }
    }
}
