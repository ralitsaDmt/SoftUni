namespace MassDefect.Models
{
    using System.Collections;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    public class Person
    {
        private ICollection<Anomaly> anomalies;

        public Person()
        {
            this.anomalies = new HashSet<Anomaly>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [ForeignKey("HomePlanet")]
        public int HomePlanetId { get; set; }

        public virtual Planet HomePlanet { get; set; }
        
        public virtual ICollection<Anomaly> Anomalies
        {
            get { return this.anomalies; }
            set { this.anomalies = value; }
        }
    }
}
