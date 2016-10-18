using System;
using System.Collections.Generic;
using System.Linq;

class LogsAggregator
{
    static void Main()
    {
        var userIP = new SortedDictionary<string, List<string>>();
        var userDuration = new SortedDictionary<string, int>();

        FillData(userIP, userDuration);
        PrintReport(userIP, userDuration);
    }

    private static void PrintReport(SortedDictionary<string, List<string>> userIP, SortedDictionary<string, int> userDuration)
    {
        foreach (var user in userIP)
        {
            Console.Write($"{user.Key}: {userDuration[user.Key]} ");

            var sortedIPs = user.Value.OrderBy(ip => ip);
            Console.WriteLine($"[{string.Join(", ", sortedIPs)}]");
        }
    }

    private static void FillData(SortedDictionary<string, List<string>> userIP, SortedDictionary<string, int> userDuration)
    {
        int numberOfLines = int.Parse(Console.ReadLine());
        for (int i = 0; i < numberOfLines; i++)
        {
            var line = Console.ReadLine().Split();

            string ip = line[0];
            string user = line[1];
            int duration = int.Parse(line[2]);

            // Fill user-IP info
            if (userIP.ContainsKey(user))
            {
                if (!userIP[user].Contains(ip))
                {
                    userIP[user].Add(ip);
                }
            }
            else
            {
                userIP.Add(user, new List<string> { ip});
            }

            // Fill user - duration info
            if (userDuration.ContainsKey(user))
            {
                userDuration[user] += duration;
            }
            else
            {
                userDuration.Add(user, duration);
            }
        }
    }
}
