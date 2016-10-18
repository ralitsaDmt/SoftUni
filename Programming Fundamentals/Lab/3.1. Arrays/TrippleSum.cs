using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.Tripple_Sum
{
    class TrippleSum
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine()
                .Split(new string[] { " " }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            DoesTrippleSumExits(nums);
        }

        private static void DoesTrippleSumExits(int[] nums)
        {
            bool containsTrippleSum = false;
            for (int i = 0; i < nums.Length - 1; i++)
            {
                for (int j = i + 1; j < nums.Length; j++)
                {

                    int sum = nums[i] + nums[j];
                    if (nums.Contains(sum))
                    {
                        containsTrippleSum = true;
                        Console.WriteLine($"{nums[i]} + {nums[j]} == {sum}");
                    }
                }
            }
            if (!containsTrippleSum)
            {
                Console.WriteLine("No");
            }
        }
    }
}
