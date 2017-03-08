namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddGameCompetitionRelation : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Games", "Competition_Id", "dbo.Competitions");
            DropIndex("dbo.Games", new[] { "Competition_Id" });
            RenameColumn(table: "dbo.Games", name: "Competition_Id", newName: "CompetitionId");
            AlterColumn("dbo.Games", "CompetitionId", c => c.Int(nullable: false));
            CreateIndex("dbo.Games", "CompetitionId");
            AddForeignKey("dbo.Games", "CompetitionId", "dbo.Competitions", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Games", "CompetitionId", "dbo.Competitions");
            DropIndex("dbo.Games", new[] { "CompetitionId" });
            AlterColumn("dbo.Games", "CompetitionId", c => c.Int());
            RenameColumn(table: "dbo.Games", name: "CompetitionId", newName: "Competition_Id");
            CreateIndex("dbo.Games", "Competition_Id");
            AddForeignKey("dbo.Games", "Competition_Id", "dbo.Competitions", "Id");
        }
    }
}
