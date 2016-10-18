using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

class Student
{
    public string Name { get; set; }
    public string Email { get; set; }
    public DateTime RegistrationDate { get; set; }
}

class Town
{
    public string Name { get; set; }
    public int SeatsCount { get; set; }
    public List<Student> Students { get; set; }
}

class Group
{
    public Town Town { get; set; }
    public List<Student> Students { get; set; }
}

class StudentGroups
{
    static void Main(string[] args)
    {
        List<Town> towns = ReadInput();
    }

    private static List<Town> ReadInput()
    {
        var towns = new List<Town>();
        while (true)
        {
            var input = Console.ReadLine();
            if (input == "End") break;


            if (input.Contains("=>"))
                ReadTown(towns, input);
            else
            {
                var splitInput = input.
                    Split(new char[] { '|' }, StringSplitOptions.RemoveEmptyEntries);
                var student = new Student
                {
                    Name = splitInput[0],
                    Email = splitInput[1],
                    RegistrationDate =
                    DateTime.ParseExact(splitInput[3], "dd-MMM-yyyy", CultureInfo.InvariantCulture)
                };

            }

        }
        return towns;
    }

    private static void ReadTown(List<Town> towns, string input)
    {
        var splitInput = input.Split().ToList();
        var townName = string.Join(" ", splitInput.Take(splitInput.IndexOf("=>")).ToString());
        var seats = int.Parse(splitInput[splitInput.IndexOf("=>") + 1]);

        Town town = new Town { Name = townName, SeatsCount = seats };
        towns.Add(town);
    }
}

