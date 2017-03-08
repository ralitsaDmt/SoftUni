namespace StudentSystem.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Resource
    {
        public Resource()
        {
            this.Licenses = new HashSet<License>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public ResourceType RecType
        { get; set; }

        [Required]
        public string URL { get; set; }

        public virtual ICollection<License> Licenses { get; set; }
    }
}
