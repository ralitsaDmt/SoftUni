using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Odd_and_Even_Jumps
{
    class OddAndEvenJumps
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToLower();
            int oddJump = int.Parse(Console.ReadLine());
            int evenJump = int.Parse(Console.ReadLine());

            long oddResult = 0;
            long evenResult = 0;

            List<char> letters = new List<char>();
            // Fill list with letters
            for (int i = 0; i < input.Length; i++)
            {
                if (input[i] != ' ')
                {
                    letters.Add(input[i]);
                }
            }

            List<char> oddLetters = new List<char>();
            List<char> evenLetters = new List<char>();

            for (int i = 0; i < letters.Count; i++)
            {
                if (i % 2 == 0)
                {
                    oddLetters.Add(letters[i]);
                }
                else
                {
                    evenLetters.Add(letters[i]);
                }
            }

            for (int step = 1; step < oddLetters.Count + 1; step++)
            {
                if (step % oddJump == 0)
                {
                    oddResult *= oddLetters[step - 1];
                }
                else
                {
                    oddResult += oddLetters[step - 1];
                }
            }

            for (int step = 1 ; step < evenLetters.Count + 1; step++)
            {
                if (step % evenJump == 0)
                {
                    evenResult *= evenLetters[step - 1];
                }
                else
                {
                    evenResult += evenLetters[step - 1];
                }
            }

            Console.WriteLine("Odd: {0}", oddResult.ToString("X"));
            Console.WriteLine("Even: {0}", evenResult.ToString("X"));
        }
    }
}
