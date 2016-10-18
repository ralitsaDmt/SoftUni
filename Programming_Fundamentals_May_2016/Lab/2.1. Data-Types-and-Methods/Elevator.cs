using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Elevator
{
    class Elevator
    {
        static void Main(string[] args)
        {
            int numberOfPeople = int.Parse(Console.ReadLine());
            int capacity = int.Parse(Console.ReadLine());

            int courses = 0;

            courses = (int)Math.Ceiling((double)numberOfPeople / capacity);
            //if (numberOfPeople <= capacity)
            //{
            //    courses = 1;
            //}
            //else
            //{
            //    courses = numberOfPeople / capacity;
            //} 

            //if (numberOfPeople % 2 != 0)
            //{
            //    courses++;
            //}
            Console.WriteLine(courses);
        }
    }
}
