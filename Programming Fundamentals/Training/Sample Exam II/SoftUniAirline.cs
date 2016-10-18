using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.SoftUni_Airline
{
    class SoftUniAirline
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int countFlights = 0;
            decimal overallProfit = 0;
            decimal averageProfit = 0;

            for (int i = 0; i < n; i++)
            {
                long adultsCount = long.Parse(Console.ReadLine());
                decimal adultTicketPrice = decimal.Parse(Console.ReadLine());
                long youthCount = long.Parse(Console.ReadLine());
                decimal youthTicketPrice = decimal.Parse(Console.ReadLine());

                decimal fuelPricePerHour = decimal.Parse(Console.ReadLine());
                decimal fuelConsumptionPerHour = decimal.Parse(Console.ReadLine());
                int flightDuration = int.Parse(Console.ReadLine());
                                
                decimal income = (adultsCount * adultTicketPrice) + (youthCount * youthTicketPrice);
                decimal expences = (flightDuration * (fuelConsumptionPerHour * fuelPricePerHour));

                var profit = income - expences;
                if (profit >= 0)
                {
                    Console.WriteLine($"You are ahead with {profit:f3}$.");
                }
                else
                {
                    Console.WriteLine($"We've got to sell more tickets! We've lost {profit:f3}$.");
                }

                overallProfit += profit;
                countFlights++;
            }

            Console.WriteLine($"Overall profit -> {overallProfit:f3}$.");
            averageProfit = overallProfit / countFlights;
            Console.WriteLine($"Average profit -> {averageProfit:f3}$.");


        }
    }
}
