namespace BookShop.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddAgeRestrictions : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Books", "AgeRestriction", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Books", "AgeRestriction");
        }
    }
}
