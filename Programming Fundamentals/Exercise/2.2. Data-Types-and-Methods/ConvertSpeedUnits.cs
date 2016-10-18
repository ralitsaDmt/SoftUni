using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.Convert_Speed_Units
{
    class ConvertSpeedUnits
    {
        static void Main(string[] args)
        {
            int meters = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            int seconds = int.Parse(Console.ReadLine());

            float metersPerSecond = meters / (hours * 3600f + minutes * 60f + seconds);
            float kmPerHour = (meters / 1000f) / (hours + minutes / 60f + seconds / 3600f);
            float milesPerHour = (meters / 1609f) / (hours + minutes / 60f+ seconds / 3600f);

            Console.WriteLine($"{metersPerSecond}\n{kmPerHour}\n{milesPerHour}");
        }
    }
}
