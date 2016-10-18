using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Morse_Code_Numbers
{
    class MorseCodeNumbers
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());

            int nSum = CalculateSum(num);
            bool foundSum = false;

            int[] morseCodeNumbers = new int[6];
            int morseProduct = 1;

            for (int num1 = 0; num1 < 6; num1++)
            {
                for (int num2 = 0; num2 < 6; num2++)
                {
                    for (int num3 = 0; num3 < 6; num3++)
                    {
                        for (int num4 = 0; num4 < 6; num4++)
                        {
                            for (int num5 = 0; num5 < 6; num5++)
                            {
                                for (int num6 = 0; num6 < 6; num6++)
                                {
                                    morseProduct = num1 * num2 * num3 * num4 * num5 * num6;
                                    if (morseProduct == nSum)
                                    {
                                        foundSum = true;
                                        FillNumbers(morseCodeNumbers, num1, num2, num3, num4, num5, num6);
                                        PrintNumbers(morseCodeNumbers);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (!foundSum)
            {
                Console.WriteLine("No");
            }
        }

        private static void PrintNumbers(int[] morseCodeNumbers)
        {
            string[] dotsAndDashes = new string[6];

            for (int i = 0; i < morseCodeNumbers.Length; i++)
            {
                switch (morseCodeNumbers[i])
                {
                    case 0: dotsAndDashes[i] = "-----"; break;
                    case 1: dotsAndDashes[i] = ".----"; break;
                    case 2: dotsAndDashes[i] = "..---"; break;
                    case 3: dotsAndDashes[i] = "...--"; break;
                    case 4: dotsAndDashes[i] = "....-"; break;
                    case 5: dotsAndDashes[i] = "....."; break;
                }                
            }
            Console.WriteLine(string.Join("|", dotsAndDashes) + "|");
        }

        private static void FillNumbers(int[] morseCodeNumbers, int num1, int num2, int num3, int num4, int num5, int num6)
        {
            morseCodeNumbers[0] = num1;
            morseCodeNumbers[1] = num2;
            morseCodeNumbers[2] = num3;
            morseCodeNumbers[3] = num4;
            morseCodeNumbers[4] = num5;
            morseCodeNumbers[5] = num6;
        }

        private static int CalculateSum(int num)
        {
            int sum = 0;
            while (num != 0)
            {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
}
