using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Censor_Your_Email
{
    class CensorYourEmail
    {
        static void Main(string[] args)
        {
            string email = Console.ReadLine();
            string text = Console.ReadLine();

            string[] splitEmail = email
                .Split('@')
                .ToArray();
            char[] username = splitEmail[0].ToCharArray();
            string replacement = CreateReplacementString(username, splitEmail[1]);

            Console.WriteLine(text.Replace(email, replacement));
        }

        private static string CreateReplacementString(char[] username, string domain)
        {
            StringBuilder replace = new StringBuilder();

            foreach (char symbol in username)
            {
                replace.Append('*');
            }
            replace.Append('@');
            replace.Append(domain);

            return replace.ToString();
        }
    }
}
