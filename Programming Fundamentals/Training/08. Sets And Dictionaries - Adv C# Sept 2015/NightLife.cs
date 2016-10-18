using System;
using System.Collections.Generic;
using System.Linq;

class NightLife
{
    static void Main()
    {
        var cityVenue = new Dictionary<string, List<string>>();
        var venueArtist = new Dictionary<string, List<string>>();

        ReadData(cityVenue, venueArtist);
        PrintData(cityVenue, venueArtist);
    }

    private static void PrintData(Dictionary<string, List<string>> cityVenue, Dictionary<string, List<string>> venueArtist)
    {
        foreach (var city in cityVenue)
        {
            Console.WriteLine(city.Key);
            foreach (var venue in city.Value)
            {
                var line = venueArtist[venue];
                Console.WriteLine($"->{venue}: {string.Join(", ", line)}");
            }
            
        }
    }

    private static void ReadData(Dictionary<string, List<string>> cityVenue, Dictionary<string, List<string>> venueArtist)
    {
        while (true)
        {
            var input = Console.ReadLine()
                .Split(';');
            if (input.Contains("END")) break;

            string city = input[0];
            string venue = input[1];
            string artist = input[2];

            if (!cityVenue.ContainsKey(city))
            {
                cityVenue.Add(city, new List<string>() { venue });
            }
            else if (!cityVenue[city].Contains(venue))
            {
                cityVenue[city].Add(venue);
            }

            if (!venueArtist.ContainsKey(venue))
            {
                venueArtist.Add(venue, new List<string>() { artist });
            }
            else if (!venueArtist[venue].Contains(artist))
            {
                venueArtist[venue].Add(artist);
            }
        }

        foreach (var city in cityVenue)
        {
            city.Value.Reverse();
        }
        foreach (var venue in venueArtist)
        {
            venue.Value.Reverse();
        }
    }    
}