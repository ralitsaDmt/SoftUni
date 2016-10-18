using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.Odd_Occurrences
{
    public class OddOccurrences
    {
        public static void Main(string[] args)
        {
            //List<int> numbers = new List<int> { 1, 2, 6, -56, 359 };
            //Console.WriteLine(string.Join(", ", numbers.Skip(2)));
            //Console.WriteLine(string.Join(", ", numbers.OrderBy(x => x)));
            //Console.WriteLine(string.Join(", ", numbers.OrderBy(x => -x)));

            //List<string> names = new List<string> { "nqkoj", "drug", "treti" };
            //Console.WriteLine(string.Join(" ", names.OrderBy(x => -x.Length).ThenBy(x => x)));

            //Dictionary<string, int> dict = new Dictionary<string, int>();
            //dict.Add("pesho", 5);
            //dict.Add("sesho", 15);
            //dict.Add("desho", -75);
            //dict.Add("mesho", 25);

            //foreach (var i in dict.OrderBy(kvPair => kvPair.Value).ThenBy(kvPair => kvPair.Key))
            //{
            //    Console.WriteLine("{0} -> {1}", i.Key, i.Value);
            //}

            List<string> words = Console.ReadLine()
                .ToLower()
                .Split()
                .ToList();

            Dictionary<string, int> occurances = new Dictionary<string, int>();
            FillOccurances(occurances, words);


            //foreach (var KVPair in occurances.Where(KVPair => KVPair.Value % 2 != 0))
            //{

            //}

            List<string> result = new List<string>();
            foreach (var KVPair in occurances)
            {
                if (KVPair.Value % 2 == 0)
                {
                    continue;
                }
                result.Add(KVPair.Key);
            }
            Console.WriteLine(string.Join(", ", result));
        }

        private static void FillOccurances(Dictionary<string, int> occurances, List<string> words)
        {
            foreach (var word in words)
            {
                if (occurances.ContainsKey(word))
                {
                    occurances[word]++;
                }
                else
                {
                    occurances.Add(word, 1);
                }
            }
        }
    }
}
