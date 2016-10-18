using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Command_Interpreter
{
    class CommandInterpreter
    {
        static void Main(string[] args)
        {
            List<string> collection = Console.ReadLine()
                .Split(new[] { ' '}, StringSplitOptions.RemoveEmptyEntries)
                .ToList();

            string command = Console.ReadLine();

            while (command != "end")
            {
                try
                {
                    ExecuteCommand(command.Split(), collection);
                }
                catch (ArgumentException)
                {
                    Console.WriteLine("Invalid input parameters.");
                }

                command = Console.ReadLine();
            }

            Console.WriteLine("[" + string.Join(", ", collection) + "]");
        }

        private static void ExecuteCommand(string[] command, List<string> collection)
        {
            switch (command[0])
            {
                case "reverse":
                    ExecuteReverse(command, collection); break;
                case "sort":
                    ExecuteSort(command, collection); break;
                case "rollLeft":
                    ExecuteRollLeft(command, collection); break;
                case "rollRight":
                    ExecuteRollRight(command, collection); break;
                default:
                    break;
            }
        }

        private static void ExecuteRollRight(string[] command, List<string> collection)
        {
            int numbersOfRolls = int.Parse(command[1]) % collection.Count;
            var elementsToMove = collection
                .Skip(collection.Count - numbersOfRolls)
                .Take(numbersOfRolls)
                .ToArray();

            collection.InsertRange(0, elementsToMove);
            collection.RemoveRange(collection.Count - numbersOfRolls, numbersOfRolls);
        }

        private static void ExecuteRollLeft(string[] command, List<string> collection)
        {
            int numberOfRolls = int.Parse(command[1]) % collection.Count;
            var elementsToMove = collection
                .Take(numberOfRolls)
                .ToArray();

            collection.AddRange(elementsToMove);
            collection.RemoveRange(0, numberOfRolls);
        }

        private static void ExecuteSort(string[] command, List<string> collection)
        {
            int start = int.Parse(command[2]);
            int count = int.Parse(command[4]);

            if (start == collection.Count)
            {
                throw new ArgumentException();
            }

            collection.Sort(start, count, StringComparer.InvariantCulture);
        }

        private static void ExecuteReverse(string[] command, List<string> collection)
        {
            int start = int.Parse(command[2]);
            int count = int.Parse(command[4]);

            if (start == collection.Count)
            {
                throw new ArgumentException();
            }

            collection.Reverse(start, count);
        }
    }
}
