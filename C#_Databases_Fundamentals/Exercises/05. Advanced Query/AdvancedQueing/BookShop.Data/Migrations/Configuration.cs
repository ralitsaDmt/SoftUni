namespace BookShop.Data.Migrations
{
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Globalization;
    using System.IO;
    using System.Linq;
    using Models;

    internal sealed class Configuration : DbMigrationsConfiguration<BookShop.Data.BookShopContext>
    {
        public Configuration()
        {
            this.AutomaticMigrationsEnabled = false;
            this.ContextKey = "BookShop.Data.BookShopContext";
        }

        protected override void Seed(BookShop.Data.BookShopContext context)
        {
            // Fill Authors table
            string[] authorLines =
                File.ReadAllLines(
                    "D:\\DB Fundamentals\\Databases Advanced - Entity Framework\\Exercises\\05. Advanced Query\\authors.txt");

            foreach (string line in authorLines)
            {
                string[] data = line.Split(new string[] {" "}, StringSplitOptions.RemoveEmptyEntries);

                string firstName = data[0];
                string LastName = data[1];

                context.Authors.Add(new Author()
                {
                    FirstName = firstName,
                    LastName = LastName
                });
            }

            Random random = new Random();
            List<Author> authors = context.Authors.Local.ToList();
                // Fill Books Table
            string[] bookLines =
                File.ReadAllLines(
                    "D:\\DB Fundamentals\\Databases Advanced - Entity Framework\\Exercises\\05. Advanced Query\\books.txt");

            foreach (string line in bookLines)
            {
                var data = line.Split(new[] { ' ' }, 6);
                var authorIndex = random.Next(0, authors.Count);
                var author = authors[authorIndex];
                var edition = (EditionType)int.Parse(data[0]);
                var releaseDate = DateTime.ParseExact(data[1], "d/M/yyyy", CultureInfo.InvariantCulture);
                var copies = int.Parse(data[2]);
                var price = decimal.Parse(data[3]);
                var ageRestriction = int.Parse(data[4]);
                var title = data[5];

                context.Books.Add(new Book()
                {
                    Author = author,
                    EditionType = edition,
                    ReleaseDate = releaseDate,
                    Copies = copies,
                    Price = price,
                    AgeRestriction = ageRestriction,
                    Title = title
                });
            }
        }
    }
}
