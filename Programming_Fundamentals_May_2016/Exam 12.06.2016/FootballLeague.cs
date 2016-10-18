using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class FootballLeague
{
    static void Main(string[] args)
    {
        Dictionary<string, int> teamsPoints = new Dictionary<string, int>();
        Dictionary<string, int> teamsGoals = new Dictionary<string, int>();

        ReadData(teamsPoints, teamsGoals);
        PrintResults(teamsPoints, teamsGoals);

    }

    private static void PrintResults(Dictionary<string, int> teamsPoints, Dictionary<string, int> teamsGoals)
    {
        Console.WriteLine("League standings:");
        var sorted = teamsPoints.OrderByDescending(points => points.Value).ThenBy(name => name.Key);
        int position = 1;
        foreach (var country in sorted)
        {
            string team = country.Key.ToUpper();
            int points = country.Value;
            Console.WriteLine($"{position}. {team} {points}");
            position++;
        }

        Console.WriteLine("Top 3 scored goals:");
        var top3Teams = teamsGoals.OrderByDescending(goals => goals.Value).ThenBy(name => name.Key).Take(3);
        foreach (var country in top3Teams)
        {
            string team = country.Key.ToUpper();
            int goals = country.Value;
            Console.WriteLine($"- {team} -> {goals}");
        }
    }

    private static void ReadData(Dictionary<string, int> teamsPoints, Dictionary<string, int> teamsGoals)
    {
        string delimiter = Console.ReadLine();
        while (true)
        {
            var line = Console.ReadLine();
            if (line == "final") break;

            string[] info = ExtractInfo(line, delimiter);

            string firstTeam = Reverse(info[0]);
            string secondTeam = Reverse(info[1]);

            int[] results = info[2]
                .Split(':')
                .Select(int.Parse)
                .ToArray();

            int firstTeamGoals = results[0];
            int secondTeamGoals = results[1];

            FillDataInTables(teamsPoints, teamsGoals, firstTeam, firstTeamGoals);
            FillDataInTables(teamsPoints, teamsGoals, secondTeam, secondTeamGoals);

            if (firstTeamGoals > secondTeamGoals)
            {
                teamsPoints[firstTeam] += 3;
            }
            else if (firstTeamGoals == secondTeamGoals)
            {
                teamsPoints[firstTeam]++;
                teamsPoints[secondTeam]++;
            }
            else
            {
                teamsPoints[secondTeam] += 3;
            }
        }
    }

    private static void FillDataInTables(Dictionary<string, int> teamsPoints, Dictionary<string, int> teamsGoals, string team, int goals)
    {
        if (!teamsPoints.ContainsKey(team))
        {
            teamsPoints.Add(team, 0);
        }

        if (!teamsGoals.ContainsKey(team))
        {
            teamsGoals.Add(team, goals);
        }
        else
        {
            teamsGoals[team] += goals;
        }
    }

    private static string Reverse(string name)
    {
        StringBuilder text = new StringBuilder();

        for (int i = name.Length - 1; i >= 0; i--)
        {
            text.Append(name[i]);
        }

        return text.ToString().ToLower();
    }

    private static string[] ExtractInfo(string line, string delimiter)
    {
        string[] info = new string[3];

        string[] split = line
            .Split(new string[] { " "}, StringSplitOptions.RemoveEmptyEntries)
            .ToArray();

        info[0] = extractData(split[0], delimiter);
        info[1] = extractData(split[1], delimiter);
        info[2] = split[2];  

        return info;
    }

    private static string extractData(string p, string delimiter)
    {        
        int startIndex = p.IndexOf(delimiter) + delimiter.Length;
        int length = p.IndexOf(delimiter, startIndex) - startIndex;

        string data = p.Substring(startIndex, length);

        return data;

    }
}
