namespace Sale.Data.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using Models;

    internal sealed class Configuration : DbMigrationsConfiguration<global::Sale.Data.SalesContext>
    {
        public Configuration()
        {
            this.AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(SalesContext context)
        {
            Random rnd = new Random();

            string[] names = {"Ivan", "Roli", "Sino", "Joro", "Alis", "Trofon", "Petyo", "Mery"};

            string[] emails = {"abv@abv.bg", "asdasd@gfsg.fvf", "bbb@gmail.com"};

            for (int i = 0; i < 5; i++)
            {
                context.Customers.AddOrUpdate(new Customer()
                {
                    Name = names[rnd.Next(names.Length)],
                    Email = emails[rnd.Next(emails.Length)]
                });
            }

            string[] productNames = {"Pad", "JS", "Java", "PHP", "C#", "Pearl", "Ruby"};

            for (int i = 0; i < 5; i++)
            {
                context.Products.AddOrUpdate(
                    new Product()
                    {
                        Name =  productNames[rnd.Next(productNames.Length)],
                        Quantity = rnd.Next(10),
                        Price = (decimal)rnd.NextDouble() * 100m
                    });
            }

            string[] locationNames = {"Sofia", "Plovdiv", "Burgas", "Varna", "Haskovo"};

            for (int i = 0; i < 5; i++)
            {
                context.StoreLocations.AddOrUpdate(
                    new StoreLocation()
                    {
                        LocationName = locationNames[rnd.Next(locationNames.Length)]
                    });
            }

            Product[] products = context.Products.Local.ToArray();
            StoreLocation[] storeLocations = context.StoreLocations.Local.ToArray();
            Customer[] customers = context.Customers.Local.ToArray();

            for (int i = 0; i < 5; i++)
            {
                context.Sales.AddOrUpdate(
                    new Sale()
                    {
                        Product = products[rnd.Next(products.Length)],
                        Customer = customers[rnd.Next(customers.Length)],
                        StoreLocation = storeLocations[rnd.Next(storeLocations.Length)],
                        Date = DateTime.Now
                    });
            }

            context.SaveChanges();
        }
    }
}
