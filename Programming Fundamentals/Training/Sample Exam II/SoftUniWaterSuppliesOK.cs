using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.SoftUni_Water_Supplies_OK
{
    class SoftUniWaterSuppliesOK
    {
        static void Main(string[] args)
        {
            double totalAmountWater = double.Parse(Console.ReadLine());
            double[] bottles = Console.ReadLine()
                .Split()
                .Select(double.Parse)
                .ToArray();
            double capacity = double.Parse(Console.ReadLine());

            double waterInBottles = CalcWaterInBottles(bottles);
            double waterNeeded = bottles.Length * capacity;

            if (waterNeeded <= totalAmountWater)
            {
                Console.WriteLine("Enough water!");
                double leftWater = totalAmountWater - (waterNeeded - waterInBottles);
                Console.WriteLine($"Water left: {leftWater}l.");
            }
            else
            {
                Console.WriteLine("We need more water!");
                FindNeededWater(totalAmountWater, bottles, capacity);
            }
        }

        private static void FindNeededWater(double totalAmountWater, double[] bottles, double capacity)
        {
            int fillIndex = 0;
            double waterLeft = totalAmountWater;
            if (totalAmountWater % 2 == 0)
            {
                for (int i = 0; i < bottles.Length; i++)
                {
                    waterLeft -= (capacity - bottles[i]);
                    if (waterLeft < 0)
                    {
                        fillIndex = i;
                        break;
                    }
                }

                int bottlesLeft = bottles.Length - fillIndex;
                List<int> indexes = new List<int>();
                for (int i = fillIndex; i < bottles.Length; i++)
                {
                    indexes.Add(i);
                }

                double totalWaterInBottles = CalcWaterInBottles(bottles);
                double waterNeeded = bottles.Length * capacity - totalWaterInBottles - totalAmountWater;

                PrintResults(bottlesLeft, indexes, waterNeeded);
            }
            else
            {
                for (int i = bottles.Length - 1; i >= 0; i--)
                {
                    waterLeft -= (capacity - bottles[i]);
                    if (waterLeft < 0)
                    {
                        fillIndex = i;
                        break;
                    }
                }

                int bottlesLeft = fillIndex + 1;
                List<int> indexes = new List<int>();
                for (int i = fillIndex; i >= 0; i--)
                {
                    indexes.Add(i);
                }

                double totalWaterInBottles = CalcWaterInBottles(bottles);
                double waterNeeded = bottles.Length * capacity - totalWaterInBottles - totalAmountWater;

                PrintResults(bottlesLeft, indexes, waterNeeded);
            }

        }

        private static void PrintResults(int bottlesLeft, List<int> indexes, double waterNeeded)
        {
            Console.WriteLine($"Bottles left: {bottlesLeft}");
            Console.WriteLine($"With indexes: {string.Join(", ", indexes)}");
            Console.WriteLine($"We need {waterNeeded} more liters!");
        }

        private static double CalcWaterInBottles(double[] bottles)
        {
            double waterInBottles = 0;
            for (int i = 0; i < bottles.Length; i++)
            {
                waterInBottles += bottles[i];
            }
            return waterInBottles;
        }
    }
}
