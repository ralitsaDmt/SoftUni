using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07.To_Uppercase
{
    class ToUppercase
    {
        const string OpenTag = "<upcase>";
        const string CloseTag = "</upcase>";

        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            
            StringBuilder modifiedText = new StringBuilder();
            
            int prevPosition = 0;
            for (int i = 0; i < text.Length; i++)
            {
                if (text.Substring(i).StartsWith(OpenTag) || 
                    (i == text.Length - 1 &&
                    !text.EndsWith(CloseTag)))
                {
                    int lastPosition = i - prevPosition;
                    if (i == text.Length - 1)
                    {
                        lastPosition++;
                    }
                    modifiedText.Append(text.Substring(prevPosition, lastPosition));
                    prevPosition = i;
                    i += OpenTag.Length - 1;
                    if (text.Substring(i + 1).IndexOf(CloseTag) < 0)
                    {
                        modifiedText.Append(text.Substring(i + 1));
                        break;
                    }
                }
                else if (text.Substring(i).StartsWith(CloseTag))
                {
                    modifiedText.Append(text.Substring(prevPosition + OpenTag.Length, i - (prevPosition + OpenTag.Length)).ToUpper());
                    prevPosition = i + CloseTag.Length;
                    i += CloseTag.Length - 1;
                    if (text.Substring(i + 1).IndexOf(OpenTag) < 0)
                    {
                        modifiedText.Append(text.Substring(i + 1));
                        break;
                    }
                }
                               
            }

            Console.WriteLine(modifiedText.ToString());

            //string text = Console.ReadLine();

            //int openTag = 0;
            //int closeTag = 0;
            //int offset = -1;

            //while (true)
            //{
            //    openTag = text.IndexOf("<upcase>", offset + 1);
            //    if (openTag < 0)
            //    {
            //        break;
            //    }
            //    closeTag = text.IndexOf("</upcase>", openTag);
            //    if (closeTag < 0)
            //    {
            //        break;
            //    }
            //    //text = MakeUpperCase(text, openTag, closeTag);
            //    offset = text.IndexOf("<upcase>", offset + 1);
            //}

            //Console.WriteLine(text);
        }

        //private static string MakeUpperCase(string text, int openTag, int closeTag)
        //{
        //    StringBuilder modified = new StringBuilder();
            
        //    char[] toUpper = text.Substring(openTag + 8, closeTag - (openTag + 8)).ToCharArray();
        //    for (int i = 0; i < toUpper.Length; i++)
        //    {
        //        toUpper[i] = char.ToUpper(toUpper[i]);
        //    }
        //    string upperCase = string.Join("", toUpper);



        //    text = text.Remove(openTag + 8, closeTag - (openTag + 8));

        //    text = text.Insert(openTag + 8, upperCase);

        //    return text;
        //}
    }
}
