namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddGamesBetsRelation : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.GamesBets",
                c => new
                    {
                        GameId = c.Int(nullable: false),
                        BetId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.GameId, t.BetId })
                .ForeignKey("dbo.Games", t => t.GameId, cascadeDelete: true)
                .ForeignKey("dbo.Bets", t => t.BetId, cascadeDelete: true)
                .Index(t => t.GameId)
                .Index(t => t.BetId);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.GamesBets", "BetId", "dbo.Bets");
            DropForeignKey("dbo.GamesBets", "GameId", "dbo.Games");
            DropIndex("dbo.GamesBets", new[] { "BetId" });
            DropIndex("dbo.GamesBets", new[] { "GameId" });
            DropTable("dbo.GamesBets");
        }
    }
}
