using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Randomize_Words
{
    class RandomizeWords
    {
        static void Main(string[] args)
        {
            var words = Console.ReadLine()
                .Split()
                .ToArray();

            Random rnd = new Random();
            for (int first = 0; first < words.Length; first++)
            {
                var second = rnd.Next(words.Length);

                var temp = words[first];
                words[first] = words[second];
                words[second] = temp;
            }

            Console.WriteLine(string.Join("\r\n", words));
            //string[] words = Console.ReadLine()
            //    .Split()
            //    .ToArray();
            //Random rnd = new Random();

            //for (int pos1 = 0; pos1 < words.Length; pos1++)
            //{
            //    int pos2 = rnd.Next(words.Length);

            //    string temp = words[pos1];
            //    words[pos1] = words[pos2];
            //    words[pos2] = temp;
            //}

            //Console.WriteLine(string.Join("\r\n", words));
        }
    }
}
