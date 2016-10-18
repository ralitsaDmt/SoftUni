using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Fit_Box_in_Box
{
    class FitBoxInBox
    {
        static void Main(string[] args)
        {
            int firstWidth = int.Parse(Console.ReadLine());
            int firstHeight = int.Parse(Console.ReadLine());
            int firstDepth = int.Parse(Console.ReadLine());

            int secondWidth = int.Parse(Console.ReadLine());
            int secondHeight = int.Parse(Console.ReadLine());
            int secondDepth = int.Parse(Console.ReadLine());

            int smallerWidth = 0;
            int smallerHeight = 0;
            int smallerDepth = 0;
            int biggerWidth = 0;
            int biggerHeight = 0;
            int biggerDepth = 0;

            if (firstDepth * firstHeight * firstWidth <= secondWidth * secondHeight * secondDepth)
            {
                smallerWidth = firstWidth;
                smallerHeight = firstHeight;
                smallerDepth = firstDepth;
                biggerDepth = secondDepth;
                biggerHeight = secondHeight;
                biggerWidth = secondWidth;
            }
            else
            {
                smallerWidth = secondWidth;
                smallerHeight = secondHeight;
                smallerDepth = secondDepth;
                biggerDepth = firstDepth;
                biggerHeight = firstHeight;
                biggerWidth = firstWidth;
            }
            
            if (canSmallerFit(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth))
            {
                PrintAnswer(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth);
            }

            // Rotate 1
            int tmp = biggerWidth;
            biggerWidth = biggerHeight;
            biggerHeight = tmp;
            if (canSmallerFit(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth))
            {
                PrintAnswer(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth);
            }
            //Rotate 2
            tmp = biggerWidth;
            biggerWidth = biggerDepth;
            biggerDepth = tmp;
            if (canSmallerFit(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth))
            {
                PrintAnswer(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth);
            }
            //Rotate 3
            tmp = biggerHeight;
            biggerHeight = biggerDepth;
            biggerDepth = tmp;
            if (canSmallerFit(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth))
            {
                PrintAnswer(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth);
            }
            //Rotate 4
            tmp = biggerHeight;
            biggerHeight = biggerWidth;
            biggerWidth = tmp;
            if (canSmallerFit(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth))
            {
                PrintAnswer(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth);
            }
            //Rotate 5
            tmp = biggerWidth;
            biggerWidth = biggerDepth;
            biggerDepth = tmp;
            if (canSmallerFit(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth))
            {
                PrintAnswer(smallerDepth, smallerHeight, smallerWidth, biggerDepth, biggerHeight, biggerWidth);
            }

        }

        private static void PrintAnswer(int smallerDepth, int smallerHeight, int smallerWidth, int biggerDepth, int biggerHeight, int biggerWidth)
        {
            Console.WriteLine($"({smallerWidth}, {smallerHeight}, {smallerDepth}) < ({biggerWidth}, {biggerHeight}, {biggerDepth})");
        }

        private static bool canSmallerFit(int smallerDepth, int smallerHeight, int smallerWidth, int biggerDepth, int biggerHeight, int biggerWidth)
        {
            if (smallerWidth < biggerWidth && smallerHeight < biggerHeight && smallerDepth < biggerDepth)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
