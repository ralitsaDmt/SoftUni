using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class FixEmails
{
    static void Main(string[] args)
    {
        Dictionary<string, string> data = FillData();
        var filtered = data
            .Where(d => !d.Value.ToLower().EndsWith("us") &&
            !d.Value.ToLower().EndsWith("uk"));

        foreach (var user in filtered)
        {
            Console.WriteLine($"{user.Key} -> {user.Value}");
        }
    }

    private static Dictionary<string, string> FillData()
    {
        var data = new Dictionary<string, string>();

        int row = 1;
        string last = "";
        while (true)
        {
            var line = Console.ReadLine();
            if (line.ToLower() == "stop") break;

            if (row % 2 != 0)
            {
                if (!data.ContainsKey(line))
                {
                    data.Add(line, "");
                }
                last = line;
            }
            else
            {
                data[last] = line;
            }
            row++;
        }

        return data;        
    }
}
