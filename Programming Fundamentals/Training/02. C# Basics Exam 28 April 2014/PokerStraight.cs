using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Poker_Straight
{
    class PokerStraight
    {
        static void Main(string[] args)
        {
            int targetWeigth = int.Parse(Console.ReadLine());

            int[] suit = { 1, 2, 3, 4 };
            int[] value = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

            int count = 0;
            int[] sequence = new int[5];
            int weight = 0;

            for (int i = 0; i <= value.Length - 5; i++)
            {
                FillSequence(sequence, value, i);

                for (int card1 = 0; card1 < 4; card1++)
                {
                    for (int card2 = 0; card2 < 4; card2++)
                    {
                        for (int card3 = 0; card3 < 4; card3++)
                        {
                            for (int card4 = 0; card4 < 4; card4++)
                            {
                                for (int card5 = 0; card5 < 4; card5++)
                                {
                                    weight = (10 * sequence[0] + suit[card1]) +
                                        (20 * sequence[1] + suit[card2]) +
                                        (30 * sequence[2] + suit[card3]) +
                                        (40 * sequence[3] + suit[card4]) +
                                        (50 * sequence[4] + suit[card5]);

                                    if (weight == targetWeigth)
                                    {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }



            Console.WriteLine(count);

        }

        private static void FillSequence(int[] sequence, int[] value, int i)
        {
            for (int j = 0; j < 5; j++)
            {
                sequence[j] = value[i];
                i++;
            }
        }
    }
}
