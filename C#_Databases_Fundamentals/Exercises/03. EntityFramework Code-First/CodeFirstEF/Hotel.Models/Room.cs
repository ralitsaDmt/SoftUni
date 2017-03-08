namespace Hotel.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Room
    {
        [Key]
        public int RoomNumber { get; set; }

        public RoomType RoomType { get; set; }

        public BedType BedType { get; set; }

        public int Rate { get; set; }

        public RoomStatus RoomStatus { get; set; }

        public string Notes { get; set; }
    }
}
