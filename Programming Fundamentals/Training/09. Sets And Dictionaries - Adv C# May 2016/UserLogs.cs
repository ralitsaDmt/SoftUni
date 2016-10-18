using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class UserLogs
{
    static void Main(string[] args)
    {
        var logsByUser = new SortedDictionary<string, Dictionary<string, int>>();

        while (true)
        {
            string input = Console.ReadLine();
            if (input.Contains("end")) break;
            
            string[] logInfo = input.Split();

            string[] ipInfo = logInfo[0].Split('=');
            string ip = ipInfo[1];
            string[] userInfo = logInfo[2].Split('=');
            string user = userInfo[1];

            if (!logsByUser.ContainsKey(user))
            {
                logsByUser.Add(user, new Dictionary<string, int>());
                logsByUser[user].Add(ip, 0);
            }
            else if (!logsByUser[user].ContainsKey(ip))
            {
                logsByUser[user].Add(ip, 0);
            }

            logsByUser[user][ip]++;
        }

        foreach (var outerPair in logsByUser)
        {
            Console.WriteLine($"{outerPair.Key}:");
            var temp = string.Join(", ", outerPair.Value
                .Select(x => $"{x.Key} => {x.Value}"));
            Console.WriteLine($"{temp}.");
        }

        //var userNameIP = new SortedDictionary<string, List<string>>();
        //var ipMessagesCount = new Dictionary<string, int>();

        //ReadData(userNameIP, ipMessagesCount);
        //PrintCountOfMessages(userNameIP, ipMessagesCount);
    }

    private static void PrintCountOfMessages(SortedDictionary<string, List<string>> userNameIP, Dictionary<string, int> ipMessagesCount)
    {
        foreach (var user in userNameIP)
        {
            Console.WriteLine($"{user.Key}:");

            var messageCount = new List<string>();
            foreach (var ip in user.Value)
            {
                var count = ipMessagesCount[ip];
                messageCount.Add(ip.ToString() + " => " + count.ToString());
            }

            Console.WriteLine(string.Join(", ", messageCount) + ".");
        }
    }

    private static void ReadData(SortedDictionary<string, List<string>> userNameIP, Dictionary<string, int> ipMessagesCount)
    {
        while (true)
        {
            var message = Console.ReadLine()
                .Split(new string[] { " "},
                StringSplitOptions.RemoveEmptyEntries);
            if (message.Contains("end")) break;

            var ip = message[0].Remove(0, 3);
            var user = message[2].Remove(0, 5);

            if (userNameIP.ContainsKey(user) &&
                !userNameIP[user].Contains(ip))
            {
                userNameIP[user].Add(ip);
            }
            else if (!userNameIP.ContainsKey(user))
            {
                userNameIP.Add(user, new List<string>() { ip });
            }

            if (ipMessagesCount.ContainsKey(ip))
            {
                ipMessagesCount[ip]++;
            }
            else
            {
                ipMessagesCount[ip] = 1;
            }

        }
    }
}
