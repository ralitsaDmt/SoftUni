namespace BookShop.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddManyToManyRelationBooksCategories : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Books", "Category_Id", "dbo.Categories");
            DropIndex("dbo.Books", new[] { "Category_Id" });
            CreateTable(
                "dbo.CategoryBooks",
                c => new
                    {
                        Category_Id = c.Int(nullable: false),
                        Book_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Category_Id, t.Book_Id })
                .ForeignKey("dbo.Categories", t => t.Category_Id, cascadeDelete: true)
                .ForeignKey("dbo.Books", t => t.Book_Id, cascadeDelete: true)
                .Index(t => t.Category_Id)
                .Index(t => t.Book_Id);
            
            DropColumn("dbo.Books", "Category_Id");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Books", "Category_Id", c => c.Int());
            DropForeignKey("dbo.CategoryBooks", "Book_Id", "dbo.Books");
            DropForeignKey("dbo.CategoryBooks", "Category_Id", "dbo.Categories");
            DropIndex("dbo.CategoryBooks", new[] { "Book_Id" });
            DropIndex("dbo.CategoryBooks", new[] { "Category_Id" });
            DropTable("dbo.CategoryBooks");
            CreateIndex("dbo.Books", "Category_Id");
            AddForeignKey("dbo.Books", "Category_Id", "dbo.Categories", "Id");
        }
    }
}
