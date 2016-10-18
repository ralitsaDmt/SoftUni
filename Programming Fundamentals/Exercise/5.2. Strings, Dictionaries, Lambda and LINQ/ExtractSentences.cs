using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Extract_Sentences
{
    class ExtractSentences
    {
        static void Main(string[] args)
        {
            string word = Console.ReadLine();
            string text = Console.ReadLine();

            char[] separators = { '.', '!', '?' };
            string[] sentences = text
                .Split(separators, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
            for (int i = 0; i < sentences.Length; i++)
            {
                sentences[i] = sentences[i].TrimStart();
            }

            List<string> validSentences = FindValidSentences(sentences, word);

            PrintResults(validSentences);
        }

        private static void PrintResults(List<string> validSentences)
        {
            foreach (string sentence in validSentences)
            {
                Console.WriteLine(sentence);
            }
        }

        private static List<string> FindValidSentences(string[] sentences, string word)
        {
            List<string> validSentences = new List<string>();

            foreach (string sentence in sentences)
            {
                for (int i = 0; i < sentence.Length - word.Length + 1; i++)
                {
                    if (sentence.Substring(i, word.Length) == word)
                    {
                        if (i == 0 &&
                           !char.IsLetter(sentence[i + word.Length]))
                        {
                            validSentences.Add(sentence);
                            break;
                        }
                        else if (i == sentence.Length - word.Length &&
                                !char.IsLetter(sentence[i - 1]))
                        {
                            validSentences.Add(sentence);
                            break;
                        }
                        else if (i > 0 && i < sentence.Length - word.Length + 1 &&
                                !char.IsLetter(sentence[i - 1]) &&
                                !char.IsLetter(sentence[i + word.Length]))
                        {
                            validSentences.Add(sentence);
                            break;
                        }
                    }
                }
            }

            return validSentences;
        }
    }
}
