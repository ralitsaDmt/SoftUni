using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.URL_Parser
{
    class URLParser
    {
        static void Main(string[] args)
        {
            string url = Console.ReadLine();

            int protocolIndex = url.IndexOf("://");
            string protocol = "";
            if (protocolIndex > 0)
            {
                protocol = url.Substring(0, protocolIndex);
            }
            
            int resourceIndex = url.IndexOf("/", protocolIndex + 3);
            string server = url.Substring(protocolIndex + 3, resourceIndex - protocolIndex - 3);

            string resource = "";
            if (resourceIndex > 0)
            {
                resource = url.Substring(resourceIndex + 1);
            }


            //string input = Console.ReadLine();

            //ParseURL(input);
        }

        //private static void ParseURL(string input)
        //{
        //    bool foundSeparator = false;
        //    string protocol = string.Empty;
        //    string separator = "://";
        //    for (int i = 0; i < input.Length - separator.Length + 1; i++)
        //    {
        //        if (input.Substring(i, separator.Length) == separator)
        //        {
        //            protocol = input.Substring(0, input.IndexOf(separator));
        //            foundSeparator = true;
        //        }
        //    }

        //    if (foundSeparator)
        //    {
        //        input = input.Substring(input.IndexOf(separator) + 3);
        //    }            

        //    foundSeparator = false;
        //    string server = string.Empty;
        //    separator = "/";
        //    for (int i = 0; i < input.Length - separator.Length + 1; i++)
        //    {
        //        if (input.Substring(i, separator.Length) == separator)
        //        {
        //            server = input.Substring(0, input.IndexOf(separator));
        //            foundSeparator = true;
        //        }
        //    }
        //    if (!foundSeparator)
        //    {
        //        server = input;
        //    }

        //    string resource = string.Empty;
        //    if (foundSeparator)
        //    {
        //        resource = input.Substring(input.IndexOf(separator) + 1);
        //    }
        //    else
        //    {
        //        resource = "";
        //    }
            

        //    PrintResults(protocol, server, resource);
        //}

        //private static void PrintResults(string protocol, string server, string resource)
        //{
        //    Console.WriteLine($"[protocol] = \"{protocol}\"");
        //    Console.WriteLine($"[server] = \"{server}\"");
        //    Console.WriteLine($"[resource] = \"{resource}\"");
        //}
    }
}
