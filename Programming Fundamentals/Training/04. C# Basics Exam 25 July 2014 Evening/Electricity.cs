using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Electricity
{
    class Electricity
    {
        static void Main(string[] args)
        {
            int floors = int.Parse(Console.ReadLine());
            int flats = int.Parse(Console.ReadLine());

            DateTime time = DateTime.Parse(Console.ReadLine());
            double watts = 0;

            int consumption = 0;
            if (time.Hour >= 14 && time.Hour <= 18)
            {
                watts = (2 * 100.53) + (2 * 125.90);
                consumption = (int)(floors * flats * watts);
            }
            else if (time.Hour >= 19 && time.Hour <= 23)
            {
                watts = (7 * 100.53) + (6 * 125.90);
                consumption = (int)(floors * flats * watts);
            }
            else if (time.Hour >= 0 && time.Hour <= 8)
            {
                watts = (1 * 100.53) + (8 * 125.90);
                consumption = (int)(floors * flats * watts);
            }
            else
            {
                consumption = 0;
            }

            Console.WriteLine($"{consumption} Watts");
        }
    }
}
