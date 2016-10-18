using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Population_Aggregation
{
    class PopulationAggregation
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine()
                .Split('\\');

            char[] prohibitetSymbols = { '@', '#', '$', '&', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

            Dictionary<string, int> countries = new Dictionary<string, int>();
            SortedDictionary<string, int> cities = new SortedDictionary<string, int>();

            while (input[0].ToLower() != "stop")
            {
                for (int i = 0; i < input.Length - 1; i++)
                {
                    input[i] = string.Join("", input[i]
                        .Split(prohibitetSymbols));
                }

                string city = string.Empty;
                string country = string.Empty;
                int population = int.Parse(input[2]);

                if (char.IsLower(input[0][0]))
                {
                    city = input[0];
                    country = input[1];               
                }
                else
                {
                    city = input[1];
                    country = input[0];
                }

                cities[city] = population;
                if (countries.ContainsKey(country))
                {
                    countries[country]++;
                }
                else
                {
                    countries[country] = 1;
                }

                input = Console.ReadLine().Split('\\');
            }

            foreach (var country in countries)
            {
                Console.WriteLine($"{country.Key} -> {country.Value}");
            }

            var topCities = cities.OrderByDescending(c => c.Value);
            int count = 1;
            foreach (var city in topCities)
            {
                if (count <= 3)
                {
                    Console.WriteLine($"{city.Key} -> {city.Value}");
                    count++;
                }
                else
                {
                    break;
                }
            }

        }
    }
}
