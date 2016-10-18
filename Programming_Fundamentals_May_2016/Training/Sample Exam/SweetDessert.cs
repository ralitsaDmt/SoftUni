using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Sweet_Dessert
{
    class SweetDessert
    {
        static void Main(string[] args)
        {
            decimal cash = decimal.Parse(Console.ReadLine());
            long guests = long.Parse(Console.ReadLine());
            decimal bananaPrice = decimal.Parse(Console.ReadLine());
            decimal eggsPrice = decimal.Parse(Console.ReadLine());
            decimal berriesPrice = decimal.Parse(Console.ReadLine());

            long portions = 0;
            if (guests % 6 == 0)
            {
                portions = guests / 6;
            }
            else
            {
                portions = guests / 6 + 1;
            }

            decimal cost = portions * (2 * bananaPrice + 4 * eggsPrice + 0.2m * berriesPrice);

            if (cost <= cash)
            {
                Console.WriteLine($"Ivancho has enough money - it will cost {cost:f2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {(cost - cash):f2}lv more.");
            }
        }
    }
}
