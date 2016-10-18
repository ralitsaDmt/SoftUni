using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Advertisement_Message
{
    class AdvertisementMessage
    {
        static void Main(string[] args)
        {
            string[] phrases = {"Excellent product.”]", "Such a great product.", "I always use that product.", "Best product of its category."};
            string[] events = { "Now I feel good", "I have succeeded to change", "That makes miracles", "I cannot believe but now I feel awesome", "Try it yourself, I am very satisfied" };
            string[] authors = { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Misha" };
            string[] cities = { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

            int count = int.Parse(Console.ReadLine());

            Random rnd = new Random();
            for (int i = 0; i < count; i++)
            {
                int phraseIndex = rnd.Next(0, phrases.Length);
                int eventIndex = rnd.Next(0, events.Length);
                int authorIndex = rnd.Next(0, authors.Length);
                int citiIndex = rnd.Next(0, cities.Length);

                Console.WriteLine("{0} {1} {2} - {3}",
                    phrases[phraseIndex],
                    events[eventIndex],
                    authors[authorIndex],
                    cities[citiIndex]);
            }
        }
    }
}
