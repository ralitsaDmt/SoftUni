namespace StudentSystem.Models
{
    using System.ComponentModel.DataAnnotations;

    public class License
    {
        [Key]
        public int Id  { get; set; }

        [Required]
        public string Name { get; set; }
    }
}
