namespace Sale.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class InitialCreate : DbMigration
    {
        public override void Up()
        {
            this.DropForeignKey("dbo.Sales", "CustomerId", "dbo.Customers");
            this.DropForeignKey("dbo.Sales", "ProductId", "dbo.Products");
            this.DropForeignKey("dbo.Sales", "StoreLocationId", "dbo.StoreLocations");
            this.DropIndex("dbo.Sales", new[] { "ProductId" });
            this.DropIndex("dbo.Sales", new[] { "CustomerId" });
            this.DropIndex("dbo.Sales", new[] { "StoreLocationId" });
            this.RenameColumn(table: "dbo.Sales", name: "CustomerId", newName: "Customer_Id");
            this.RenameColumn(table: "dbo.Sales", name: "ProductId", newName: "Product_Id");
            this.RenameColumn(table: "dbo.Sales", name: "StoreLocationId", newName: "StoreLocation_Id");
            this.AlterColumn("dbo.Sales", "Product_Id", c => c.Int());
            this.AlterColumn("dbo.Sales", "Customer_Id", c => c.Int());
            this.AlterColumn("dbo.Sales", "StoreLocation_Id", c => c.Int());
            this.CreateIndex("dbo.Sales", "Customer_Id");
            this.CreateIndex("dbo.Sales", "Product_Id");
            this.CreateIndex("dbo.Sales", "StoreLocation_Id");
            this.AddForeignKey("dbo.Sales", "Customer_Id", "dbo.Customers", "Id");
            this.AddForeignKey("dbo.Sales", "Product_Id", "dbo.Products", "Id");
            this.AddForeignKey("dbo.Sales", "StoreLocation_Id", "dbo.StoreLocations", "Id");
        }
        
        public override void Down()
        {
            this.DropForeignKey("dbo.Sales", "StoreLocation_Id", "dbo.StoreLocations");
            this.DropForeignKey("dbo.Sales", "Product_Id", "dbo.Products");
            this.DropForeignKey("dbo.Sales", "Customer_Id", "dbo.Customers");
            this.DropIndex("dbo.Sales", new[] { "StoreLocation_Id" });
            this.DropIndex("dbo.Sales", new[] { "Product_Id" });
            this.DropIndex("dbo.Sales", new[] { "Customer_Id" });
            this.AlterColumn("dbo.Sales", "StoreLocation_Id", c => c.Int(nullable: false));
            this.AlterColumn("dbo.Sales", "Customer_Id", c => c.Int(nullable: false));
            this.AlterColumn("dbo.Sales", "Product_Id", c => c.Int(nullable: false));
            this.RenameColumn(table: "dbo.Sales", name: "StoreLocation_Id", newName: "StoreLocationId");
            this.RenameColumn(table: "dbo.Sales", name: "Product_Id", newName: "ProductId");
            this.RenameColumn(table: "dbo.Sales", name: "Customer_Id", newName: "CustomerId");
            this.CreateIndex("dbo.Sales", "StoreLocationId");
            this.CreateIndex("dbo.Sales", "CustomerId");
            this.CreateIndex("dbo.Sales", "ProductId");
            this.AddForeignKey("dbo.Sales", "StoreLocationId", "dbo.StoreLocations", "Id", cascadeDelete: true);
            this.AddForeignKey("dbo.Sales", "ProductId", "dbo.Products", "Id", cascadeDelete: true);
            this.AddForeignKey("dbo.Sales", "CustomerId", "dbo.Customers", "Id", cascadeDelete: true);
        }
    }
}
