using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Phonebook
{
    static void Main(string[] args)
    {
        Dictionary<string, string> phonebook = FillPhonebook();
        SearchForContacts(phonebook);
    }

    private static void SearchForContacts(Dictionary<string, string> phonebook)
    {
        while (true)
        {
            var contact = Console.ReadLine();
            if (contact.ToLower() == "stop") break;

            if (phonebook.ContainsKey(contact))
            {
                Console.WriteLine($"{contact} -> {phonebook[contact]}");
            }
            else
            {
                Console.WriteLine($"Contact {contact} does not exist.");
            }
        }
    }

    private static Dictionary<string, string> FillPhonebook()
    {
        var phonebook = new Dictionary<string, string>();
        while (true)
        {
            string[] line = Console.ReadLine().Split('-');
            if (line.Contains("search")) break;

            string name = line[0];
            string number = line[1];

            if (phonebook.ContainsKey(name))
            {
                phonebook[name] = number;
            }
            else
            {
                phonebook.Add(name, number);
            }
        }

        return phonebook;
    }
}