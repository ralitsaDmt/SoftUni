namespace StudentSystem.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class MakeBithdateNullable : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Students", "BirthDate", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Students", "BirthDate", c => c.DateTime(nullable: false));
        }
    }
}
