using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class UniqueUsernames
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        var userNames = new List<string>();
        for (int i = 0; i < n; i++)
        {
            var userName = Console.ReadLine();
            if (!userNames.Contains(userName))
            {
                userNames.Add(userName);
            }            
        }
        foreach (var user in userNames)
        {
            Console.WriteLine(user);
        }
    }
}