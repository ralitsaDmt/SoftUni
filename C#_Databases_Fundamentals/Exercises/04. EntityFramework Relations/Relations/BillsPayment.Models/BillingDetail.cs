namespace BillsPayment.Models
{
    using System.ComponentModel.DataAnnotations;

    public class BillingDetail
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public CreditCard CreditCard { get; set; }

        [Required]
        public BankAccount BankAccount { get; set; }
    }
}
