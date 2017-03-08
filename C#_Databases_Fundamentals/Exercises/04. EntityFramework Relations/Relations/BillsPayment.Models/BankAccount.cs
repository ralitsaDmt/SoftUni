namespace BillsPayment.Models
{
    using System.ComponentModel.DataAnnotations;

    public class BankAccount
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public string BankName { get; set; }

        [Required]
        public string SwiftCode { get; set; }
    }
}
