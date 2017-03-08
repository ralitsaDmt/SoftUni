namespace Movie.ConsoleClient.ImportModels
{
    using System.Collections.Generic;

    public class ImportUserMovie
    {
        public string Username { get; set; }

        public IEnumerable<string> FavouriteMovies { get; set; }
    }
}
