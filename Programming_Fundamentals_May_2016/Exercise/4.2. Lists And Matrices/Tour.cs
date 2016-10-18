using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.Tour
{
    class Tour
    {
        static void Main(string[] args)
        {
            int size = int.Parse(Console.ReadLine());
            int[][] cities = new int[size][];
            FillCities(cities);

            List<int> tour = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToList();
            tour.Insert(0, 0);

            int distance = FindDistanceOnTour(cities, tour);
            Console.WriteLine(distance);
        }

        private static int FindDistanceOnTour(int[][] cities, List<int> tour)
        {
            int distance = 0;
            for (int i = 0; i < tour.Count - 1; i++)
            {
                distance += cities[tour[i]][tour[i + 1]];
            }

            return distance;
        }

        private static void FillCities(int[][] cities)
        {
            for (int row = 0; row < cities.GetLength(0); row++)
            {
                cities[row] = Console.ReadLine()
                    .Split()
                    .Select(int.Parse)
                    .ToArray();
            }
        }
    }
}
