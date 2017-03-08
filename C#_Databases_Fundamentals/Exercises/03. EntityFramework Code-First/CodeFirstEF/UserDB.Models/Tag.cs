namespace UserDB.Models
{
    using Attibutes;
    using System.ComponentModel.DataAnnotations;

    public class Tag
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [Tag]
        public string Name { get; set; }
    }
}
