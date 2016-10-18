using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Sequence_of_K_Numbers
{
    class SequenceOfKNumbers
    {
        static void Main(string[] args)
        {
            int[] seq = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int k = int.Parse(Console.ReadLine());

            for (int i = 0; i <= seq.Length - k; i++)
            {
                bool areEqual = false;
                int element = seq[i];
                for (int j = i; j < i + k; j++)
                {
                    if (element == seq[j])
                    {
                        areEqual = true;
                    }
                    else
                    {
                        areEqual = false;
                        break;
                    }
                }
                if (areEqual)
                {
                    for (int j = i; j < i + k; j++)
                    {
                        seq[j] = -1001;
                    }
                }
            }

            List<int> result = new List<int>();
            for (int i = 0; i < seq.Length; i++)
            {
                if (seq[i] != -1001)
                {
                    result.Add(seq[i]);
                }
            }
            Console.WriteLine(string.Join(" ", result));
        }
    }
}
