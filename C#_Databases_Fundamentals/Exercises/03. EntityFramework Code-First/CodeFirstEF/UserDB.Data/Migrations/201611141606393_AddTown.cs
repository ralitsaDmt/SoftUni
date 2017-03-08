namespace UserDB.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddTown : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Towns",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false),
                        Country = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Users", "BirthTown_Id", c => c.Int());
            AddColumn("dbo.Users", "LivingTown_Id", c => c.Int());
            CreateIndex("dbo.Users", "BirthTown_Id");
            CreateIndex("dbo.Users", "LivingTown_Id");
            AddForeignKey("dbo.Users", "BirthTown_Id", "dbo.Towns", "Id");
            AddForeignKey("dbo.Users", "LivingTown_Id", "dbo.Towns", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Users", "LivingTown_Id", "dbo.Towns");
            DropForeignKey("dbo.Users", "BirthTown_Id", "dbo.Towns");
            DropIndex("dbo.Users", new[] { "LivingTown_Id" });
            DropIndex("dbo.Users", new[] { "BirthTown_Id" });
            DropColumn("dbo.Users", "LivingTown_Id");
            DropColumn("dbo.Users", "BirthTown_Id");
            DropTable("dbo.Towns");
        }
    }
}
