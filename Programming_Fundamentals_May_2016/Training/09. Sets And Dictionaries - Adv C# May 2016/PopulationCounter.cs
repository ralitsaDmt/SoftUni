using System;
using System.Collections.Generic;
using System.Linq;

class PopulationCounter
{
    static void Main()
    {
        var cityCountryPopulation = new
            Dictionary<string, Dictionary<string, int>>();
        var countryTotalPopulation = new
            Dictionary<string, long>();

        FillData(cityCountryPopulation, countryTotalPopulation);

        PrintReports(cityCountryPopulation, countryTotalPopulation);

    }

    private static void PrintReports(Dictionary<string, Dictionary<string, int>> cityCountryPopulation, Dictionary<string, long> countryTotalPopulation)
    {
        var sortedCountries = countryTotalPopulation.OrderByDescending(c => c.Value);

        foreach (var country in sortedCountries)
        {
            Console.WriteLine($"{country.Key} (total population: {country.Value})");

            var sortedCities = cityCountryPopulation[country.Key].OrderByDescending(c => c.Value);
            foreach (var city in sortedCities)
            {
                Console.WriteLine($"=>{city.Key}: {city.Value}");
            }
            
        }
    }

    private static void FillData(Dictionary<string, Dictionary<string, int>> cityCountryPopulation, Dictionary<string, long> countryTotalPopulation)
    {
        while (true)
        {
            var info = Console.ReadLine()
                .Split('|');
            if (info.Contains("report")) break;

            var city = info[0];
            var country = info[1];
            var population = int.Parse(info[2]);

            // Fill country-city-population
            FillCountryCityPopulation(cityCountryPopulation, city, country, population);

            // Fill country - total population
            FillCountryTotalPopulation(countryTotalPopulation, country, population);
        }
    }

    private static void FillCountryTotalPopulation(Dictionary<string, long> countryTotalPopulation, string country, int population)
    {
        if (countryTotalPopulation.ContainsKey(country))
        {
            countryTotalPopulation[country] += population;
        }
        else
        {
            countryTotalPopulation.Add(country, population);
        }
    }

    private static void FillCountryCityPopulation(Dictionary<string, Dictionary<string, int>> cityCountryPopulation, string city, string country, int population)
    {
        if (cityCountryPopulation.ContainsKey(country))
        {
            if (cityCountryPopulation[country].ContainsKey(city))
            {
                cityCountryPopulation[country][city] = population;
            }
            else
            {
                cityCountryPopulation[country].Add(city, population);
            }
        }
        else
        {
            cityCountryPopulation.Add(country, new Dictionary<string, int>());
            cityCountryPopulation[country].Add(city, population);
        }
    }
}