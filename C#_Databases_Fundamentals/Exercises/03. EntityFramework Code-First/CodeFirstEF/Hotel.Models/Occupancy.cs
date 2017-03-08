namespace Hotel.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class Occupancy
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public DateTime DateOccupied { get; set; }

        [Required]
        public string AccountNumber { get; set; }

        [Required]
        public int RoomNumber { get; set; }

        public int RateApplied { get; set; }

        public decimal PhoneCharge { get; set; }

        public string Notes { get; set; }
    }
}
