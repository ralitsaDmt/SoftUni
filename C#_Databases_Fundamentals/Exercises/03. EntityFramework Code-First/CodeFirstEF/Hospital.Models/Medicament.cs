namespace Hospital.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Medicament
    {
        [Key]
        public int Id { get; set; }

        public string Name { get; set; }
    }
}
