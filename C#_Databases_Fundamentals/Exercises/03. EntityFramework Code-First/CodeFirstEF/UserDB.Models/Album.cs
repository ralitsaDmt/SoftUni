namespace UserDB.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Album
    {
        private ICollection<Picture> pictures;
        private ICollection<Tag> tags;
        private ICollection<User> viewers;

        public Album()
        {
            this.pictures = new HashSet<Picture>();
            this.tags = new HashSet<Tag>();
            this.viewers = new HashSet<User>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public BackgroundColor BackgroundColor { get; set; }

        [Required]
        public bool IsPublic { get; set; }

        public virtual ICollection<Picture> Pictures { get; set; }

        public virtual ICollection<Tag> Tags { get; set; }

        public virtual ICollection<User> Viewers { get; set; }

        public int OwnerId { get; set; }

        [ForeignKey("OwnerId")]
        public virtual User Owner { get; set; }
    }
}
