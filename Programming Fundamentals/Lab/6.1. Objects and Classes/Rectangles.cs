using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _002.Rectangles
{
    class Rectangles
    {
        static void Main(string[] args)
        {
            var r1 = Rectangle.ReadRectangle();
            var r2 = Rectangle.ReadRectangle();

            Console.WriteLine(Rectangle.IsRect1IsInsideR2(r1, r2) ? "Inside" : "Not inside");
        }

        class Rectangle
        {
            public double Top { get; set; }
            public double Left { get; set; }
            public double Width { get; set; }
            public double Heigth { get; set; }

            public double Bottom
            {
                get
                {
                    return this.Top + this.Width;
                }
            }

            public double Right
            {
                get
                {
                    return this.Left + this.Heigth;
                }
            }

            public static Rectangle ReadRectangle()
            {
                var tokens = Console.ReadLine().Split().Select(double.Parse).ToArray();
                var rect = new Rectangle()
                {
                    Top = tokens[0],
                    Left = tokens[1],
                    Width = tokens[2],
                    Heigth = tokens[3]
                };
                return rect;
            }

            public static bool IsRect1IsInsideR2(Rectangle r1, Rectangle r2)
            {
                var inside = r1.Left >= r2.Left &&
                    r1.Right <= r2.Right &&
                    r1.Top >= r2.Top &&
                    r1.Bottom <= r2.Bottom;
                return inside;
            }

            public override string ToString()
            {
                return String.Format("");
            }
        }
    }
}
