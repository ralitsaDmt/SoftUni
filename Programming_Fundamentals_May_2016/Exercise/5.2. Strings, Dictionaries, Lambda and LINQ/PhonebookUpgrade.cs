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
            var phonebook = new SortedDictionary<string, string>();
            var comand = Console.ReadLine().Split(' ').ToArray();
            while (comand[0] != "END")
            {
                if (comand[0] == "A")
                {
                    //phonebook[comand[1]] = comand[2];
                    if (!phonebook.ContainsKey(comand[1]))
                    {
                        phonebook.Add(comand[1], comand[2]);
                    }
                    else
                    {
                        phonebook[comand[1]] = comand[2];
                    }
                }
                   
                else if (comand[0] == "ListAll")
                    foreach (var item in phonebook)
                        Console.WriteLine($"{item.Key} -> {item.Value}");
                comand = Console.ReadLine().Split(' ').ToArray();
            }






            //string[] command = Console.ReadLine()
            //    .Split()
            //    .ToArray();
            //SortedDictionary<string, string> phonebook = new SortedDictionary<string, string>();

            //while (command[0].ToLower() != "end")
            //{
            //    if (command[0] == "A")
            //    {
            //        AddEntryToThePhonebok(phonebook, command);
            //    }
            //    else if (command[0] == "S")
            //    {
            //        SearchForAContact(phonebook, command);
            //    }
            //    else if (command[0] == "ListAll")
            //    {
            //        PrintPhoneboolLexicographically(phonebook);
            //    }

            //    command = Console.ReadLine()
            //        .Split()
            //        .ToArray();
            //}
        }

        private static void PrintPhoneboolLexicographically(SortedDictionary<string, string> phonebook)
        {
            foreach (KeyValuePair<string, string> entry in phonebook)
            {
                Console.WriteLine($"{entry.Key} -> {entry.Value}");
            }
        }

        private static void SearchForAContact(SortedDictionary<string, string> phonebook, string[] command)
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

        private static void AddEntryToThePhonebok(SortedDictionary<string, string> phonebook, string[] command)
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
