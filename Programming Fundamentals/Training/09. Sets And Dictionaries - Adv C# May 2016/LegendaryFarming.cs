using System;
using System.Collections.Generic;
using System.Linq;

class LegendaryFarming
{
    static void Main()
    {
        var keyMaterials = new Dictionary<string, int>();
        var junk = new SortedDictionary<string, int>();

        CollectMaterials(keyMaterials, junk);
        PrintRemainingMaterials(keyMaterials, junk);
    }

    private static void PrintRemainingMaterials(Dictionary<string, int> keyMaterials, SortedDictionary<string, int> junk)
    {
        var sortedKeMaterials = keyMaterials
            .OrderByDescending(qnty => qnty.Value)
            .ThenBy(material => material.Key);
        foreach (var material in sortedKeMaterials)
        {
            Console.WriteLine($"{material.Key}: {material.Value}");
        }

        foreach (var item in junk)
        {
            Console.WriteLine($"{item.Key}: {item.Value}");
        }

    }

    private static void CollectMaterials(Dictionary<string, int> keyMaterials, SortedDictionary<string, int> junk)
    {
        keyMaterials.Add("shards", 0);
        keyMaterials.Add("fragments", 0);
        keyMaterials.Add("motes", 0);

        while (true)
        {
            var items = Console.ReadLine()
                .ToLower()
                .Split();

            for (int i = 0; i < items.Length; i += 2)
            {
                int quantity = int.Parse(items[i]);
                string material = items[i + 1];

                if (keyMaterials.ContainsKey(material))
                {
                    FillKeyMaterials(keyMaterials, quantity, material);
                }
                else
                {
                    FillJunk(junk, material, quantity);
                }

                if (keyMaterials.ContainsKey(material) && keyMaterials[material] >= 250)
                {
                    string legendaryItem = "";
                    switch (material)
                    {
                        case "shards":
                            legendaryItem = "Shadowmourne"; break;
                        case "fragments":
                            legendaryItem = "Valanyr"; break;
                        case "motes":
                            legendaryItem = "Dragonwrath"; break;
                    }
                    Console.WriteLine($"{legendaryItem} obtained!");
                    keyMaterials[material] -= 250;
                    return;
                }
            }
        }
    }

    private static void FillJunk(SortedDictionary<string, int> junk, string material, int quantity)
    {
        if (junk.ContainsKey(material))
        {
            junk[material] += quantity;
        }
        else
        {
            junk.Add(material, quantity);
        }
    }

    private static void FillKeyMaterials(Dictionary<string, int> keyMaterials, int quantity, string material)
    {
        keyMaterials[material] += quantity;
    }
}
