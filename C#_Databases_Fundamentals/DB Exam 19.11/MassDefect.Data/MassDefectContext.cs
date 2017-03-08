namespace MassDefect.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Models;

    public class MassDefectContext : DbContext
    {
        public MassDefectContext()
            : base("name=MassDefectContext")
        {
        }

        public virtual IDbSet<Anomaly> Anomalies{ get; set; }

        public virtual IDbSet<Person> Persons { get; set; }

        public virtual IDbSet<Planet> Planets { get; set; }

        public virtual IDbSet<SolarSystem> SolarSystems { get; set; }

        public virtual IDbSet<Star> Stars { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            // Anomaly - Origin Planet
            modelBuilder.Entity<Anomaly>()
                .HasRequired(a => a.OriginPlanet)
                .WithMany(p => p.OriginAnomalies)
                .HasForeignKey(a => a.OriginPlanetId)
                .WillCascadeOnDelete(false);

            // Anomaly - Teleport Planet
            modelBuilder.Entity<Anomaly>()
                .HasRequired(a => a.TeleportPlanet)
                .WithMany(p => p.TeleportAnomalies)
                .HasForeignKey(a => a.TeleportPlanetId)
                .WillCascadeOnDelete(false);

            // Anomaly - People

            modelBuilder.Entity<Anomaly>()
                .HasMany(a => a.Victims)
                .WithMany(p => p.Anomalies)
                .Map(m =>
                {
                    m.MapLeftKey("AnomalyId");
                    m.MapRightKey("PersonId");
                    m.ToTable("AnomalyVictims");
                });

            // Star - SolarSystem

            modelBuilder.Entity<Star>()
                .HasRequired(s => s.SolarSystem)
                .WithMany(ss => ss.Stars)
                .HasForeignKey(s => s.SolarSystemId)
                .WillCascadeOnDelete(false);
        }
    }
}