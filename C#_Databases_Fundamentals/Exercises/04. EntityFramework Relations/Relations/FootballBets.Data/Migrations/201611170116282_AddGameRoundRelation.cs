namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddGameRoundRelation : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Games", name: "Round_Id", newName: "RoundId");
            RenameIndex(table: "dbo.Games", name: "IX_Round_Id", newName: "IX_RoundId");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.Games", name: "IX_RoundId", newName: "IX_Round_Id");
            RenameColumn(table: "dbo.Games", name: "RoundId", newName: "Round_Id");
        }
    }
}
