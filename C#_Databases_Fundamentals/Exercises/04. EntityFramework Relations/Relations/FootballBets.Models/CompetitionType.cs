namespace FootballBets.Models
{
    using System.Collections.Generic;

    public class CompetitionType
    {
        public CompetitionType()
        {
            this.Competitions = new HashSet<Competition>();
        }

        public int Id { get; set; }

        public string Name { get; set; }

        public virtual ICollection<Competition> Competitions { get; set; }

    }
}
