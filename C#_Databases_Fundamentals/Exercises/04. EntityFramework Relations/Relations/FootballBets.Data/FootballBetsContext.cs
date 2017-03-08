namespace FootballBets.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Models;

    public class FootballBetsContext : DbContext
    {
        public FootballBetsContext()
            : base("name=FootballBetsContext")
        {
        }

        public virtual IDbSet<User> Users { get; set; }

        public virtual IDbSet<Town> Towns { get; set; }

        public virtual IDbSet<Team> Teams { get; set; }

        public virtual IDbSet<Round> Rounds { get; set; }

        public virtual IDbSet<ResultPrediction> ResultPredictions { get; set; }

        public virtual IDbSet<Position> Positions { get; set; }

        public virtual IDbSet<PlayerStatistic> PlayerStatistics { get; set; }

        public virtual IDbSet<Player> Playerses { get; set; }

        public virtual IDbSet<Game> Games { get; set; }

        public virtual IDbSet<Country> Countries { get; set; }

        public virtual IDbSet<Continent> Continents { get; set; }

        public virtual IDbSet<CompetitionType> CompetitionTypes { get; set; }

        public virtual IDbSet<Competition> Competitions { get; set; }

        public virtual IDbSet<Color> Colors { get; set; }

        public virtual IDbSet<BetGame> BetGames { get; set; }

        public virtual IDbSet<Bet> Bets { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            // Team - Primary Kit Color
            modelBuilder.Entity<Team>()
                .HasRequired<Color>(t => t.PrimaryKitColor)
                .WithMany(t => t.PrimaryKitTeams)
                .HasForeignKey(t => t.PrimaryKitColorId);
            
            // Team - Secondary Kit Color
            modelBuilder.Entity<Team>()
                .HasRequired<Color>(t => t.SecondaryKitColor)
                .WithMany(t => t.SecondaryKitTeams)
                .HasForeignKey(t => t.SecondaryKitColorId)
                .WillCascadeOnDelete(false);

            // Game - Home Team
            modelBuilder.Entity<Game>()
                .HasRequired<Team>(g => g.HomeTeam)
                .WithMany(t => t.HomeGames)
                .HasForeignKey(g => g.HomeTeamId)
                .WillCascadeOnDelete(false);

            // Game - Away Team
            modelBuilder.Entity<Game>()
                .HasRequired<Team>(g => g.AwayTeam)
                .WithMany(t => t.AwayGames)
                .HasForeignKey(g => g.AwayTeamId)
                .WillCascadeOnDelete(false);

            // Team - Town
            modelBuilder.Entity<Team>()
                .HasRequired<Town>(t => t.Town)
                .WithMany(t => t.Teams)
                .HasForeignKey(t => t.TownId);

            // Town - Country
            modelBuilder.Entity<Town>()
                .HasRequired(t => t.Country)
                .WithMany(c => c.Towns)
                .HasForeignKey(t => t.CountryId);

            // Country - Continent
            modelBuilder.Entity<Country>()
                .HasRequired(ct => ct.Continent)
                .WithMany(cn => cn.Countries)
                .HasForeignKey(c => c.ContinentId);

            // Player - Team
            modelBuilder.Entity<Player>()
                .HasRequired(p => p.Team)
                .WithMany(t => t.Players)
                .HasForeignKey(p => p.TeamId);

            // Player - Position
            modelBuilder.Entity<Player>()
                .HasRequired(p => p.Position)
                .WithMany(p => p.Players)
                .HasForeignKey(p => p.PositionId);

            // Game - Round
            modelBuilder.Entity<Game>()
                .HasRequired(g => g.Round)
                .WithMany(r => r.Games)
                .HasForeignKey(g => g.RoundId);

            // Game - Competition
            modelBuilder.Entity<Game>()
                .HasRequired(g => g.Competition)
                .WithMany(c => c.Games)
                .HasForeignKey(g => g.CompetitionId);

            // Game - Bets => Many To Many
            modelBuilder.Entity<Game>()
                .HasMany(g => g.Bets)
                .WithMany(b => b.Games)
                .Map(m =>
                {
                    m.MapLeftKey("GameId");
                    m.MapRightKey("BetId");
                    m.ToTable("GamesBets");
                });

            // Bet - Result Predictions -> One To Many
            modelBuilder.Entity<Bet>()
                .HasRequired(b => b.ResultPrediction)
                .WithMany(rp => rp.Bets)
                .HasForeignKey(b => b.ResultPredicionId);

            // Bet - Users => One To Many
            modelBuilder.Entity<Bet>()
                .HasRequired(b => b.User)
                .WithMany(u => u.Bets)
                .HasForeignKey(b => b.UserId);
        }
    }
}