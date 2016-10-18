using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12._1.Bomb_Numberd
{
    class BombNumbersOK
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToList();

            int[] bomb = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            int specialNumber = bomb[0];
            int power = bomb[1];

            while (numbers.Contains(specialNumber))
            {
                numbers = DetonateBomb(numbers, specialNumber, power);
            }

            Console.WriteLine(numbers.Sum());
        }

        private static List<int> DetonateBomb(List<int> numbers, int specialNumber, int power)
        {
            int specialIndex = numbers.IndexOf(specialNumber);
            int count = 0;
            int start = 0;
            int end = 0;
            if (specialIndex - power < 0)
            {
                start = 0;
            }
            else
            {
                start = specialIndex - power;
            }

            if (specialIndex + power >= numbers.Count)
            {
                end = numbers.Count - 1;
            }
            else
            {
                end = specialIndex + power;
            }

            count = end - start + 1;

            numbers.RemoveRange(start, count);

            return numbers;
        }
    }
}
