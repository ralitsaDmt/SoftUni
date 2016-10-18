using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Vehicle_Park
{
    class VehiclePark
    {
        static void Main(string[] args)
        {
            List<string> park = Console.ReadLine().Split().ToList();

            uint sold = 0;
            string input = Console.ReadLine();

            while (input != "End of customers!")
            {
                string[] request = input.ToLower().Split();
                char requestType = request[0][0];
                uint requestSeats = uint.Parse(request[2]);

                bool foundVehicle = false;
                for (int i = 0; i < park.Count; i++)
                {
                    uint availableSeats = uint.Parse(park[i].Substring(1));
                    if (requestType == park[i][0] && requestSeats == availableSeats)
                    {
                        sold++;
                        decimal price = requestType * (decimal)requestSeats;
                        Console.WriteLine($"Yes, sold for {price}$");
                        park.Remove(park[i]);
                        foundVehicle = true;
                        break;
                    }
                }
                if (!foundVehicle)
                {
                    Console.WriteLine("No");
                }
                input = Console.ReadLine();
            }
            
            Console.WriteLine("Vehicles left: " + string.Join(", ", park));

            Console.WriteLine($"Vehicles sold: {sold}");

        }
    }
}
