namespace UserDB.ConsoleClient
{
    using System;
    using System.Collections.Generic;
    using System.Diagnostics;
    using System.Globalization;
    using System.Linq;
    using Data;
    using Models;
    using static Models.TagTransformer;

    public class Program
    {
        public static void Main(string[] args)
        {
            UserContext context = new UserContext();

            //GetUsersByEmailProvider(context);

            //DeleteIncativeUsers(context);

            InsertTags(context);
        }

        private static void InsertTags(UserContext context)
        {
            string newTag = TagTransformer.Transform(Console.ReadLine());
               Tag tag = new Tag() {Name = newTag};

            try
            {
                context.Tags.Add(tag);
                context.SaveChanges();
                Console.WriteLine($"{tag.Name} was added to the database.");
            }
            catch (Exception ex)
            {
                throw new ArgumentException("Tag not valid.");
            }
        }

        private static void DeleteIncativeUsers(UserContext context)
        {
            string dateString = Console.ReadLine();
            DateTime date;
            DateTime.TryParseExact(dateString, "dd MMM yyyy", CultureInfo.InvariantCulture, DateTimeStyles.AllowWhiteSpaces, out date);

            List<User> users = context.Users
                .Where(u => u.LastTimeLoggedIn < date && !u.IsDelete)
                .ToList();

            foreach (User user in users)
            {
                user.IsDelete = true;
            }

            int count = users.Count;
            Console.WriteLine($"{count} users have been deleted");

            foreach (User user in users)
            {
                context.Users.Remove(user);
            }
            context.SaveChanges();
        }

        private static void GetUsersByEmailProvider(UserContext context)
        {
            string provider = Console.ReadLine();

            var users = context.Users.Select(u => u);

            List<User> validUsers = new List<User>();
            foreach (var user in users)
            {
                string email = user.Email;

                string userProvider = email.Split('@')[1];

                if (userProvider.Equals(provider))
                {
                    validUsers.Add(user);
                }
            }

            foreach (User user in validUsers)
            {
                Console.WriteLine($"{user.Username} {user.Email}");
            }

        }
    }
}
