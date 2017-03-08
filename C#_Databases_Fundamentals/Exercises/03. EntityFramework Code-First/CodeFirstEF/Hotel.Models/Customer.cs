namespace Hotel.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Customer
    {
        [Key]
        public string AccountNumber { get; set; }

        [Required]
        [MaxLength(50)]
        public string FirstName { get; set; }

        [Required]
        [MaxLength(50)]
        public string LastName { get; set; }

        public string PhoneNumber { get; set; }

        public string EmergencyName { get; set; }

        public string EmergencyNumber { get; set; }

        public string Notes { get; set; }
    }
}
