using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Closest_Two_Points
{
    class Point
    {
        public int x { get; set; }
        public int y { get; set; }
    }

    class ClosestTwoPoints
    {
        static void Main(string[] args)
        {
            Point[] points = ReadPoints();
            Point[] closestPoints = FindClosestPoints(points);
            PrintClosestPoints(closestPoints);
        }

        private static void PrintClosestPoints(Point[] closestPoints)
        {
            for (int i = 0; i < closestPoints.Length; i++)
            {
                Console.WriteLine($"({closestPoints[i].x}, {closestPoints[i].y})");
            }
        }

        private static Point[] FindClosestPoints(Point[] points)
        {
            double minDistance = double.MaxValue;
            Point[] closestPoints = new Point[2];

            for (int p1 = 0; p1 < points.Length; p1++)
            {
                for (int p2 = p1 + 1; p2 < points.Length; p2++)
                {
                    double distance = CalculateDistance(points[p1], points[p2]);
                    if (distance < minDistance)
                    {
                        minDistance = distance;
                        closestPoints[0] = points[p1];
                        closestPoints[1] = points[p2];
                    }
                }
            }

            Console.WriteLine($"{minDistance:f3}");
            return closestPoints;
        }

        private static double CalculateDistance(Point point1, Point point2)
        {
            double distance = Math.Sqrt(
                Math.Pow(Math.Abs(point2.x - point1.x), 2) +
                Math.Pow(Math.Abs(point2.y - point1.y), 2));

            return distance;
        }

        private static Point[] ReadPoints()
        {
            int n = int.Parse(Console.ReadLine());
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++)
            {
                points[i] = ReadPoint();
            }
            return points;
        }

        private static Point ReadPoint()
        {
            int[] coordinates = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            Point p = new Point();
            p.x = coordinates[0];
            p.y = coordinates[1];

            return p;
        }
    }
}
