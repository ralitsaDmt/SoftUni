namespace Hospital.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Doctor
    {
        private Doctor()
        {
            this.Visitations = new HashSet<Visitation>();
        }

        [Key]
        public int Id { get; set; }

        public string Name { get; set; }

        public string Specialty { get; set; }

        public virtual ICollection<Visitation> Visitations { get; set; }
    }
}
