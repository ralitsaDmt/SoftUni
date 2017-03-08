namespace Movie.Models
{
    using System.Collections;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class User
    {
        private ICollection<Movie> movies;
        private ICollection<Raiting> raitings;

        public User()
        {
            this.movies = new HashSet<Movie>();
            this.raitings = new HashSet<Raiting>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        [MinLength(5)]
        public string Username { get; set; }

        public string Email { get; set; }

        public int? Age { get; set; }

        public virtual Country Country { get; set; }

        public virtual ICollection<Movie> Movies
        {
            get { return this.movies; }
            set { this.movies = value; }
        }

        public virtual ICollection<Raiting> Raitings
        {
            get { return this.raitings; }
            set { this.raitings = value; }
        }
    }
}
