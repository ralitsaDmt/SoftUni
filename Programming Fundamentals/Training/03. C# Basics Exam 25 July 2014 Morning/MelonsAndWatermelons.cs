using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Melons_and_Watermelons
{
    class MelonsAndWatermelons
    {
        static void Main(string[] args)
        {
            int startingDay = int.Parse(Console.ReadLine());
            int sequentialDays = int.Parse(Console.ReadLine());

            int melonCount = 0;
            int waterMelonCount = 0;

            int day = startingDay;
            for (int i = 0; i < sequentialDays; i++)
            {
                switch (day % 7)
                {
                    case 1: waterMelonCount++; break;
                    case 2: melonCount += 2; break;
                    case 3: waterMelonCount++;
                        melonCount++; break;
                    case 4: waterMelonCount += 2; break;
                    case 5: waterMelonCount += 2;
                        melonCount += 2; break;
                    case 6: waterMelonCount++;
                        melonCount += 2; break;
                }
                day++;
            }

            if (waterMelonCount > melonCount)
            {
                Console.WriteLine($"{waterMelonCount - melonCount} more watermelons");
            }
            else if (waterMelonCount < melonCount)
            {
                Console.WriteLine($"{melonCount - waterMelonCount} more melons");
            }
            else
            {
                Console.WriteLine($"Equal amount: {melonCount}");
            }
        }
    }
}
