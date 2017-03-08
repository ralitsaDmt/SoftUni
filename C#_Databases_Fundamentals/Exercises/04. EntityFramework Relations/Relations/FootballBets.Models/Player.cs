namespace FootballBets.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Player
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public int SquadNumber { get; set; }

        public int TeamId { get; set; }

        [Required]
        public Team Team { get; set; }

        [RegularExpression("[A-Z]{2}")]
        public string PositionId { get; set; }

        [Required]
        public Position Position { get; set; }

        [Required]
        public bool Type { get; set; }

        public virtual ICollection<Game> Games { get; set; }
    }
}
