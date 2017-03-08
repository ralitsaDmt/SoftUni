namespace Hospital.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Models;

    public class HospitalContext : DbContext
    {
        public HospitalContext()
            : base("name=HospitalContext")
        {
        }

        public virtual IDbSet<Patient> Patients { get; set; }

        public virtual IDbSet<Diagnose> Dia
        { get; set; }

        public virtual IDbSet<Visitation> Visitations { get; set; }

        public virtual IDbSet<Medicament> Medicaments { get; set; }

        public virtual  IDbSet<Doctor> Doctors
        { get; set; }
    }

    //public class MyEntity
    //{
    //    public int Id { get; set; }
    //    public string Name { get; set; }
    //}
}