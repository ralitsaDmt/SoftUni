namespace test
{
    using System;
    using System.Collections.Generic;
    using System.IO;
    using System.Xml.Linq;
    using System.Xml.XPath;
    using Movie.ConsoleClient.ImportModels;
    using Movie.Models;
    using Newtonsoft.Json;
    using Newtonsoft.Json.Linq;

    public class Program
    {
        public static void Main(string[] args)
        {

            var xml = XDocument.Load(@"D:\DB Fundamentals\Databases Advanced - Entity Framework\Exercises\05. Advanced Query\data\users.xml");

            var users = xml.XPathSelectElements("users/user");

            var doc = new XElement("users");

            foreach (XElement xElement in users)
            {
                Console.WriteLine(xElement.Attribute("username"));
            }

            foreach (XElement userNode in users)
            {
                Console.WriteLine("kur");
                var user = new User();

                if (userNode.Attribute("age") != null)
                {
                    user.Age = int.Parse(userNode.Attribute("age").Value);
                }
                user.Username = userNode.Attribute("username").Value;
                user.Email = userNode.Attribute("email").Value;

                var elemNode = new XElement("user");

                elemNode.Add(new XAttribute("username", user.Username));
                elemNode.Add(new XAttribute("age", user.Age));
                elemNode.Add(new XAttribute("email", user.Email));

                doc.Add(elemNode);
            }    

            doc.Save(@"D:\DB Fundamentals\Databases Advanced - Entity Framework\Exercises\05. Advanced Query\results\users.xml");

           


//            string text =
//                File.ReadAllText(
//                    "D:\\DB Fundamentals\\Databases Advanced - Entity Framework\\Exercises\\05. Advanced Query\\data\\users.json");
//
//            List<ImportUser> textUesrs = JsonConvert.DeserializeObject<List<ImportUser>>(text);
//
//            foreach (ImportUser user in textUesrs)
//            {
//                Console.WriteLine(user.Country);
//            }
//
////            File.WriteAllText(@"c:\movie.json", JsonConvert.SerializeObject(movie));
        }
    }
}
