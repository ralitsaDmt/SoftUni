namespace Hotel.ConsoleClient
{
    using Data;

    public class Program
    {
        public static void Main()
        {
            HotelContext context = new HotelContext();

            context.Database.Initialize(true);
        }
    }
}
