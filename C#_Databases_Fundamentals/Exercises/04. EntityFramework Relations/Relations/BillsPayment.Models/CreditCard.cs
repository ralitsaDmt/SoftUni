namespace BillsPayment.Models
{
    using System.ComponentModel.DataAnnotations;

    public class CreditCard
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public string CardType { get; set; }

        [Required]
        public int ExpirationMonth { get; set; }

        [Required]
        public int ExpirationYear { get; set; }
    }
}
