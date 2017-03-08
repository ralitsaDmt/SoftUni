namespace Hotel.Models
{
    using System.ComponentModel.DataAnnotations;

    public class RoomStatus
    {
        [Key]
        public int Id { get; set; }

        public string Status { get; set; }

        public string Notes { get; set; }
    }
}
