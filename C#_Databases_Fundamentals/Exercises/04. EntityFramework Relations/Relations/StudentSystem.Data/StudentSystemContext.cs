namespace StudentSystem.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Migrations;
    using Models;

    public class StudentSystemContext : DbContext
    {
        public StudentSystemContext()
            : base("name=StudentSystemContext")
        {
            Database.SetInitializer(new MigrateDatabaseToLatestVersion<StudentSystemContext, Configuration>());
        }

        public virtual  IDbSet<Student> Students { get; set; }

        public virtual IDbSet<Course> Courses { get; set; }

        public virtual  IDbSet<Homework> Homeworks { get; set; }

        public virtual IDbSet<Resource> Resources { get; set; }
    }
}