using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Array_Manipulator
{
    class ArrayManipulator
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToList();
            string input = Console.ReadLine();

            while (!input.Contains("print"))
            {
                if (input.Contains("add"))
                {
                    AddMany(input, ref numbers);
                }
                else if (input.Contains("contains"))
                {
                    Contains(ref numbers, input);
                }
                else if (input.Contains("shift"))
                {
                    Shift(ref numbers, input);
                }
                else if (input.Contains("remove"))
                {
                    remove(ref numbers, input);
                }
                else if (input.Contains("sumPairs"))
                {
                    SumPairs(ref numbers);
                }

                input = Console.ReadLine();
            }

            Console.WriteLine($"[{string.Join(", ", numbers)}]");
        }

        private static void SumPairs(ref List<int> numbers)
        {
            int pairs = numbers.Count / 2;
            for (int i = 0; i < pairs; i++)
            {
                numbers[i] += numbers[i + 1];
                numbers.RemoveAt(i + 1);
            }
        }

        private static void remove(ref List<int> numbers, string input)
        {
            int[] arguments = SplitContent(input);
            numbers.RemoveAt(arguments[0]);
        }

        private static void Shift(ref List<int> numbers, string input)
        {
            int[] arguments = SplitContent(input);
            int position = arguments[0] % numbers.Count;

            for (int i = 0; i < position; i++)
            {
                numbers.Add(numbers[0]);
                numbers.RemoveAt(0);
            }            
        }

        private static void Contains(ref List<int> numbers, string input)
        {
            int[] arguments = SplitContent(input);
            Console.WriteLine(numbers.IndexOf(arguments[0]));
        }

        private static void AddMany(string input, ref List<int> numbers)
        {
            int[] arguments = SplitContent(input);
            
            numbers.InsertRange(arguments[0], arguments);
            numbers.RemoveAt(arguments[0]);
        }

        private static int[] SplitContent(string input)
        {
            string[] args = input.Split();
            int[] arguments = new int[args.Length - 1];
            for (int i = 1; i < args.Length; i++)
            {
                arguments[i - 1] = int.Parse(args[i]);
            }
            
            return arguments;
        }
        
        


    }
}
