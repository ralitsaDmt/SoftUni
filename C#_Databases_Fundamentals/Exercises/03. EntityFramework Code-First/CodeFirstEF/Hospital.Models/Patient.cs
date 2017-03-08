namespace Hospital.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public class Patient
    {
        private Patient()
        {
            this.Diagnoses = new HashSet<Diagnose>();

            this.Visitations = new HashSet<Visitation>();

            this.Medicaments = new HashSet<Medicament>();
        }



        [Key]
        public int Id { get; set; }

        [Required]
        public string FirstName { get; set; }

        [Required]
        public string LastName { get; set; }

        public string Address { get; set; }

        public string Email { get; set; }

        public byte[] Picture { get; set; }

        public bool HasMedicalInsurance { get; set; }

        public ICollection<Diagnose> Diagnoses { get; set; }

        public ICollection<Visitation> Visitations { get; set; }

        public ICollection<Medicament> Medicaments { get; set; }

    }
}
