using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Reverse_Array_of_Strings
{
    class ReverseArrayOfStrings
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine().Split();

            ArrayReverse(array);
            Console.WriteLine(String.Join(" ", array));
        }

        private static void ArrayReverse(string[] array)
        {
            Swap(array);
        }

        private static void Swap(string[] array)
        {
            for (int i = 0; i < array.Length / 2; i++)
            {
                string tmp = array[i];
                array[i] = array[array.Length - 1 - i];
                array[array.Length - 1 - i] = tmp;
            }
        }
    }
}
