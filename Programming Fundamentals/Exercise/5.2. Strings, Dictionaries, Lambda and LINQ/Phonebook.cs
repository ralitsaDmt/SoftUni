using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Phonebook
{
    class Phonebook
    {
        static void Main(string[] args)
        {
            string[] command = Console.ReadLine()
                .Split()
                .ToArray();
            Dictionary<string, string> phonebook = new Dictionary<string, string>();
            
            while (command[0].ToLower() != "end")
            {
                if (command[0] == "A")
                {
                    AddEntryToThePhonebok(phonebook, command);
                }
                else if (command[0] == "S")
                {
                    SearchForAContact(phonebook, command);
                }

                command = Console.ReadLine()
                    .Split()
                    .ToArray();
            }   
        }

        private static void SearchForAContact(Dictionary<string, string> phonebook, string[] command)
        {
            string name = command[1];
            if (phonebook.ContainsKey(name))
            {
                Console.WriteLine($"{name} -> {phonebook[name]}");
            }
            else
            {
                Console.WriteLine($"Contact {name} does not exist.");
            }
        }

        private static void AddEntryToThePhonebok(Dictionary<string, string> phonebook, string[] command)
        {
            string name = command[1];
            string number = command[2];
            if (!phonebook.ContainsKey(name))
            {
                phonebook.Add(name, number);
            }
            else
            {
                phonebook[name] = number;
            }
        }
    }
}
