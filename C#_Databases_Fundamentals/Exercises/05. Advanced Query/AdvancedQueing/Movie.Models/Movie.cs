namespace Movie.Models
{
    using System.Collections;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Movie
    {
        private ICollection<User> users;
        private ICollection<Raiting> raitings;

        public Movie()
        {
            this.users = new HashSet<User>();
            this.raitings = new HashSet<Raiting>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public string isbn { get; set; }

        [Required]
        [MinLength(2)]
        [MaxLength(100)]
        public string Title { get; set; }

        [Required]
        public AgeRestriction AgeRestriction { get; set; }

        public virtual ICollection<User> Users
        {
            get { return this.users; }
            set { this.users = value; }
        }

        public virtual ICollection<Raiting> Raitings
        {
            get { return this.raitings; }
            set { this.raitings = value; }
        }
    }
}
