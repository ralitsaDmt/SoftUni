namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddCompetitionCompetitionTypeRelation : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Competitions", "CompetitionType_Id", "dbo.CompetitionTypes");
            DropIndex("dbo.Competitions", new[] { "CompetitionType_Id" });
            RenameColumn(table: "dbo.Competitions", name: "CompetitionType_Id", newName: "CompetitionTypeId");
            AlterColumn("dbo.Competitions", "CompetitionTypeId", c => c.Int(nullable: false));
            CreateIndex("dbo.Competitions", "CompetitionTypeId");
            AddForeignKey("dbo.Competitions", "CompetitionTypeId", "dbo.CompetitionTypes", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Competitions", "CompetitionTypeId", "dbo.CompetitionTypes");
            DropIndex("dbo.Competitions", new[] { "CompetitionTypeId" });
            AlterColumn("dbo.Competitions", "CompetitionTypeId", c => c.Int());
            RenameColumn(table: "dbo.Competitions", name: "CompetitionTypeId", newName: "CompetitionType_Id");
            CreateIndex("dbo.Competitions", "CompetitionType_Id");
            AddForeignKey("dbo.Competitions", "CompetitionType_Id", "dbo.CompetitionTypes", "Id");
        }
    }
}
