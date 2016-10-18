using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Occurrences_in_String
{
    public class OccurrencesInString
    {
        public static void Main(string[] args)
        {
            string text = Console.ReadLine().ToLower();
            string word = Console.ReadLine().ToLower();

            int index = -1;
            bool hasFoundAllMatches = false;
            int counter = 0;
            while (!hasFoundAllMatches)
            {
                index = text.IndexOf(word, index + 1);
                if (index != -1)
                {
                    counter++;
                }
                else
                {
                    break;
                }
            }
            Console.WriteLine(counter);
        }
    }
}
