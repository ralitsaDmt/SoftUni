using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21.Numbers_In_reversed_Order
{
    class NumbersInReversedOrder
    {
        static void Main(string[] args)
        {
            string number = Console.ReadLine();
            Stack<char> reverseNum = new Stack<char>();

            FillDigitsInreverse(number, reverseNum);

            
            Console.WriteLine(string.Join("", reverseNum));

        }

        private static void FillDigitsInreverse(string number, Stack<char> reverseNum)
        {
            for (int i = 0; i < number.Length; i++)
            {
                reverseNum.Push(number[i]);
            }

        }
    }
}
