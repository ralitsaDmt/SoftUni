namespace Movie.ConsoleClient
{
    using System;
    using System.IO;
    using System.Linq;
    using System.Linq.Expressions;
    using System.Net.Sockets;
    using Data;
    using Models;
    using Newtonsoft.Json;

    public class Program
    {
        public static void Main()
        {
            MovieContext context = new MovieContext();;

            context.Database.Initialize(true);

            //AdultMovies(context);

//            string username = Console.ReadLine();
//            RatedMoviesByUser(context, username);
        }

        private static void RatedMoviesByUser(MovieContext context, string username)
        {
            var ratedMovies = context.Users
                .Where(u => u.Username == username)
                .Select(u => new
                {
                    username = username,
                    ratedMovies = u.Raitings
                        .OrderBy(r => r.Movie.Title)
                        .Select(r => new
                        {
                            title = r.Movie.Title,
                            userRating = r.Rate,
                            averageRating = r.Movie.Raitings
                                .Average(mr => mr.Rate)
                        })
                });

            var json = JsonConvert.SerializeObject(ratedMovies, Formatting.Indented);
            File.WriteAllText(@"D:\DB Fundamentals\Databases Advanced - Entity Framework\Exercises\05. Advanced Query\results\rated-movies.json", json);

        }

        private static void AdultMovies(MovieContext context)
        {
            var adultMovies = context.Movies
                .Where(m => m.AgeRestriction == AgeRestriction.Adult)
                .OrderBy(m => m.Title)
                .ThenBy(m => m.Raitings.Count())
                .Select(m => new
                {
                    title = m.Title,
                    ratingsGiven = m.Raitings.Count()
                });

            var json = JsonConvert.SerializeObject(adultMovies, Formatting.Indented);
            File.WriteAllText(@"D:\DB Fundamentals\Databases Advanced - Entity Framework\Exercises\05. Advanced Query\results\adult-movies.json", json);

            Console.WriteLine("Data successfuly exported.");
        }
    }
}
