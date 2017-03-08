
using System;
using System.ComponentModel.DataAnnotations;

namespace UserDB.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations.Schema;
    using Attibutes;

    public class User
    {
        public User()
        {
            this.Friends = new HashSet<User>();
            this.Albums_Viewer = new HashSet<Album>();
            this.Albums_Owner = new HashSet<Album>();
            this.Tags = new HashSet<Tag>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        [MinLength(4)]
        [MaxLength(30)]
        public string Username { get; set; }

        public string FirstName { get; set; }

        public string LastName { get; set; }

        [NotMapped]
        public string FullName => this.FirstName + " " + this.LastName;

        [Required]
        [MinLength(6)]
        [MaxLength(50)]
        [PasswordValidation(6, 50, 
            ShouldContainDigit = true, 
            ShouldContainLowerCase = true, 
            ShouldContainSpecialSymbol = true, 
            ShouldContainUpperCase = true)]
        public string Password { get; set; }

        [Required]
        [Email]
        public string Email { get; set; }

        [MaxLength(1024 * 1024)]
        public byte[] ProfilePicture { get; set; }

        public DateTime RegisteredOn { get; set; }

        public DateTime LastTimeLoggedIn { get; set; }

        [Range(1,120)]
        public int Age { get; set; }

        public bool IsDelete { get; set; }

        public Town BirthTown { get; set; }

        public Town LivingTown { get; set; }

        public virtual ICollection<User> Friends { get; set; }

        public virtual ICollection<Album> AlbumsViewer { get; set; }

        public virtual ICollection<Album> AlbumsOwner
        { get; set; }

        public virtual ICollection<Tag> Tags { get; set; }
    }
}
