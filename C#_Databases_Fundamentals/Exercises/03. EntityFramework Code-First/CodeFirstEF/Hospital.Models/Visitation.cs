namespace Hospital.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class Visitation
    {
        [Key]
        public int Id { get; set; }

        public DateTime Date { get; set; }

        public string Comment { get; set; }

        public Doctor Doctor { get; set; }
    }
}
