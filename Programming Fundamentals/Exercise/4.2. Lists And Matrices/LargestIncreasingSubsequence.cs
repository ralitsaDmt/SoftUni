using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Largest_Increasing_Subsequence
{
    class LargestIncreasingSubsequence
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine()
                .Split(new string[] { " " },
                StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int[] LIS = new int[numbers.Length];
            int[] prev = new int[LIS.Length];

            List<int> longestSubsequence = new List<int>();

            int maxLength = 1;
            int bestEnd = 0;

            LIS[0] = 1;
            prev[0] = -1;

            for (int i = 1; i < numbers.Length; i++)
            {
                LIS[i] = 1;
                prev[i] = -1;

                for (int j = 0; j <= i - 1; j++)
                {
                    if (LIS[j] + 1 > LIS[i] && numbers[j] < numbers[i])
                    {
                        LIS[i] = LIS[j] + 1;
                        prev[i] = j;
                    }

                    if (LIS[i] > maxLength)
                    {
                        maxLength = LIS[i];
                        bestEnd = i;
                    }
                }
            }

            longestSubsequence = RestoreLIS(numbers, prev, bestEnd);
            Console.WriteLine(string.Join(" ", longestSubsequence));
        }

        public static List<int> RestoreLIS(int[] seq, int[] prev, int lastIndex)
        {
            List<int> longestSequence = new List<int>();

            while (lastIndex != -1)
            {
                longestSequence.Add(seq[lastIndex]);
                lastIndex = prev[lastIndex];
            }

            longestSequence.Reverse();

            return longestSequence.ToList();
        }
    }
}
