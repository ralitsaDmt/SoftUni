namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class InitialCreate : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.BetGames",
                c => new
                    {
                        GameId = c.Int(nullable: false),
                        BetId = c.Int(nullable: false),
                        ResultPrediction_Id = c.Int(),
                    })
                .PrimaryKey(t => new { t.GameId, t.BetId })
                .ForeignKey("dbo.Bets", t => t.BetId, cascadeDelete: true)
                .ForeignKey("dbo.Games", t => t.GameId, cascadeDelete: true)
                .ForeignKey("dbo.ResultPredictions", t => t.ResultPrediction_Id)
                .Index(t => t.GameId)
                .Index(t => t.BetId)
                .Index(t => t.ResultPrediction_Id);
            
            CreateTable(
                "dbo.Bets",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        BetMoney = c.Decimal(nullable: false, precision: 18, scale: 2),
                        BetTime = c.DateTime(nullable: false),
                        User_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Users", t => t.User_Id)
                .Index(t => t.User_Id);
            
            CreateTable(
                "dbo.Users",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(),
                        Password = c.String(),
                        Email = c.String(),
                        FullName = c.String(),
                        Balance = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Games",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        HomeGoals = c.Int(nullable: false),
                        AwayGoals = c.Int(nullable: false),
                        DateTime = c.DateTime(nullable: false),
                        HomeBetRate = c.Double(nullable: false),
                        AwayBetRate = c.Double(nullable: false),
                        DrawBetRate = c.Double(nullable: false),
                        Competition_Id = c.Int(),
                        Round_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Competitions", t => t.Competition_Id)
                .ForeignKey("dbo.Rounds", t => t.Round_Id, cascadeDelete: true)
                .Index(t => t.Competition_Id)
                .Index(t => t.Round_Id);
            
            CreateTable(
                "dbo.Competitions",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(),
                        CompetitionType_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.CompetitionTypes", t => t.CompetitionType_Id)
                .Index(t => t.CompetitionType_Id);
            
            CreateTable(
                "dbo.CompetitionTypes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Players",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false),
                        SquadNumber = c.Int(nullable: false),
                        TeamId = c.Int(nullable: false),
                        PositionId = c.String(nullable: false, maxLength: 128),
                        Type = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Positions", t => t.PositionId, cascadeDelete: true)
                .ForeignKey("dbo.Teams", t => t.TeamId, cascadeDelete: true)
                .Index(t => t.TeamId)
                .Index(t => t.PositionId);
            
            CreateTable(
                "dbo.Positions",
                c => new
                    {
                        Id = c.String(nullable: false, maxLength: 128),
                        PositionDescription = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Teams",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false),
                        Logo = c.String(nullable: false),
                        PrimaryKitColorId = c.Int(nullable: false),
                        SecondaryKitColorId = c.Int(nullable: false),
                        TownId = c.Int(nullable: false),
                        Budget = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Colors", t => t.PrimaryKitColorId, cascadeDelete: true)
                .ForeignKey("dbo.Colors", t => t.SecondaryKitColorId)
                .ForeignKey("dbo.Towns", t => t.TownId, cascadeDelete: true)
                .Index(t => t.PrimaryKitColorId)
                .Index(t => t.SecondaryKitColorId)
                .Index(t => t.TownId);
            
            CreateTable(
                "dbo.Colors",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Towns",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false),
                        CountryId = c.String(nullable: false, maxLength: 128),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Countries", t => t.CountryId, cascadeDelete: true)
                .Index(t => t.CountryId);
            
            CreateTable(
                "dbo.Countries",
                c => new
                    {
                        Id = c.String(nullable: false, maxLength: 128),
                        Name = c.String(nullable: false),
                        ContinentId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Continents", t => t.ContinentId, cascadeDelete: true)
                .Index(t => t.ContinentId);
            
            CreateTable(
                "dbo.Continents",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Rounds",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.ResultPredictions",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Prediction = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PlayerStatistics",
                c => new
                    {
                        GameId = c.Int(nullable: false),
                        PlayerId = c.Int(nullable: false),
                        ScoredGoals = c.Int(nullable: false),
                        PlayerAssists = c.Int(nullable: false),
                        PlayerMinutesDuringGame = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.GameId, t.PlayerId })
                .ForeignKey("dbo.Games", t => t.GameId, cascadeDelete: true)
                .ForeignKey("dbo.Players", t => t.PlayerId, cascadeDelete: true)
                .Index(t => t.GameId)
                .Index(t => t.PlayerId);
            
            CreateTable(
                "dbo.PlayerGames",
                c => new
                    {
                        Player_Id = c.Int(nullable: false),
                        Game_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Player_Id, t.Game_Id })
                .ForeignKey("dbo.Players", t => t.Player_Id, cascadeDelete: true)
                .ForeignKey("dbo.Games", t => t.Game_Id, cascadeDelete: true)
                .Index(t => t.Player_Id)
                .Index(t => t.Game_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.PlayerStatistics", "PlayerId", "dbo.Players");
            DropForeignKey("dbo.PlayerStatistics", "GameId", "dbo.Games");
            DropForeignKey("dbo.BetGames", "ResultPrediction_Id", "dbo.ResultPredictions");
            DropForeignKey("dbo.BetGames", "GameId", "dbo.Games");
            DropForeignKey("dbo.Games", "Round_Id", "dbo.Rounds");
            DropForeignKey("dbo.Players", "TeamId", "dbo.Teams");
            DropForeignKey("dbo.Teams", "TownId", "dbo.Towns");
            DropForeignKey("dbo.Towns", "CountryId", "dbo.Countries");
            DropForeignKey("dbo.Countries", "ContinentId", "dbo.Continents");
            DropForeignKey("dbo.Teams", "SecondaryKitColorId", "dbo.Colors");
            DropForeignKey("dbo.Teams", "PrimaryKitColorId", "dbo.Colors");
            DropForeignKey("dbo.Players", "PositionId", "dbo.Positions");
            DropForeignKey("dbo.PlayerGames", "Game_Id", "dbo.Games");
            DropForeignKey("dbo.PlayerGames", "Player_Id", "dbo.Players");
            DropForeignKey("dbo.Games", "Competition_Id", "dbo.Competitions");
            DropForeignKey("dbo.Competitions", "CompetitionType_Id", "dbo.CompetitionTypes");
            DropForeignKey("dbo.BetGames", "BetId", "dbo.Bets");
            DropForeignKey("dbo.Bets", "User_Id", "dbo.Users");
            DropIndex("dbo.PlayerGames", new[] { "Game_Id" });
            DropIndex("dbo.PlayerGames", new[] { "Player_Id" });
            DropIndex("dbo.PlayerStatistics", new[] { "PlayerId" });
            DropIndex("dbo.PlayerStatistics", new[] { "GameId" });
            DropIndex("dbo.Countries", new[] { "ContinentId" });
            DropIndex("dbo.Towns", new[] { "CountryId" });
            DropIndex("dbo.Teams", new[] { "TownId" });
            DropIndex("dbo.Teams", new[] { "SecondaryKitColorId" });
            DropIndex("dbo.Teams", new[] { "PrimaryKitColorId" });
            DropIndex("dbo.Players", new[] { "PositionId" });
            DropIndex("dbo.Players", new[] { "TeamId" });
            DropIndex("dbo.Competitions", new[] { "CompetitionType_Id" });
            DropIndex("dbo.Games", new[] { "Round_Id" });
            DropIndex("dbo.Games", new[] { "Competition_Id" });
            DropIndex("dbo.Bets", new[] { "User_Id" });
            DropIndex("dbo.BetGames", new[] { "ResultPrediction_Id" });
            DropIndex("dbo.BetGames", new[] { "BetId" });
            DropIndex("dbo.BetGames", new[] { "GameId" });
            DropTable("dbo.PlayerGames");
            DropTable("dbo.PlayerStatistics");
            DropTable("dbo.ResultPredictions");
            DropTable("dbo.Rounds");
            DropTable("dbo.Continents");
            DropTable("dbo.Countries");
            DropTable("dbo.Towns");
            DropTable("dbo.Colors");
            DropTable("dbo.Teams");
            DropTable("dbo.Positions");
            DropTable("dbo.Players");
            DropTable("dbo.CompetitionTypes");
            DropTable("dbo.Competitions");
            DropTable("dbo.Games");
            DropTable("dbo.Users");
            DropTable("dbo.Bets");
            DropTable("dbo.BetGames");
        }
    }
}
