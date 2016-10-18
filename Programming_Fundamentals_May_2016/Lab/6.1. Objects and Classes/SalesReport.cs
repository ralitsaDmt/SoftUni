using System;
using System.Collections.Generic;
using System.Linq;

class SalesReportGenerator
{


    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        var sales = new List<Sale>();
        for (int i = 0; i < n; i++)
        {
            var sale = ReadSale();
            sales.Add(sale);
        }


        var towns = new SortedSet<string>();
        var sums = new SortedDictionary<string, decimal>();
        foreach (var s in sales)
        {
            towns.Add(s.Town);
            sums[s.Town] = 0;
        }
        foreach (var s in sales)
        {
            sums[s.Town] += s.Price * s.Quantity;
        }

        foreach (var t in towns)
        {
            Console.WriteLine($"{t} -> {sums[t]:f2}");
        }

            //sales.Select(s => s.Town).Distinct().OrderBy(t => t).ToList();

        //Console.WriteLine(string.Join(" ", towns));

        foreach (var t in towns)
        {
            var salesorT = sales.Where(s => s.Town == t).Sum(s => s.Price * s.Quantity);
            Console.WriteLine($"{t} -> {salesorT:f2}");
        }
        
    }

    static Sale ReadSale()
    {
        var tokens = Console.ReadLine()
            .Split();
        var town = tokens[0];
        var product = tokens[1];
        var price = decimal.Parse(tokens[2]);
        var quantity = decimal.Parse(tokens[3]);
        var sale = new Sale { Town = town, Product = product, Price = price, Quantity = quantity };
        return sale;
    }
}

class Sale
{
    public string Town { get; set; }

    public string Product { get; set; }

    public decimal Price { get; set; }

    public decimal Quantity { get; set; }


}