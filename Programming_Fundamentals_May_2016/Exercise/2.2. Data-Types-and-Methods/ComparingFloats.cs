using System;
using System.Numerics;


namespace _15.Comparing_floats
{
    class ComparingFloats
    {
        static void Main(string[] args)
        {
            const float Eps = 0.000001f;
            double num1 = double.Parse(Console.ReadLine());
            double num2 = double.Parse(Console.ReadLine());
            bool areEqual = false;
            if (Math.Abs(num1 - num2) <= Eps)
            {
                areEqual = true;
            }

            Console.WriteLine(areEqual);
        }
    }
}
