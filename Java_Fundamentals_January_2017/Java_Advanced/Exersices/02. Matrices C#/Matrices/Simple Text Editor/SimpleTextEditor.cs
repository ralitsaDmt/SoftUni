namespace Simple_Text_Editor
{
    using System;
    using System.Collections.Generic;

    public class SimpleTextEditor
    {
        public static void Main(string[] args)
        {
            int countOfOperations = int.Parse(Console.ReadLine());

            Stack<string> textOperations = new Stack<string>();

            for (int i = 0; i < countOfOperations; i++)
            {
                string[] command = Console.ReadLine().Split(' ');

                switch (command[0])
                {
                    case "1": AppendText(textOperations, command[1]);
                        break;
                    case "2":
                        int count = int.Parse(command[1]);
                        EraseElementsFromText(textOperations, count); break;
                    case "3":
                        int index = int.Parse(command[1]) - 1;
                        PrintElement(textOperations, index); break;
                    case "4":
                        textOperations.Pop(); break;
                }
            }

        }

        private static void PrintElement(Stack<string> textOperations, int index)
        {
            if (textOperations.Count != 0)
            {
                string text = textOperations.Peek();
                if (index < text.Length && index >= 0)
                {
                    Console.WriteLine(text[index]);
                }
            }
        }

        private static void EraseElementsFromText(Stack<string> textOperations, int count)
        {
            if (textOperations.Count != 0)
            {
                string text = textOperations.Peek();
                text = text.Substring(0, text.Length - count);
                textOperations.Push(text);
            }
        }

        private static void AppendText(Stack<string> textOperations, string s)
        {
            if (textOperations.Count == 0)
            {
                textOperations.Push(s);
                return;
            }

            textOperations.Push(textOperations.Peek() + s);
        }
    }
}
