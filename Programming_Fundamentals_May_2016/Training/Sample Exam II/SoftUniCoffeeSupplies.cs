using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.SoftUni_Coffee_Supplies
{
    class SoftUniCoffeeSupplies
    {
        static void Main(string[] args)
        {
            string[] delimiters = Console.ReadLine().Split();
            string firstDelimiter = delimiters[0];
            string secondDelimiter = delimiters[1];

            SortedDictionary<string, string> personCoffeeType = new SortedDictionary<string, string>();
            SortedDictionary<string, long> coffeeTypeQuantity = new SortedDictionary<string, long>();

            // Read data
            ReadInfo(firstDelimiter, secondDelimiter, personCoffeeType, coffeeTypeQuantity);

            // Check if you have to order coffee
            CheckCoffee(coffeeTypeQuantity);

            // Take orders
            weekOrders(personCoffeeType, coffeeTypeQuantity);

            // Print reports
            printReport(coffeeTypeQuantity, personCoffeeType);
        }

        private static void CheckCoffee(SortedDictionary<string, long> coffeeTypeQuantity)
        {
            foreach (var type in coffeeTypeQuantity)
            {
                if (type.Value == 0)
                {
                    Console.WriteLine($"Out of {type.Key}");
                }
            }
        }

        private static void printReport(SortedDictionary<string, long> coffeeTypeQuantity, SortedDictionary<string, string> personCoffeeType)
        {
            // Print coffee to order
            foreach (var item in personCoffeeType)
            {
                if (!coffeeTypeQuantity.ContainsKey(item.Value) ||
                    coffeeTypeQuantity[item.Key] <= 0)
                {
                    Console.WriteLine("Out of {0}", item.Key);
                }
            }

            // Print coffee left            
            Console.WriteLine("Coffee Left:");

            var coffeeLeft = coffeeTypeQuantity
                .Where(c => c.Value > 0)
                .OrderByDescending(c => c.Value);

            foreach (var coffee in coffeeLeft)
            {
                Console.WriteLine($"{coffee.Key} {coffee.Value}");
            }

            // Who has coffee left
            Console.WriteLine("For:");

            var sorted = personCoffeeType
                .OrderBy(c => c.Value)
                .ThenByDescending(c => c.Key);

            foreach (var person in sorted)
            {
                string name = person.Key;
                string type = person.Value;

                foreach (var item in coffeeLeft)
                {
                    if (type == item.Key)
                    {
                        Console.WriteLine($"{name} {type}");
                        break;
                    }
                }
            }
        }
        

        private static void weekOrders(SortedDictionary<string, string> personCoffeeType, SortedDictionary<string, long> coffeeTypeQuantity)
        {
            while (true)
            {
                string order = Console.ReadLine();
                if (order == "end of week")
                {
                    break;
                }

                string[] splitOrder = order.Split();

                string person = splitOrder[0];
                long quantity = long.Parse(splitOrder[1]);

                string type = personCoffeeType[person];

                if (coffeeTypeQuantity[type] <= quantity && 
                    coffeeTypeQuantity[type] > 0)
                {
                    coffeeTypeQuantity[type] = 0;
                } 
                else if (coffeeTypeQuantity[type] > quantity)
                {
                    coffeeTypeQuantity[type] -= quantity;
                }
            }
        }

        private static void ReadInfo(string firstDelimiter, string secondDelimiter, SortedDictionary<string, string> personCoffeeType, SortedDictionary<string, long> coffeeTypeQuantity)
        {
            while (true)
            {
                string command = Console.ReadLine();
                if (command.Contains("end of info")) break;

                if (command.Contains(firstDelimiter))
                {
                    List<string> info = ExtractInfo(command, firstDelimiter);

                    string name = info[0];
                    string type = info[1];

                    personCoffeeType[name] = type;
                }
                else
                {
                    List<string> info = ExtractInfo(command, secondDelimiter);

                    string type = info[0];
                    long quantity = long.Parse(info[1]);

                    if (coffeeTypeQuantity.ContainsKey(type))
                    {
                        coffeeTypeQuantity[type] += quantity;
                    }
                    else
                    {
                        coffeeTypeQuantity[type] = quantity;
                    }
                }
            }

        }

        private static List<string> ExtractInfo(string command, string delimiter)
        {
            List<string> info = new List<string>();
            
            string first = command.Substring(0, command.IndexOf(delimiter));
            string second = command.Remove(0, command.IndexOf(delimiter) + delimiter.Length);

            info.Add(first);            
            info.Add(second);

            return info;
        }
    }
}
