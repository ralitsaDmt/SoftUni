namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddGamesTeamsRelations : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Games", "HomeTeamId", c => c.Int(nullable: false));
            AddColumn("dbo.Games", "AwayTeamId", c => c.Int(nullable: false));
            CreateIndex("dbo.Games", "HomeTeamId");
            CreateIndex("dbo.Games", "AwayTeamId");
            AddForeignKey("dbo.Games", "AwayTeamId", "dbo.Teams", "Id");
            AddForeignKey("dbo.Games", "HomeTeamId", "dbo.Teams", "Id", cascadeDelete: false);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Games", "HomeTeamId", "dbo.Teams");
            DropForeignKey("dbo.Games", "AwayTeamId", "dbo.Teams");
            DropIndex("dbo.Games", new[] { "AwayTeamId" });
            DropIndex("dbo.Games", new[] { "HomeTeamId" });
            DropColumn("dbo.Games", "AwayTeamId");
            DropColumn("dbo.Games", "HomeTeamId");
        }
    }
}
