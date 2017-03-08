namespace StudentSystem.Data.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using Models;

    internal sealed class Configuration : DbMigrationsConfiguration<StudentSystem.Data.StudentSystemContext>
    {
        public Configuration()
        {
            this.AutomaticMigrationsEnabled = false;
            this.ContextKey = "StudentSystem.Data.StudentSystemContext";
        }

        protected override void Seed(StudentSystemContext context)
        {
            context.Courses.AddOrUpdate(
                c => c.Name,
                new Course()
                {
                    Name = "JS fundamentals",
                    Description = "Some JS shit",
                    StartDate = new DateTime(2016, 9, 16),
                    EndTime = new DateTime(2016, 12, 16),
                    Price = 360,
                    Resources =
                    {
                        new Resource()
                        {
                            Name = "jQuery and AJAX",
                            RecType = ResourceType.Video,
                            URL = "https://www.freeresources.com"
                        }
                    },
                    Students =
                    {
                        new Student()
                        {
                            Name = "Roli",
                            PhoneNumber = "0883362697",
                            RegistrationDate = new DateTime(2016, 11, 16),
                            BirthDate = new DateTime(1987, 5, 29),
                            Homeworks =
                            {
                                new Homework()
                                {
                                    Content = "Advanced functions",
                                    HomeworkType = HomeworkType.Application,
                                    SubmissionDate = new DateTime(2016, 10, 12)
                                }
                            }
                        }
                    }
                },
                new Course()
                {
                    Name = "C# Web",
                    Description = "Some C# shit",
                    StartDate = new DateTime(2017, 1, 16),
                    EndTime = new DateTime(2017, 4, 19),
                    Price = 360,
                    Resources =
                    {
                        new Resource()
                        {
                            Name = "Database Migrations",
                            RecType = ResourceType.Presentation,
                            URL = "https://www.freeresources.com"
                        }
                    },
                    Students =
                    {
                        new Student()
                       {
                           Name = "Alis",
                           PhoneNumber = "0888888888",
                           RegistrationDate = new DateTime(2016, 10, 20),
                           BirthDate = new DateTime(1994, 8, 29),
                           Homeworks =
                           {
                               new Homework()
                               {
                                   Content = "Server client communication",
                                   HomeworkType = HomeworkType.Pdf,
                                   SubmissionDate = new DateTime(2017, 1, 18)
                               }
                           }
                       }
                    }
                },
                new Course()
                {
                    Name = "Data Science",
                    Description = "Some Math shit",
                    StartDate = new DateTime(2016, 12, 16),
                    EndTime = new DateTime(2017, 2, 26),
                    Price = 180,
                    Resources =
                    {
                        new Resource()
                        {
                            Name = "Global warming",
                            RecType = ResourceType.Document,
                            URL = "https://www.freeresources.com"
                        }
                    },
                    Students =
                    {
                        new Student()
                        {
                            Name = "Ivan",
                            PhoneNumber = "0894995566",
                            RegistrationDate = new DateTime(2015, 9, 3),
                            BirthDate = new DateTime(1985, 6, 21),
                            Homeworks =
                            {
                                new Homework()
                                {
                                    Content = "Data based decisions",
                                    HomeworkType = HomeworkType.Zip,
                                    SubmissionDate = new DateTime(2017, 2, 3)
                                }
                            }
                        }    
                    }
                });
        }
    }
}
