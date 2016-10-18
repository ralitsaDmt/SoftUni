using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Nakovs_Matching
{
    class NakovsMatching
    {
        static void Main(string[] args)
        {
            string firstString = Console.ReadLine();
            string secondString = Console.ReadLine();
            long limitNumber = long.Parse(Console.ReadLine());

            List<string> firstLeft = new List<string>();
            List<string> firstRight = new List<string>();
            List<string> secondLeft = new List<string>();
            List<string> secondRight = new List<string>();

            bool foundMatch = false;

            for (int i = 1; i < firstString.Length; i++)
            {
                firstLeft.Add(firstString.Substring(0, i));
                firstRight.Add(firstString.Substring(i));
            }

            for (int i = 1; i < secondString.Length; i++)
            {
                secondLeft.Add(secondString.Substring(0, i));
                secondRight.Add(secondString.Substring(i));
            }

            for (int i = 0; i < firstLeft.Count; i++)
            {
                for (int j = 0; j < secondLeft.Count; j++)
                {
                    long distance = Math.Abs(Calculate(firstLeft[i]) * Calculate(secondRight[j]) - Calculate(firstRight[i]) * Calculate(secondLeft[j]));

                    if (distance <= limitNumber)
                    {
                        foundMatch = true;
                        Console.WriteLine($"({firstLeft[i]}|{firstRight[i]}) matches ({secondLeft[j]}|{secondRight[j]}) by {distance} nakovs");
                    }
                }
            }

            if (!foundMatch)
            {
                Console.WriteLine("No");
            }
        }      

        private static long Calculate(string v)
        {
            long sum = 0;
            for (int i = 0; i < v.Length; i++)
            {
                sum += v[i];
            }
            return sum;
        } 
    }
}
