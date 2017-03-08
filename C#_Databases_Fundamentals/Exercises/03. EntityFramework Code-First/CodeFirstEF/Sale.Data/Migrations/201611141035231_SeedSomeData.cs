namespace Sale.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class SeedSomeData : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Sales", "CustomerId", "dbo.Customers");
            DropForeignKey("dbo.Sales", "ProductId", "dbo.Products");
            DropForeignKey("dbo.Sales", "StoreLocationId", "dbo.StoreLocations");
            DropIndex("dbo.Sales", new[] { "ProductId" });
            DropIndex("dbo.Sales", new[] { "CustomerId" });
            DropIndex("dbo.Sales", new[] { "StoreLocationId" });
            RenameColumn(table: "dbo.Sales", name: "CustomerId", newName: "Customer_Id");
            RenameColumn(table: "dbo.Sales", name: "ProductId", newName: "Product_Id");
            RenameColumn(table: "dbo.Sales", name: "StoreLocationId", newName: "StoreLocation_Id");
            AlterColumn("dbo.Sales", "Product_Id", c => c.Int());
            AlterColumn("dbo.Sales", "Customer_Id", c => c.Int());
            AlterColumn("dbo.Sales", "StoreLocation_Id", c => c.Int());
            CreateIndex("dbo.Sales", "Customer_Id");
            CreateIndex("dbo.Sales", "Product_Id");
            CreateIndex("dbo.Sales", "StoreLocation_Id");
            AddForeignKey("dbo.Sales", "Customer_Id", "dbo.Customers", "Id");
            AddForeignKey("dbo.Sales", "Product_Id", "dbo.Products", "Id");
            AddForeignKey("dbo.Sales", "StoreLocation_Id", "dbo.StoreLocations", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Sales", "StoreLocation_Id", "dbo.StoreLocations");
            DropForeignKey("dbo.Sales", "Product_Id", "dbo.Products");
            DropForeignKey("dbo.Sales", "Customer_Id", "dbo.Customers");
            DropIndex("dbo.Sales", new[] { "StoreLocation_Id" });
            DropIndex("dbo.Sales", new[] { "Product_Id" });
            DropIndex("dbo.Sales", new[] { "Customer_Id" });
            AlterColumn("dbo.Sales", "StoreLocation_Id", c => c.Int(nullable: false));
            AlterColumn("dbo.Sales", "Customer_Id", c => c.Int(nullable: false));
            AlterColumn("dbo.Sales", "Product_Id", c => c.Int(nullable: false));
            RenameColumn(table: "dbo.Sales", name: "StoreLocation_Id", newName: "StoreLocationId");
            RenameColumn(table: "dbo.Sales", name: "Product_Id", newName: "ProductId");
            RenameColumn(table: "dbo.Sales", name: "Customer_Id", newName: "CustomerId");
            CreateIndex("dbo.Sales", "StoreLocationId");
            CreateIndex("dbo.Sales", "CustomerId");
            CreateIndex("dbo.Sales", "ProductId");
            AddForeignKey("dbo.Sales", "StoreLocationId", "dbo.StoreLocations", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Sales", "ProductId", "dbo.Products", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Sales", "CustomerId", "dbo.Customers", "Id", cascadeDelete: true);
        }
    }
}
