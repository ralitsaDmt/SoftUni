namespace MassDefect.ConsoleClient
{
    using Data;

    public class Program
    {
        public static void Main(string[] args)
        {
            MassDefectContext context = new MassDefectContext();

            context.Database.Initialize(true);
        }
    }
}
