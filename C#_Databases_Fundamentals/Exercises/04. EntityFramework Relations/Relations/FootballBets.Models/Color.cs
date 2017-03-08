namespace FootballBets.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Color
    {
        private ICollection<Team> primaryKitTeams;
        private ICollection<Team> secondaryKitTeams;

        public Color()
        {
            this.primaryKitTeams = new HashSet<Team>();
            this.secondaryKitTeams = new HashSet<Team>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        public virtual ICollection<Team> PrimaryKitTeams
        {
            get { return this.primaryKitTeams; }
            set { this.primaryKitTeams = value; }
        }

        public virtual ICollection<Team> SecondaryKitTeams
        {
            get { return this.secondaryKitTeams; }
            set { this.secondaryKitTeams = value; }
        }
    }
}
