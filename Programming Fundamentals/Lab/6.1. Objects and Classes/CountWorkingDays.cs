using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.Count_Working_Days
{
    class WorkDay
    {
        public int Day { get; set; }
        public int Month { get; set; }
        public string DayOfWeek { get; set; }

        public bool IsWorkDay(WorkDay date)
        {
            return ((date.Day != 1 || date.Month != 1) &&
                (date.Day != 3 || date.Month != 3) &&
                (date.Day != 1 && date.Day != 6 && date.Day != 24 || date.Month != 5) &&
                (date.Day != 6 && date.Day != 22 || date.Month != 9) &&
                (date.Day != 1 || date.Month != 11) &&
                (date.Day != 24 && date.Day != 25 && date.Day != 26 || date.Month != 12) &&
                (date.DayOfWeek != "saturday") &&
                (date.DayOfWeek != "sunday"));
        }
    }

    class CountWorkingDays
    {
        static void Main(string[] args)
        {
            string date1Text = Console.ReadLine();
            string date2Text = Console.ReadLine();

            DateTime date1 = DateTime.ParseExact(date1Text,
                "dd-MM-yyyy", CultureInfo.InvariantCulture);
            DateTime date2 = DateTime.ParseExact(date2Text,
    "dd-MM-yyyy", CultureInfo.InvariantCulture);

            int count = 0;

            for (DateTime date = date1; date <= date2; date = date.AddDays(1))
            {
                WorkDay current = new WorkDay();
                current.Day = date.Day;
                current.Month = date.Month;
                current.DayOfWeek = date.DayOfWeek.ToString().ToLower();

                if (current.IsWorkDay(current))
                {
                    count++;
                }
            }

            Console.WriteLine(count);

        }
    }
}
