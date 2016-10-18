using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.Magic_exchangeable_words
{
    class MagicExchangeableWords
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split();

            bool areExchangeable = AreWordsExchangeable(input);
        }

        private static bool AreWordsExchangeable(string[] input)
        {
            bool areExchangeable = false;

            string str1 = input[0];
            string str2 = input[1];



            return areExchangeable;
        }
    }
}
