using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Append_Lists
{
    class AppendLists
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            List<int> result = new List<int>();
            List<string> tokens = input.Split('|').ToList();


            for (int i = tokens.Count - 1; i >= 0; i--)
            {
                List<int> temps = tokens[i].Split(new string[] { " " }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToList();

                foreach (var temp in temps)
                {
                    result.Add(temp);
                }

            }

            Console.WriteLine(string.Join(" ", result));
        }
    }
}
