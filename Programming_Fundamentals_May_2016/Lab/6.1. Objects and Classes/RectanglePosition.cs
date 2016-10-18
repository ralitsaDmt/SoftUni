using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.Rectangle_Position
{

    class Rectangle
    {
        public long Top { get; set; }
        public long Left { get; set; }
        public long Width { get; set; }
        public long Heigth { get; set; }

        public long Bottom
        {
            get
            {
                return Top + Width;
            }
        }
        public long Right
        {
            get
            {
                return Left + Heigth;
            }
        }

        public bool IsInside(Rectangle r)
        {
            return (r.Top <= Top &&
                r.Bottom >= Bottom &&
                r.Left <= Left &&
                r.Right >= Right);
        }
    }
    class RectanglePosition
    {
        static void Main(string[] args)
        {
            Rectangle rect1 = ReadRectangle();
            Rectangle rect2 = ReadRectangle();            

            Console.WriteLine(rect1.IsInside(rect2) ? "Inside" : "Not inside");
        }

        private static Rectangle ReadRectangle()
        {
            Rectangle r = new Rectangle();

            long[] coordinates = Console.ReadLine()
                .Split(' ')
                .Select(long.Parse)
                .ToArray();

            r.Top = coordinates[0];
            r.Left = coordinates[1];
            r.Width = coordinates[2];
            r.Heigth = coordinates[3];

            return r;
        }
    }
}
