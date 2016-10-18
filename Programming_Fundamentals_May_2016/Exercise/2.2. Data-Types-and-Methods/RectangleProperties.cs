using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Rectangle_Properties
{
    class RectangleProperties
    {
        static void Main(string[] args)
        {
            double width = double.Parse(Console.ReadLine());
            double heigth = double.Parse(Console.ReadLine());

            Console.WriteLine(2 * width + 2 * heigth);
            Console.WriteLine(width * heigth);
            Console.WriteLine(Math.Sqrt(Math.Pow(width, 2) + Math.Pow(heigth, 2)));
        }
    }
}
