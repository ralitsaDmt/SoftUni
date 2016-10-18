using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class HandsOfCards
{
    static void Main(string[] args)
    {
        Dictionary<string, List<string>> players = DrawCards();
        Dictionary<string, int> results = CountPoints(players);
        PrintResults(results);
    }

    private static void PrintResults(Dictionary<string, int> results)
    {
        foreach (var player in results)
        {
            Console.WriteLine($"{player.Key}: {player.Value}");
        }
    }

    private static Dictionary<string, int> CountPoints(Dictionary<string, List<string>> players)
    {
        var results = new Dictionary<string, int>();
        foreach (var player in players)
        {
            List<string> cards = new List<string>();
            cards.AddRange(player.Value.Distinct().ToList());
            int points = CalculateHandValue(cards);

            results.Add(player.Key, points);
        }

        return results;
    }

    private static int CalculateHandValue(List<string> cards)
    {
        int points = 0;

        foreach (var card in cards)
        {
            string power = card.Substring(0, card.Length - 1);
            string type = card.Substring(card.Length - 1);

            int cardValue = 0;
            switch (power)
            {
                case "1": cardValue = 1; break;
                case "2": cardValue = 2; break;
                case "3": cardValue = 3; break;
                case "4": cardValue = 4; break;
                case "5": cardValue = 5; break;
                case "6": cardValue = 6; break;
                case "7": cardValue = 7; break;
                case "8": cardValue = 8; break;
                case "9": cardValue = 9; break;
                case "10": cardValue = 10; break;
                case "J": cardValue = 11; break;
                case "Q": cardValue = 12; break;
                case "K": cardValue = 13; break;
                case "A": cardValue = 14; break;
            }
            switch (type)
            {
                case "S": cardValue *= 4; break;
                case "H": cardValue *= 3; break;
                case "D": cardValue *= 2; break;
                case "C": cardValue *= 1; break;
            }

            points += cardValue;
        }

        return points;
    }

    private static Dictionary<string, List<string>> DrawCards()
    {
        var players = new Dictionary<string, List<string>>();

        while (true)
        {
            var draw = Console.ReadLine()
                .Split(':');
            if (draw.Contains("JOKER")) break;

            var name = draw[0];

            var delimiters = ", ".ToCharArray();
            var cards = draw[1]
                .Split(delimiters, StringSplitOptions.RemoveEmptyEntries)
                .ToList();

            if (players.ContainsKey(name))
            {
                players[name].AddRange(cards);
            }
            else
            {
                players.Add(name, cards);
            }

        }

        return players;
    }
}
