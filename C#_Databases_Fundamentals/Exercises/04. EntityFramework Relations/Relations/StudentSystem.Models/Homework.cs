namespace StudentSystem.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class Homework
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public string Content { get; set; }

        [Required]
        public HomeworkType HomeworkType { get; set; }

        [Required]
        public DateTime SubmissionDate { get; set; }

        public virtual Student Student { get; set; }
    }
}
