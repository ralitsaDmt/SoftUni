namespace WizardDeposits.Data.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using WizardDeposits.Data;
    using WizardDeposits.Models;

    internal sealed class Configuration : DbMigrationsConfiguration<WizardDepositsContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
            ContextKey = "WizardDeposits.Data.WizardDepositsContext";
        }

        protected override void Seed(WizardDepositsContext context)
        {
            context.Deposits.AddOrUpdate(
              d => d.FirstName,
              new WizardDeposits {
                  FirstName = "Albus",
                  LastName = "Dumbledore",
                  Age = 150,
                  MagicWandCreator = "Antioch Peverel",
                  MagicWandSize = 15,
                  DepositStartDate = new DateTime(2016, 10, 20),
                  DepositExpirationDate = new DateTime(2020, 10, 20),
                  DepositAmount = 2000.24m,
                  DepositCharge = 0.2m,
                  IsDepositExpired = false
              }
            );
        }
    }
}
