using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Extract_Hyperlinks
{
    class ExtractHyperlinks
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            string[] text = FillText(input);
            FindHyperlinks(text);



            //char[] delimiters = { '\r', '\n', ' ' };

            //string text = FillText(input, delimiters);
            // FindHyperlinks(text);
        }       

        private static string[] FillText(string input)
        {
            StringBuilder text = new StringBuilder();
            while (input != "END")
            {
                text.Append(input);
                input = Console.ReadLine();
            }
            return text.ToString().Split(new string[] { " " }, StringSplitOptions.RemoveEmptyEntries)
                .ToArray();
        }

        //private static string FillText(string input, char[] delimiters)
        //{
        //    StringBuilder text = new StringBuilder();
        //    while (input != "END")
        //    {
        //        string[] splitInput = input
        //            .Split(delimiters, StringSplitOptions.RemoveEmptyEntries)
        //            .ToArray();
        //        text.Append(string.Join("", splitInput));

        //        input = Console.ReadLine();
        //    }
        //    return text.ToString();
        //}

        //private static void FindHyperlinks(string text)
        //{
        //    // Find all <a .../> tags
        //    int startIndex = 0;
        //    int endIndex = 0;
        //    string start = "<a";
        //    string end = ">";
        //    for (int i = 0;  i < text.Length; i++)
        //    {
        //        startIndex = text.IndexOf(start, i + startIndex);
        //        endIndex = text.IndexOf(end, i + startIndex + 1);

        //        if (startIndex >= 0 && endIndex >= 0)
        //        {
        //            string aTagSubstring = text.Substring(
        //                startIndex + start.Length, endIndex - startIndex - 2);
        //            FindHrefs(aTagSubstring);
        //        }
        //        else break;
        //    }
        //}

        //private static void FindHrefs(string aTagSubstring)
        //{
        //    int startIndex = 0;
        //    int endIndex = 0;
        //    string start = "href=";

        //    for (int i = 0; i < aTagSubstring.Length; i++)
        //    {
        //        startIndex = aTagSubstring.IndexOf(start, endIndex);
        //        endIndex = startIndex + start.Length;
        //        if (startIndex >= 0)
        //        {
        //            string hrefTagSubstring = aTagSubstring.Substring(endIndex);
        //            char[] delimiters = { '\"' };
        //            string[] href = hrefTagSubstring
        //                .Split(delimiters, StringSplitOptions.RemoveEmptyEntries)
        //                .ToArray();
        //            Console.WriteLine(href[0]);
        //        }
        //        else break;
        //    }
        //}
    }
}
