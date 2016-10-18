using System;
using System.Collections.Generic;
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

        List<Library> library = new List<Library>();
        library = ReadLibrary(booksCount, library);

        var sums = new Dictionary<string, decimal>();
        foreach (var lib in library)
        {
            sums[lib.Name] = 0;
        }
        foreach (var lib in library)
        {
            foreach (var book in lib.Books)
            {
                sums[lib.Name] += book.Price;
            }
        }

        var sorted = sums.OrderByDescending(s => s.Value).ThenBy(s => s.Key);

        foreach (var s in sorted)
        {
            Console.WriteLine($"{s.Key} -> {s.Value:f2}");
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
            ReleaseDate = DateTime.Parse(input[3]),
            Number = long.Parse(input[4]),
            Price = decimal.Parse(input[5])
        };
        return book;
    }
}

