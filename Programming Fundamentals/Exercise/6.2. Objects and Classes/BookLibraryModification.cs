using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

class BookLibrary
{
    class Book
    {
        public string Title { get; set; }
        public string Author { get; set; }
        public string Publisher { get; set; }
        public DateTime ReleaseDate { get; set; }
        public long Number { get; set; }
        public decimal Price { get; set; }
    }

    class Library
    {
        public string Name { get; set; }
        public List<Book> Books { get; set; }
    }

    static void Main(string[] args)
    {
        int booksCount = int.Parse(Console.ReadLine());
        DateTime date = new DateTime();
       
        
        List<Library> library = new List<Library>();
        library = ReadLibrary(booksCount, library);
        string dateStr = Console.ReadLine();
        date = DateTime.ParseExact(dateStr, "d.M.yyyy", null);

        var titles = new Dictionary<string, DateTime>();
        foreach (var lib in library)
        {
            foreach (var book in lib.Books)
            {
                if (book.ReleaseDate > date)
                {
                    titles[book.Title] = book.ReleaseDate;
                }
            }
        }

        var sorted = titles.OrderBy(t => t.Value).ThenBy(t => t.Key);

        foreach (var s in sorted)
        {
            Console.WriteLine($"{s.Key} -> {s.Value:dd.MM.yyyy}");
        }
    }

    private static List<Library> ReadLibrary(int booksCount, List<Library> library)
    {
        for (int i = 0; i < booksCount; i++)
        {
            Book book = ReadBook();

            bool contains = false;
            foreach (var lib in library)
            {
                if (lib.Name == book.Author)
                {
                    contains = true;
                    lib.Books.Add(book);
                }
            }
            if (!contains)
            {
                Library instance = new Library();
                instance.Name = book.Author;
                instance.Books = new List<Book>();
                instance.Books.Add(book);
                library.Add(instance);
            }
        }
        return library;
    }

    private static Book ReadBook()
    {
        var input = Console.ReadLine().Split();
        Book book = new Book()
        {
            Title = input[0],
            Author = input[1],
            Publisher = input[2],
            ReleaseDate = DateTime.ParseExact(input[3].ToString(), "d.M.yyyy", CultureInfo.InvariantCulture),
            Number = long.Parse(input[4]),
            Price = decimal.Parse(input[5])
        };
        return book;
    }
}

