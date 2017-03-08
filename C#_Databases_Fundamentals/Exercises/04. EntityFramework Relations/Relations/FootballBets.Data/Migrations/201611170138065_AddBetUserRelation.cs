namespace FootballBets.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddBetUserRelation : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Bets", "User_Id", "dbo.Users");
            DropIndex("dbo.Bets", new[] { "User_Id" });
            RenameColumn(table: "dbo.Bets", name: "User_Id", newName: "UserId");
            AlterColumn("dbo.Bets", "UserId", c => c.Int(nullable: false));
            CreateIndex("dbo.Bets", "UserId");
            AddForeignKey("dbo.Bets", "UserId", "dbo.Users", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Bets", "UserId", "dbo.Users");
            DropIndex("dbo.Bets", new[] { "UserId" });
            AlterColumn("dbo.Bets", "UserId", c => c.Int());
            RenameColumn(table: "dbo.Bets", name: "UserId", newName: "User_Id");
            CreateIndex("dbo.Bets", "User_Id");
            AddForeignKey("dbo.Bets", "User_Id", "dbo.Users", "Id");
        }
    }
}
