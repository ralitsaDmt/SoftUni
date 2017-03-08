namespace UserDB.Data.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using Models;

    internal sealed class Configuration : DbMigrationsConfiguration<UserDB.Data.UserContext>
    {
        public Configuration()
        {
            this.AutomaticMigrationsEnabled = false;
            this.ContextKey = "UserDB.Data.UserContext";
        }

        protected override void Seed(UserDB.Data.UserContext context)
        {
            
                context.Users.AddOrUpdate(
                  p => p.Username,
                  new User
                  {
                      Username = "Mary",
                      Password = "123AAAaaa!@#",
                      Email = "mary@go.round",
                      RegisteredOn = new DateTime(2016, 11, 13),
                      LastTimeLoggedIn = new DateTime(2016, 11, 13),
                      Age = 29,
                      IsDelete = false
                  },
                  new User
                  {
                      Username = "Alis",
                      Password = "123AAAaaa!@#",
                      Email = "alis@gmail.com",
                      RegisteredOn = new DateTime(2016, 11, 13),
                      LastTimeLoggedIn = new DateTime(2016, 11, 13),
                      Age = 29,
                      IsDelete = false
                  },
                  new User
                  {
                      Username = "Tifany",
                      Password = "123AAAaaa!@#",
                      Email = "teefan@go.round",
                      RegisteredOn = new DateTime(2016, 11, 13),
                      LastTimeLoggedIn = new DateTime(2016, 11, 13),
                      Age = 29,
                      IsDelete = false
                  }
                );
        }
    }
}
