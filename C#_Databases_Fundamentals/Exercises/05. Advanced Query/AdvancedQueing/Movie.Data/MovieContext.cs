namespace Movie.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Models;

    public class MovieContext : DbContext
    {
        public MovieContext()
            : base("name=MovieContext")
        {
        }

        public virtual IDbSet<User> Users { get; set; }

        public virtual IDbSet<Country> Countries { get; set; }

        public virtual IDbSet<Movie> Movies { get; set; }

        public virtual IDbSet<Raiting> Raitings { get; set; }


    }
}