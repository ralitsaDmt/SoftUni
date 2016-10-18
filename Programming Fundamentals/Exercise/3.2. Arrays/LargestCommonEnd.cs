using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Largest_Common_End
{
    class LargestCommonEnd
    {
        static void Main(string[] args)
        {
            string[] firstArray = Console.ReadLine().Split();
            string[] secondArray = Console.ReadLine().Split();

            int length = Math.Min(firstArray.Length, secondArray.Length);
            int maxCount = 0;
            int endIndex = 0;

            //scan from left to right
            for (int i = 0; i < length; i++)
            {
                int count = 0;
                int element = i;
                while (firstArray[element] == secondArray[element])
                {
                    count++;
                    element++;
                    if (element == length)
                    {
                        break;
                    }
                }
                if (count > maxCount)
                {
                    maxCount = count;
                    endIndex = element - 1;
                }
                if (count > 0)
                {
                    i += count - 1;
                }
            }

            //scan from right to left
            Reverse(firstArray);
            Reverse(secondArray);
            
            for (int i = 0; i < length; i++)
            {
                int count = 0;
                int element = i;
                while (firstArray[element] == secondArray[element])
                {
                    count++;
                    element++;
                    if (element == length)
                    {
                        break;
                    }
                }
                if (count > maxCount)
                {
                    maxCount = count;
                    endIndex = element - 1;
                }
                if (count > 0)
                {
                    i += count - 1;
                }
            }

            Console.WriteLine(maxCount);
        }

        private static void Reverse(string[] arr)
        {
            for (int i = 0; i < arr.Length / 2; i++)
            {
                string tmp = arr[i];
                arr[i] = arr[arr.Length - i - 1];
                arr[arr.Length - i - 1] = tmp;
            }
        }
    }
}
