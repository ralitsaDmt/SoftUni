namespace Hospital.ConsoleClient
{
    using Data;

    public class Program
    {
        public static void Main()
        {
            using (HospitalContext context = new HospitalContext())
            {
                context.Database.Initialize(true);
            }
        }
    }
}
