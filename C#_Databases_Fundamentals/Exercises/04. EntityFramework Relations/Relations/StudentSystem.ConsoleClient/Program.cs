namespace StudentSystem.ConsoleClient
{
    using System;
    using System.Linq;
    using Data;
    using Models;

    public class Program
    {
        public static void Main()
        {
            StudentSystemContext context = new StudentSystemContext();

            //context.Database.Initialize(true);

            using (context)
            {
                //ListAllStudentsWithHomeworkSubmitions(context);

                //ListResources(context);

                //ListCoursesWithMoreThan5Resources(context);

                //ListActiveCourses(context);

                //NumberOfCoursesForStudent(context);
            }
        }

        private static void NumberOfCoursesForStudent(StudentSystemContext context)
        {
            var students = context.Students.Select(s => s)
                .ToList()
                .OrderByDescending(st => st.Courses.Sum(c => c.Price))
                .ThenByDescending(st => st.Courses.Count)
                .ThenBy(st => st.Name);

            foreach (Student student in students)
            {
                Console.WriteLine($"Student: {student.Name}");
                int count = student.Courses.Count;
                decimal totalPrice = student.Courses.Sum(c => c.Price);

                decimal averagePrice = 0;
                if (count > 0)
                {
                    averagePrice = totalPrice / count;
                }
                
                Console.WriteLine($"Info: {count} courses, total price: {totalPrice}, average price: {averagePrice:f2}");
            }
        }

        private static void ListActiveCourses(StudentSystemContext context)
        {
            DateTime targetDate = new DateTime(2016, 11, 16);
            var courses = context.Courses
                .Where(c => c.StartDate <= targetDate && c.EndTime >= targetDate)
                .ToList()
                .OrderByDescending(c => c.Students.Count)
                .ThenByDescending(c => c.Duration);

            foreach (Course course in courses)
            {
                Console.WriteLine($"Course name: {course.Name}");
                Console.WriteLine($"Starts: {course.StartDate}, Ends: {course.EndTime}");
                Console.WriteLine($"Duration: {course.Duration.TotalDays}");
                Console.WriteLine($"Students enrolled: {course.Students.Count}");
            }
        }

        private static void ListCoursesWithMoreThan5Resources(StudentSystemContext context)
        {
            var courses = context.Courses.Where(c => c.Resources.Count > 5)
                .OrderByDescending(c => c.Resources.Count)
                .ThenBy(c => c.StartDate);

            foreach (Course course in courses)
            {
                Console.WriteLine($"Course: {course.Name}, Recourses count: {course.Resources.Count}");
            }

        }

        private static void ListResources(StudentSystemContext context)
        {
            var courses = context.Courses.Select(c => c)
                .OrderBy(c => c.StartDate)
                .ThenByDescending(c => c.EndTime);

            foreach (Course course in courses)
            {
                Console.WriteLine($"{course.Name} - {course.Description}");

                foreach (Resource resource in course.Resources)
                {
                    Console.WriteLine($"{resource.Name} ({resource.RecType}) - {resource.URL}");
                }
            }

        }

        private static void ListAllStudentsWithHomeworkSubmitions(StudentSystemContext context)
        {
            var students = context.Students.Select(s => s);

            foreach (Student student in students)
            {
                Console.WriteLine($"Student name: {student.Name}");
                Console.WriteLine($"    Homeworks:");

                foreach (Homework homework in student.Homeworks)
                {
                    Console.WriteLine($"    --{homework.Content} - {homework.HomeworkType}");
                }
            }
        }
    }
}
