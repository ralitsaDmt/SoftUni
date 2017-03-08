namespace Sale.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Models;

    public class SalesContext : DbContext
    {
        public SalesContext()
            : base("name=SalesContext")
        {
        }

        public virtual IDbSet<Product> Products { get; set; }

        public virtual IDbSet<Customer> Customers { get; set; }

        public IDbSet<StoreLocation> StoreLocations { get; set; }

        public virtual IDbSet<Sale> Sales { get; set; }
    }
}