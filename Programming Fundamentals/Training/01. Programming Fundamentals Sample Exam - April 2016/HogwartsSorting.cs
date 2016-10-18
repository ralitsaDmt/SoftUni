using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Hogwarts_Sorting
{
    class HogwartsSorting
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string[] name = new string[2];
            int GryffindorCount = 0;
            int SlytherinCount = 0;
            int RavenclawCount = 0;
            int HufflepuffCount = 0;

            for (int i = 0; i < n; i++)
            {
                name = Console.ReadLine().Split();
                string house = string.Empty;

                //Find house and count students in each house
                int sum = FindSum(name);
                int reminder = sum % 4;
                switch (reminder)
                {
                    case 0: house = "Gryffindor";
                        GryffindorCount++; break;
                    case 1: house = "Slytherin";
                        SlytherinCount++; break;
                    case 2: house = "Ravenclaw";
                        RavenclawCount++; break;
                    case 3: house = "Hufflepuff";
                        HufflepuffCount++; break;
                    default:
                        break;
                }

                //Find faculty number
                StringBuilder facNumber = new StringBuilder();
                facNumber.Append(sum.ToString());
                facNumber.Append(name[0].First());
                facNumber.Append(name[1].First());
                Console.WriteLine($"{house} {facNumber}");
            }
            Console.WriteLine();
            Console.WriteLine($"Gryffindor: {GryffindorCount}");
            Console.WriteLine($"Slytherin: {SlytherinCount}");
            Console.WriteLine($"Ravenclaw: {RavenclawCount}");
            Console.WriteLine($"Hufflepuff: {HufflepuffCount}");

        }

        private static int FindSum(string[] name)
        {
            int sum = 0;
            for (int i = 0; i < name.Length; i++)
            {
                for (int j = 0; j < name[i].Length; j++)
                {
                    sum += name[i][j];
                }
            }            
            return sum;
        }
    }
}
