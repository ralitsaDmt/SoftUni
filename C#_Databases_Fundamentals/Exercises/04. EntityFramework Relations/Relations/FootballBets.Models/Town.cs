namespace FootballBets.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Town
    {
        public Town()
        {
            this.Teams = new HashSet<Team>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [RegularExpression("[A-Z]{3}")]
        public string CountryId { get; set; }

        [Required]
        public Country Country { get; set; }

        public virtual ICollection<Team> Teams { get; set; }
    }
}
