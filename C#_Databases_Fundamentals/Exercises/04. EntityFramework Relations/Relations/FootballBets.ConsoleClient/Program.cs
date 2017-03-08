namespace FootballBets.ConsoleClient
{
    using Data;

    public class Program
    {
        public static void Main(string[] args)
        {
            FootballBetsContext context = new FootballBetsContext();

            context.Database.Initialize(true);
        }
    }
}
