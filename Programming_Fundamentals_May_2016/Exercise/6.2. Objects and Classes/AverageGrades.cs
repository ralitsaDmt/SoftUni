using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.Average_Grades
{
    class AverageGrades
    {
        class Student
        {
            public string Name { get; set; }
            public List<double> Grades { get; set; }

            public double AverageGrade()
            {
                return this.Grades.Average();
            }
        }

        static void Main()
        {
            var studentsCount = int.Parse(Console.ReadLine());
            var students = new List<Student>();

            for (int i = 0; i < studentsCount; i++)
            {
                Student instance = ReadStudent();
                students.Add(instance);
            }

            // Using sorted Lis t - 100/100
            var sortedStudents = students.OrderBy(st => st.Name).ThenByDescending(st => st.AverageGrade());
            foreach (var student in sortedStudents)
            {
                if (student.AverageGrade() >= 5.00)
                {
                    Console.WriteLine($"{student.Name} -> {student.AverageGrade():f2}");
                }
            }
            
            // Using SortedDictionary - 85/100

            //var sortedStudents = new SortedDictionary<string, double>();
            //foreach (var st in students)
            //{
            //    sortedStudents[st.Name] = st.AverageGrade();
            //}

            //foreach (var st in sortedStudents)
            //{
            //    if (st.Value >= 5.00)
            //    {
            //        Console.WriteLine($"{st.Key} -> {st.Value:f2}");
            //    }
            //}
        }

        private static Student ReadStudent()
        {
            var instance = new Student();
            var input = Console.ReadLine()
                    .Split()
                    .ToList();

            instance.Name = input[0];
            instance.Grades = new List<double>();
            instance.Grades.AddRange(input.Skip(1).Select(double.Parse));

            return instance;
        }
    }
}
