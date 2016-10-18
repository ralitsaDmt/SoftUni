using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class SoftuniCoffeeOrders
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        decimal totalPrice = 0;

        for (int i = 0; i < n; i++)
        {
            decimal orderPrice = 0;

            decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
            string inputDate = Console.ReadLine();
            DateTime orderDate = DateTime.ParseExact(inputDate, "d/M/yyyy", CultureInfo.InstalledUICulture);
            uint capsuleCount = uint.Parse(Console.ReadLine());

            int daysInMonth = DateTime.DaysInMonth(orderDate.Year, orderDate.Month);
            orderPrice = (daysInMonth * capsuleCount) * pricePerCapsule;

            Console.WriteLine($"The price for the coffee is: ${orderPrice:f2}");

            totalPrice += orderPrice;
        }

        Console.WriteLine($"Total: ${totalPrice:f2}");
    }
}
