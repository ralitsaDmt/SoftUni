namespace BillsPayment.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Microsoft.Win32;
    using Models;

    public class BillsPaymentContext : DbContext
    {
        
        public BillsPaymentContext()
            : base("name=BillsPaymentContext")
        {
        }

        public virtual IDbSet<User> Users { get; set; }

        public virtual IDbSet<BillingDetail> BillingDetails { get; set; }

        public virtual IDbSet<CreditCard> CreditCards { get; set; }

        public virtual IDbSet<BankAccount> BankAccounts { get; set; }

    }
    
}