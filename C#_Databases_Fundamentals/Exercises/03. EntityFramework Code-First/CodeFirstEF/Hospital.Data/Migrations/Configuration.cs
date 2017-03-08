namespace Hospital.Data.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<Hospital.Data.HospitalContext>
    {
        public Configuration()
        {
            this.AutomaticMigrationsEnabled = true;
            this.ContextKey = "Hospital.Data.HospitalContext";
        }

        protected override void Seed(HospitalContext context)
        {
        }
    }
}
