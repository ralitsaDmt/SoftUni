using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Circles_Intersection
{
    class CirclesIntersection
    {
        class Circle
        {
            public int x { get; set; }
            public int y { get; set; }
            public int radius { get; set; }            
        }

        static void Main(string[] args)
        {
            Circle circle1 = ReadCircle();
            Circle circle2 = ReadCircle();

            if (Intersect(circle1, circle2))
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
        }

        private static bool Intersect(Circle circle1, Circle circle2)
        {
            double distance = DistanseBetweenCenters(circle1, circle2);

            if (distance <= circle1.radius + circle2.radius)
            {
                return true;
            }
            return false;
        }

        private static double DistanseBetweenCenters(Circle circle1, Circle circle2)
        {
            double distance = Math.Sqrt(
                Math.Pow(Math.Abs(circle2.x - circle1.x), 2) +
                Math.Pow(Math.Abs(circle2.y - circle1.y), 2));

            return distance;
        }

        private static Circle ReadCircle()
        {
            Circle c = new Circle();

            int[] elements = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            c.x = elements[0];
            c.y = elements[1];
            c.radius = elements[2];

            return c;
        }
    }
}
