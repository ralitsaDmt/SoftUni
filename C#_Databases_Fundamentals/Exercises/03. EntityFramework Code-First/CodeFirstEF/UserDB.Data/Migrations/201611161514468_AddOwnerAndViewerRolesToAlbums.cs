namespace UserDB.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddOwnerAndViewerRolesToAlbums : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.UserAlbums", "User_Id", "dbo.Users");
            DropForeignKey("dbo.UserAlbums", "Album_Id", "dbo.Albums");
            DropIndex("dbo.UserAlbums", new[] { "User_Id" });
            DropIndex("dbo.UserAlbums", new[] { "Album_Id" });
            AddColumn("dbo.Albums", "OwnerId", c => c.Int(nullable: false));
            AddColumn("dbo.Albums", "User_Id", c => c.Int());
            AddColumn("dbo.Albums", "User_Id1", c => c.Int());
            AddColumn("dbo.Users", "Album_Id", c => c.Int());
            CreateIndex("dbo.Albums", "OwnerId");
            CreateIndex("dbo.Albums", "User_Id");
            CreateIndex("dbo.Albums", "User_Id1");
            CreateIndex("dbo.Users", "Album_Id");
            AddForeignKey("dbo.Albums", "User_Id", "dbo.Users", "Id");
            AddForeignKey("dbo.Albums", "User_Id1", "dbo.Users", "Id");
            AddForeignKey("dbo.Albums", "OwnerId", "dbo.Users", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Users", "Album_Id", "dbo.Albums", "Id");
            DropTable("dbo.UserAlbums");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.UserAlbums",
                c => new
                    {
                        User_Id = c.Int(nullable: false),
                        Album_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.User_Id, t.Album_Id });
            
            DropForeignKey("dbo.Users", "Album_Id", "dbo.Albums");
            DropForeignKey("dbo.Albums", "OwnerId", "dbo.Users");
            DropForeignKey("dbo.Albums", "User_Id1", "dbo.Users");
            DropForeignKey("dbo.Albums", "User_Id", "dbo.Users");
            DropIndex("dbo.Users", new[] { "Album_Id" });
            DropIndex("dbo.Albums", new[] { "User_Id1" });
            DropIndex("dbo.Albums", new[] { "User_Id" });
            DropIndex("dbo.Albums", new[] { "OwnerId" });
            DropColumn("dbo.Users", "Album_Id");
            DropColumn("dbo.Albums", "User_Id1");
            DropColumn("dbo.Albums", "User_Id");
            DropColumn("dbo.Albums", "OwnerId");
            CreateIndex("dbo.UserAlbums", "Album_Id");
            CreateIndex("dbo.UserAlbums", "User_Id");
            AddForeignKey("dbo.UserAlbums", "Album_Id", "dbo.Albums", "Id", cascadeDelete: true);
            AddForeignKey("dbo.UserAlbums", "User_Id", "dbo.Users", "Id", cascadeDelete: true);
        }
    }
}
