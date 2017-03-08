namespace Hotel.Models
{
    using System.ComponentModel.DataAnnotations;

    public class BedType
    {
        [Key]
        public int Id { get; set; }

        public string Type { get; set; }

        public string Notes { get; set; }
    }
}
