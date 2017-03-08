namespace BillsPayment.ConsoleClient
{
    using Data;

    public class Program
    {
        public static void Main()
        {
            BillsPaymentContext context = new BillsPaymentContext();

            context.Database.Initialize(true);
        }
    }
}
