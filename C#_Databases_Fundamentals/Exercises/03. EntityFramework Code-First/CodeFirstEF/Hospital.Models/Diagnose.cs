namespace Hospital.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class Diagnose
    {
        [Key]
        public int Id { get; set; }

        public DateTime Date { get; set; }

        public string Comment { get; set; }
    }
}
