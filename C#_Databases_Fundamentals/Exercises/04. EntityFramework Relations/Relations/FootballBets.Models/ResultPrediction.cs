namespace FootballBets.Models
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class ResultPrediction
    {
        private string prediction;

        public ResultPrediction()
        {
            this.Bets = new HashSet<Bet>();
        }

        public int Id { get; set; }

        public string Prediction
        {
            get { return this.prediction; }
            set
            {
                string[] validPredictions = new string[] {"Home Team Win", "Draw Game", "Away Team Win"};

                if (validPredictions.Contains(value))
                {
                    this.prediction = value;
                }
                throw new ArgumentException("Invalid prediction.");
            }
        }

        public virtual ICollection<Bet> Bets { get; set; }
    }
}
