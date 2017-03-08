namespace WizardDeposits.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using WizardDeposits.Models;

    public class WizardDepositsContext : DbContext
    {
        public WizardDepositsContext()
            : base("name=WizardDepositsContext")
        {
        }

        public IDbSet<WizardDeposits> Deposits { get; set; }
    }
}