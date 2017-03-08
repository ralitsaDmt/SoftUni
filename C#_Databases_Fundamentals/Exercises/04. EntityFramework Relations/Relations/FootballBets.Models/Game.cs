namespace FootballBets.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Game
    {
        public Game()
        {
            this.Bets = new HashSet<Bet>();
            this.Players = new List<Player>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public int HomeTeamId { get; set; }
        
        public Team HomeTeam { get; set; }

        [Required]
        public int AwayTeamId { get; set; }
        
        public Team AwayTeam { get; set; }

        [Required]
        public int HomeGoals { get; set; }

        [Required]
        public int AwayGoals { get; set; }

        [Required]
        public DateTime DateTime { get; set; }

        [Required]
        public double HomeBetRate { get; set; }

        [Required]
        public double AwayBetRate { get; set; }

        [Required]
        public double DrawBetRate { get; set; }

        public int RoundId { get; set; }

        [Required]
        public Round Round { get; set; }

        public int CompetitionId { get; set; }

        public Competition Competition { get; set; }

        public virtual ICollection<Player> Players { get; set; }

        public virtual ICollection<Bet> Bets { get; set; }
    }
}
