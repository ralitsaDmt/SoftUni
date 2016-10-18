using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Distance_between_Points
{
    class Point
    {
        public int x { get; set; }
        public int y { get; set; }
    }

    class DistanceBetweenPoints
    {
        static void Main(string[] args)
        {
            Point point1 = new Point();
            Point point2 = new Point();

            int[] point1Coordinates = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();
            point1.x = point1Coordinates[0];
            point1.y = point1Coordinates[1];

            int[] point2Coordinates = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();
            point2.x = point2Coordinates[0];
            point2.y = point2Coordinates[1];

            double distance = CalculateDistance(point1, point2);
            Console.WriteLine("{0:f3}", distance);
        }

        private static double CalculateDistance(Point point1, Point point2)
        {
            double distance = Math.Sqrt(
                Math.Pow(Math.Abs(point2.x - point1.x), 2) +
                Math.Pow(Math.Abs(point2.y - point1.y), 2));

            return distance;
        }
    }
}
