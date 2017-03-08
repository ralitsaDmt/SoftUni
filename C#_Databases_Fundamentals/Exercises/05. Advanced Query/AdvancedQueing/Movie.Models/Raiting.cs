namespace Movie.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Raiting
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [Range(0,10)]
        public int Rate { get; set; }

        public virtual Movie Movie { get; set; }

        public virtual User User { get; set; }
    }
}
