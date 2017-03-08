namespace UserDB.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddTagsWithTheirRelations : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Tags",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false),
                        Album_Id = c.Int(),
                        User_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Albums", t => t.Album_Id)
                .ForeignKey("dbo.Users", t => t.User_Id)
                .Index(t => t.Album_Id)
                .Index(t => t.User_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Tags", "User_Id", "dbo.Users");
            DropForeignKey("dbo.Tags", "Album_Id", "dbo.Albums");
            DropIndex("dbo.Tags", new[] { "User_Id" });
            DropIndex("dbo.Tags", new[] { "Album_Id" });
            DropTable("dbo.Tags");
        }
    }
}
