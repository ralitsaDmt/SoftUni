namespace FootballBets.Models
{
    using System;
    using System.Collections.Generic;
    using Microsoft.Win32;

    public class Bet
    {
        public Bet()
        {
            this.Games = new HashSet<Game>();
        }

        public int Id { get; set; }

        public decimal BetMoney { get; set; }

        public DateTime BetTime { get; set; }

        public int UserId { get; set; }

        public User User { get; set; }

        public int ResultPredicionId { get; set; }

        public virtual ResultPrediction ResultPrediction { get; set; }

        public virtual ICollection<Game> Games { get; set; }
    }
}
