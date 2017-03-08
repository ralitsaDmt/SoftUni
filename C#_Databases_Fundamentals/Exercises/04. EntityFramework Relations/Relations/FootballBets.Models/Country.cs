namespace FootballBets.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Country
    {
        public Country()
        {
            this.Towns = new HashSet<Town>();
        }

        [Key]
        [RegularExpression("[A-Z]{3}")]
        public string Id { get; set; }

        [Required]
        public string Name { get; set; }

        public int ContinentId { get; set; }

        [Required]
        public Continent Continent { get; set; }

        public virtual ICollection<Town> Towns { get; set; }
    }
}
