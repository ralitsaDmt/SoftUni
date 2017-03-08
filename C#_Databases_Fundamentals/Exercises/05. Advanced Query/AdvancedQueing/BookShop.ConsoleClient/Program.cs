namespace BookShop.ConsoleClient
{
    using Data;

    public class Program
    {
        public static void Main()
        {
            BookShopContext context = new BookShopContext();

            context.Database.Initialize(true);
        }
    }
}
