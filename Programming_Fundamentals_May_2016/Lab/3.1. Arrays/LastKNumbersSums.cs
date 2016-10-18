using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Last_K_Numbers_Sums
{
    class LastKNumbersSums
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());

            long[] arr = new long[n];
            arr[0] = 1;
            sumLastKNumbers(arr, k);
        }

        static void sumLastKNumbers(long[] arr, int k)
        {
            for (int i = 1; i < arr.Length; i++)
            {
                int startIndex = Math.Max(0, i - k);
                int endIndex = i - 1;
                long sum = 0;

                for (int prev = startIndex; prev <= endIndex; prev++)
                {
                    sum += arr[prev];
                }
                arr[i] = sum;
            }
            Console.WriteLine(string.Join(" ", arr));
        }
    }
}
