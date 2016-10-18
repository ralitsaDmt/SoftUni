using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Array_Modifier
{
    class ArrayModifier
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            string command = Console.ReadLine();

            while (command.ToLower() != "end")
            {
                if (command.Contains("swap"))
                {
                    SwapNumbers(arr, command);
                }
                else if (command.Contains("multiply"))
                {
                    MultiplyNumber(arr, command);
                }
                else if (command.Contains("decrease"))
                {
                    DecreaseAllNumbers(arr);
                }

                command = Console.ReadLine();
            }

            Console.WriteLine(string.Join(", ", arr));
        }

        private static void DecreaseAllNumbers(int[] arr)
        {
            for (int i = 0; i < arr.Length; i++)
            {
                arr[i]--;
            }
        }

        private static void MultiplyNumber(int[] arr, string command)
        {
            string[] input = command.Split();
            int index1 = int.Parse(input[1]);
            int index2 = int.Parse(input[2]);

            arr[index1] = arr[index1] * arr[index2];
        }

        private static void SwapNumbers(int[] arr, string command)
        {
            string[] input = command.Split();
            int index1 = int.Parse(input[1]);
            int index2 = int.Parse(input[2]);

            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}
