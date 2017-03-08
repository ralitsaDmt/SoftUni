namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddResultPredictionBetsRelation : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Bets", "ResultPredicionId", c => c.Int(nullable: false));
            CreateIndex("dbo.Bets", "ResultPredicionId");
            AddForeignKey("dbo.Bets", "ResultPredicionId", "dbo.ResultPredictions", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Bets", "ResultPredicionId", "dbo.ResultPredictions");
            DropIndex("dbo.Bets", new[] { "ResultPredicionId" });
            DropColumn("dbo.Bets", "ResultPredicionId");
        }
    }
}
