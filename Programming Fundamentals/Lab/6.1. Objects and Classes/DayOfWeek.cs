using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Day_of_Week   
{
    class DayOfWeek
    {
        static void Main(string[] args)
        {
            var dateStr = Console.ReadLine();
            var token = dateStr.Split('-').Select(int.Parse).ToArray();
            var date = new DateTime(token[2], token[1], token[0]);
            Console.WriteLine(date.DayOfWeek);


            //string dateAsText = Console.ReadLine();
            //DateTime date = DateTime.ParseExact(dateAsText, "d-M-yyyy",
            //    CultureInfo.InvariantCulture);
            //Console.WriteLine(date.DayOfWeek);
        }
    }
}
